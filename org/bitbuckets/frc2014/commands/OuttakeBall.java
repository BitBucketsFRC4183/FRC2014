
package org.bitbuckets.frc2014.commands;

/**
 *
 * @author bradmiller
 */
public class OuttakeBall extends CommandBase {

    public OuttakeBall() {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
        requires(in);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
        in.setDeployed(true);//Makes the intake go out.
        in.setIntakeRoller(1);//Makes the roller go backwards.
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
