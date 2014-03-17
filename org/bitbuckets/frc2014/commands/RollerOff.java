/* FRC 4183 - The Bit Buckets
 * Tucson, AZ
 *
 * FRC 2014 Codebase
 */

package org.bitbuckets.frc2014.commands;

import org.bitbuckets.frc2014.RandomConstants;

/**
 *
 * @author Deafault
 */
public class RollerOff extends CommandBase {
    /**
     * Makes a new RollerOff command.
     */
    public RollerOff() {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
        requires(intake);
    }

    /**
     * Called when the command is initialized.
     */
    protected void initialize() {
        intake.setIntakeRoller(RandomConstants.INTAKE_OFF);//Turns the roller off.
    }

    /**
     * Called repeatedly when this Command is scheduled to run.
     */
    protected void execute() {
    }

    /**
     * Make this return true when this Command no longer needs to run execute().
     * 
     * @return Always returns true. 
     */
    protected boolean isFinished() {
        return true;//Stops the command from running indefinately.
    }

    /**
     * Called once after isFinished returns true.
     */
    protected void end() {
    }

    /**
     * Called when another command which requires one or more of the same
       subsystems is scheduled to run.
     */
    protected void interrupted() {
    }
}
