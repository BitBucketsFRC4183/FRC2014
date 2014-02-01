/* FRC 4183 - The Bit Buckets
 * Tucson, AZ
 *
 * FRC 2014 Codebase
 */

package org.bitbuckets.frc2014.commands;

/**
 * @author    Cal Miller cal@bpmpc.net
 * 
 * <description>
 */
public class IntakeBallOff extends CommandBase {
    /**
     * Creates a new IntakeBallOff command.
     */
    public IntakeBallOff() {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
        requires(intake);
    }

    /**
     * Called just before this Command runs the first time.
     */
    protected void initialize() {
        intake.setDeployed(false);//Brings intake the intake.
        intake.setIntakeRoller(0);//Stops the roller.
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
