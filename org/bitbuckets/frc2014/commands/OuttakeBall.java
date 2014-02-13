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
public class OuttakeBall extends CommandBase {

    /**
     * Creates a new OuttakeBall command.
     */
    public OuttakeBall() {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
        requires(intake);
    }

    /**
     * Called just before this Command runs the first time.
     */
    protected void initialize() {
        //in.setDeployed(true);//Makes the intake go out.
        intake.setIntakeRoller(RandomConstants.INTAKE_BACKWARDS);//Makes the roller go backwards.
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
     * subsystems is scheduled to run.
     */
    protected void interrupted() {
    }
}
