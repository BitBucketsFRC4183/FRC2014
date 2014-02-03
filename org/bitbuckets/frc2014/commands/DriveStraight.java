/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.bitbuckets.frc2014.commands;

import edu.wpi.first.wpilibj.command.PIDCommand;
import org.bitbuckets.frc2014.RandomConstants;

/**
 *
 * @author Alia
 */
public class DriveStraight extends PIDCommand {
    private int state;
    private double distance;
    private double maxVel;
    private long timeInit;
    private boolean finish = false;
    
    public DriveStraight(int dist, int vel) {
        super("DriveStriaght", RandomConstants.INCH_PID_KP, RandomConstants.INCH_PID_KI, RandomConstants.INCH_PID_KD);
        distance = dist;
        maxVel = vel;
        setSetpoint(0);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
        timeInit = System.currentTimeMillis();
        state = 1;
    }

    // Called repeatedly when this Command is scheduled to run
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
                finish = true;
                break;
        }
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return finish;
    }

    // Called once after isFinished returns true
    protected void end() {
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }

    protected double returnPIDInput() {
        return (CommandBase.driveTrain.getEncRateL() + CommandBase.driveTrain.getEncRateR())/2;
    }

    protected void usePIDOutput(double output) {
        CommandBase.driveTrain.tankDrive(output, output);
    }
}
