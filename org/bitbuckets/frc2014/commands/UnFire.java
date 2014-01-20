
package org.bitbuckets.frc2014.commands;

/**
 *
 * @author bradmiller
 */
public class UnFire extends CommandBase {

    public UnFire() {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
        requires(cp);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
        cp.setCatapaultFired(false);
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
        //cp.setCatapaultRetracted(true);
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        //return cp.retracted.get();
        return true;
    }

    // Called once after isFinished returns true
    protected void end() {
        //cp.setCatapaultRetracted(false);
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
        cp.setCatapaultRetracted(false);
    }
}
