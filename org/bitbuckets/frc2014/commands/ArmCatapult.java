/* FRC 4183 - The Bit Buckets
 * Tucson, AZ
 *
 * FRC 2014 Codebase
 */

package org.bitbuckets.frc2014.commands;

import org.bitbuckets.frc2014.RandomConstants;

/**
 *
 * @author Default.
 */

public class ArmCatapult extends CommandBase {
    /** Timer for calculating winching time */
    private long winchTime;
    
    /**
     * Makes a new UnFire command.
     */
    public ArmCatapult() {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
        requires(catapult);
    }

    /**
     * Called just before this Command runs the first time.
     */
    protected void initialize() {
        catapult.setShifterActive();
        catapult.setLatchClosed();
        winchTime = System.currentTimeMillis();
        System.out.println("Initialized ArmCatapult.");
    }

    /**
     * Called repeatedly when this Command is scheduled to run.
     */
    protected void execute() {
        catapult.setWinchMotorsOn();
    }

    /**
     * Make this return true when this Command no longer needs to run execute().
     * 
     * @return Returns true if the catapult is retracted.
     */
    protected boolean isFinished() {
        return (catapult.getRetracted() || System.currentTimeMillis() - winchTime >= RandomConstants.WINCH_TIMEOUT);
    }

    /**
     * Called once after isFinished returns true.
     */
    protected void end() {
        catapult.setWinchMotorsOff();
        catapult.setLatchClosed();
        System.out.println("Winching time: " + (System.currentTimeMillis() - winchTime));
    }

    /**
     * Called when another command which requires one or more of the same
     *  subsystems is scheduled to run
     */
    protected void interrupted() {
    }
}
