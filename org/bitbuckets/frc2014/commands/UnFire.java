/* FRC 4183 - The Bit Buckets
 * Tucson, AZ
 *
 * FRC 2014 Codebase
 */

package org.bitbuckets.frc2014.commands;

/**
 *
 * @author Default.
 */
public class UnFire extends CommandBase {
    /**
     * Makes a new UnFire command.
     */
    public UnFire() {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
        requires(catapult);
    }

    /**
     * Called just before this Command runs the first time.
     */
    protected void initialize() {
        catapult.setCatapaultFired(false);
    }

    /**
     * Called repeatedly when this Command is scheduled to run.
     */
    protected void execute() {
        catapult.setCatapaultRetracted(true);
    }

    /**
     * Make this return true when this Command no longer needs to run execute().
     * 
     * @return Returns true if the catapult is retracted.
     */
    protected boolean isFinished() {
        return catapult.retracted.get();
//        return true;
    }

    /**
     * Called once after isFinished returns true.
     */
    protected void end() {
        catapult.setCatapaultRetracted(false);
    }

    /**
     * Called when another command which requires one or more of the same
     *  subsystems is scheduled to run
     */
    protected void interrupted() {
        catapult.setCatapaultRetracted(false);
    }
}
