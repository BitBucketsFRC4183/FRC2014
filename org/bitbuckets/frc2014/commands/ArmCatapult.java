/* FRC 4183 - The Bit Buckets
 * Tucson, AZ
 *
 * FRC 2014 Codebase
 */
package org.bitbuckets.frc2014.commands;

import org.bitbuckets.frc2014.RandomConstants;

/**
 * The command that arms the catapult so it can fire.
 *
 * @author Cal Miller cal@bpmpc.net
 */

public class ArmCatapult extends CommandBase {
    /** Timer for calculating winching time **/
    private long winchTime;
    
    /**
     * Makes a new ArmCatapult command. Tells the robot that it needs the catapult subsystem to run.
     */
    public ArmCatapult() {
        requires(catapult);
    }

    /**
     * Called when the command is initialized. Shifts winch into gear, closes the firing latch, and sets the initial time.
     */
    protected void initialize() {
        catapult.setShifterActive();
        catapult.setLatchClosed();
        winchTime = System.currentTimeMillis();
    }

    /**
     * Called repeatedly while this Command is running. Keeps the winch motors on and the watchdog happy.
     */
    protected void execute() {
        catapult.setWinchMotorsOn();
    }

    /**
     * Returns true when the command is finished. Checks to see if the winch has retracted fully, or if the time passed has been greater than the maximum allowed time, in case of stalling. This was implemented after burning out a mini-CIM.
     * 
     * @return true if the catapult is retracted.
     */
    protected boolean isFinished() {
        return (catapult.getRetracted() || System.currentTimeMillis() - winchTime >= RandomConstants.WINCH_TIMEOUT);
    }

    /**
     * Called once after isFinished returns true. Turns the winch motors off.
     */
    protected void end() {
        catapult.setWinchMotorsOff();
    }

    /**
     * Called when another command which requires one or more of the same
     *  subsystems is scheduled to run.
     */
    protected void interrupted() {
    }
}
