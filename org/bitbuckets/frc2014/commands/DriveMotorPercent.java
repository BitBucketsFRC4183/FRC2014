
package org.bitbuckets.frc2014.commands;

import edu.wpi.first.wpilibj.SpeedController;

/**
 *
 * @author bradmiller
 */

public class DriveMotorPercent extends CommandBase {
    
    private int time;
    private double speed;
    private SpeedController controlSpeed;
    private long initTime;
    
    public DriveMotorPercent(int time, int speed, SpeedController controlSpeed) {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
        this.time = time;
        this.controlSpeed= controlSpeed;
        this.speed = speed;
    }

    // Called just before this Command runs the first time
    protected void initialize() {
        initTime = System.currentTimeMillis();
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
        controlSpeed.set(speed);
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return System.currentTimeMillis() - initTime >= time;
    }

    // Called once after isFinished returns true
    protected void end() {
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}
