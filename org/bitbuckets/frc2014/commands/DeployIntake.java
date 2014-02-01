/* FRC 4183 - The Bit Buckets
 * Tucson, AZ
 *
 * FRC 2014 Codebase
 */

package org.bitbuckets.frc2014.commands;

/**
 * @author    James Wyeth james.wyeth@gmail.com
 * 
 * Deploys intake
 */
public class DeployIntake extends CommandBase {

    /**
     * This constructor makes a new DeployIntake command.
     */
    public DeployIntake() {
        requires(intake);
    }

    /**
     * This initializes DeployIntake to make it set and deployed.
     */
    protected void initialize() {
        intake.setDeployed(true);//Makes the intake go down.
    }

    /**
     * Called repeatedly when this Command is scheduled to run.
     * 
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
