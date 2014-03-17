/* FRC 4183 - The Bit Buckets
 * Tucson, AZ
 *
 * FRC 2014 Codebase
 */
package org.bitbuckets.frc2014.commands;

/**
 * Deploys the intake pistons, letting the ball go in or out.
 * 
 * @author James Wyeth james.wyeth@gmail.com
 */
public class IntakeDeploy extends CommandBase {

    /**
     * Makes a new IntakeDeploy command. Tells the robot that it needs the intake subsystem to run.
     */
    public IntakeDeploy() {
        requires(intake);
    }

    /**
     * Called when the command is initialized. Drops the intake.
     */
    protected void initialize() {
        intake.setDeployed(false);
    }

    /**
     * Called repeatedly while this Command is running.
     */
    protected void execute() {
    }

    /**
     * Returns true when the command is finished. Always returns true.
     * 
     * @return true.
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
