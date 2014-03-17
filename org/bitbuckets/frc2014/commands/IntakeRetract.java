/* FRC 4183 - The Bit Buckets
 * Tucson, AZ
 *
 * FRC 2014 Codebase
 */
package org.bitbuckets.frc2014.commands;

/**
 * Retracts the intake.
 * 
 * @author James Wyeth james.wyeth@gmail.com
 */
public class IntakeRetract extends CommandBase {
    
    /**
     * Makes a new ArmCatapult command. Tells the robot that it needs the intake subsystem to run.
     */
    public IntakeRetract() {
        requires(intake);
    }

    /**
     * Called when the command is initialized.
     */
    protected void initialize() {
        intake.setDeployed(true);//Brings intake the intake.
    }

    /**
     * Called repeatedly while this Command is running. Does nothing, as this command doesn't run anything continuously.
     */
    protected void execute() {
    }

    /**
     * Returns true when the command is finished. This command doesn't do anything continuously so it will always return true, stopping the command immediately after initialize() is called.
     * 
     * @return true.
     */
    protected boolean isFinished() {
        return true;
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
