
package org.bitbuckets.frc2014.commands;

/**
 *
 * @author bradmiller
 */
public class Fire extends CommandBase {

    public Fire() {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
        requires(cp);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
        cp.setCatapaultFired(true);//Makes the catapault go up
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return true;//Stops the command from running indefinately.
    }

    // Called once after isFinished returns true
    protected void end() {
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}
