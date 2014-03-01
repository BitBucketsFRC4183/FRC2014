/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.bitbuckets.frc2014.commands;

/**
 *
 * @author Cal Miller
 */
public class DriveTimeMillis extends CommandBase {
    
    private double power, rotation;
    private long time, timeInit;
    
    public DriveTimeMillis(double power, double rotation, long time) {
        requires(driveTrain);
        
        this.power = power;
        this.rotation = rotation;
        this.time = time;
    }

    // Called just before this Command runs the first time
    protected void initialize() {
        timeInit = System.currentTimeMillis();
        driveTrain.drive(power, rotation);
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
        driveTrain.drive(power, rotation);
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return System.currentTimeMillis() - timeInit >= time;
    }

    // Called once after isFinished returns true
    protected void end() {
            driveTrain.drive(0, 0);
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}
