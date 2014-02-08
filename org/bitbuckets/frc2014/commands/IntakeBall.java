/* FRC 4183 - The Bit Buckets
 * Tucson, AZ
 *
 * FRC 2014 Codebase
 */

package org.bitbuckets.frc2014.commands;

import org.bitbuckets.frc2014.RandomConstants;

/**
 * @author    Cal Miller cal@bpmpc.net
 * 
 * <description>
 */
public class IntakeBall extends CommandBase {
    /**
     * Creates a new IntakeBall command.
     */
    public IntakeBall() {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
        requires(intake);
    }

    /**
     * Called just before this Command runs the first time.
     */
    protected void initialize() {
        intake.setDeployed(true);//Makes the intake go down.
        intake.setIntakeRoller(RandomConstants.INTAKE_FORWARDS);//Makes intake pull stuff.
    } 

    /**
     * Called repeatedly when this Command is scheduled to run.
     */
    protected void execute() {
    }

    /**
     * Make this return true when this Command no longer needs to run execute().
     * 
     * @return 
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
