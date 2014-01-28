
package org.bitbuckets.frc2014.commands;

import edu.wpi.first.wpilibj.Joystick;

/**
 *
 * @author bradmiller
 */
public class DriveTeleop extends CommandBase {

    public DriveTeleop() {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
        requires(driveTrain);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
        driveTrain.drive(CommandBase.oi.stick.getAxis(Joystick.AxisType.kX), CommandBase.oi.stick.getAxis(Joystick.AxisType.kY));//our axis are reversed
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
}
