/* FRC 4183 - The Bit Buckets
 * Tucson, AZ
 *
 * FRC 2014 Codebase
 */
package org.bitbuckets.frc2014.commands;

import org.bitbuckets.frc2014.RandomConstants;

/**
 * Fires the catapult.
 * 
 * @author Cal Miller cal@bpmpc.net (Probably)
 */
public class Fire extends CommandBase {
    /** The time when the command is initialized. **/
    private long timeInit;
    
    /**
     * Makes a new Fire command. Tells the robot that it needs the catapult subsystem to run.
     */
    public Fire() {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
        requires(catapult);
    }

    /**
     * Called when the command is initialized. Neutralizes the shifter, sets the initial time, and starts running the motors.
     */
    protected void initialize() {
        catapult.setShifterNeutral();
        timeInit = System.currentTimeMillis();
        catapult.setWinchMotorsReverse();
    }

    /**
     * Called repeatedly when this Command is scheduled to run. Keeps the winch motors on and the watchdog happy.
     */
    protected void execute() {
        catapult.setWinchMotorsReverse();
    }

    /**
     * Returns true when the command is finished. Checks to see if the winch has rewound for enough time.
     * 
     * @return true if the winch motors have rewound for a satisfactory amount of time.
     */
    protected boolean isFinished() {
        return (System.currentTimeMillis() - timeInit> RandomConstants.FIRE_REVERSE_MILLIS);
    }

    /**
     * Called once after isFinished returns true. Turns the winch motors off and fires the catapult.
     */
    protected void end() {
        catapult.setLatchOpen();
        catapult.setWinchMotorsOff();
    }

    /**
     * Called when another command which requires one or more of the same
     * subsystems is scheduled to run.
     */
    protected void interrupted() {
    }
}
