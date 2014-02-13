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
public class DriveStraight extends PIDCommand {
    private int state;
    private double distance;
    private double maxVel;
    private long timeInit;
    
    /**
     * 
     * 
     * @param dist
     * @param vel 
     */
    public DriveStraight(int dist, double vel) {
        super("DriveStriaght", RandomConstants.INCH_PID_KP, RandomConstants.INCH_PID_KI, RandomConstants.INCH_PID_KD);
        distance = dist;
        maxVel = vel;
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
                setSetpoint(RandomConstants.INCH_MAX_ACCEL*(System.currentTimeMillis()-timeInit)/1000);
                if(getSetpoint() >= maxVel){
                    state = 2;
                }
                if((CommandBase.driveTrain.getEncDistL() + CommandBase.driveTrain.getEncDistR()) >= distance){
                    state = 3;
                    maxVel = getSetpoint();
                    timeInit = System.currentTimeMillis();
                }
                break;
            case 2:
                setSetpoint(maxVel);
                //the distance under the last trapezoid of the curve
                if(distance - (CommandBase.driveTrain.getEncDistL() + CommandBase.driveTrain.getEncDistR())/2 <= (maxVel*maxVel)/RandomConstants.INCH_MAX_ACCEL){
                    state = 4;
                    timeInit = System.currentTimeMillis();
                }
                break;
            case 3:
                setSetpoint(maxVel-RandomConstants.INCH_MAX_ACCEL*(System.currentTimeMillis()-timeInit)/1000);
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

    /**
     * 
     */
    protected void end() {
    }

    /**
     * 
     */
    protected void interrupted() {
    }

    /**
     * 
     * 
     * @return 
     */
    protected double returnPIDInput() {
        return (CommandBase.driveTrain.getEncRateL() + CommandBase.driveTrain.getEncRateR())/2;
    }

    /**
     * 
     * 
     * @param output 
     */
    protected void usePIDOutput(double output) {
        CommandBase.driveTrain.tankDrive(output, output);
    }
}
