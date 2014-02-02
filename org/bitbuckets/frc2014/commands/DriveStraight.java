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
    
    public DriveStraight() {
        super("DriveStriaght", RandomConstants.INCH_PID_KP, RandomConstants.INCH_PID_KI, RandomConstants.INCH_PID_KD);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return false;
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
        CommandBase.driveTrain.autonDrive(output, output);
    }
}
