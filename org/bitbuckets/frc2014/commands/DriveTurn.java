/* FRC 4183 - The Bit Buckets
 * Tucson, AZ
 *
 * FRC 2014 Codebase
 */
package org.bitbuckets.frc2014.commands;

import edu.wpi.first.wpilibj.command.PIDCommand;
import org.bitbuckets.frc2014.RandomConstants;

/**
 *
 * @author James Wyeth james.wyeth@gmail.com
 */
public class DriveTurn extends PIDCommand {
    private int sign;
    private int state;
    private double angle;
    private double maxVel;
    private long timeInit;
    
    public DriveTurn(double ang, double vel) {
        super("DriveTurn", RandomConstants.DEG_PID_KP, RandomConstants.DEG_PID_KI, RandomConstants.DEG_PID_KD);
        angle = ang;
        maxVel = vel;
        sign = ang > 0? 1 : -1;
        setSetpoint(0);
    }

    /**
     * 
     */
    protected void initialize() {
        timeInit = System.currentTimeMillis();
        state = 1;
    }

    /**
     * 
     */
    protected void execute() {
        switch(state){
            case 1:
                setSetpoint(RandomConstants.DEG_MAX_ACCEL*(System.currentTimeMillis()-timeInit)/1000);
                if(getSetpoint() >= maxVel){
                    state = 2;
                }
                if(CommandBase.driveTrain.getGyroAngle() >= angle/2){
                    state = 3;
                    maxVel = getSetpoint();
                    timeInit = System.currentTimeMillis();
                }
                break;
            case 2:
                setSetpoint(maxVel);
                //the distance under the last trapezoid of the curve
                if(angle - CommandBase.driveTrain.getGyroAngle() <= (maxVel*maxVel)/RandomConstants.DEG_MAX_ACCEL){
                    state = 4;
                    timeInit = System.currentTimeMillis();
                }
                break;
            case 3:
                setSetpoint(maxVel-RandomConstants.DEG_MAX_ACCEL*(System.currentTimeMillis()-timeInit)/1000);
                if(getSetpoint() <= 0){
                    state = 4;
                }
                break;
            case 4:
                setSetpoint(0);
                state = 5;
                break;
        }
    }

    /**
     * 
     * 
     * @return 
     */
    protected boolean isFinished() {
        return state == 5;
    }

    // Called once after isFinished returns true
    protected void end() {
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }

    protected double returnPIDInput() {
        return (Math.abs(CommandBase.driveTrain.getEncRateL()) + Math.abs(CommandBase.driveTrain.getEncRateR()))/2;
    }

    protected void usePIDOutput(double output) {
        CommandBase.driveTrain.tankDrive(output*sign, -output*sign);
    }
}
