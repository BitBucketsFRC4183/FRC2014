/* FRC 4183 - The Bit Buckets
 * Tucson, AZ
 *
 * FRC 2014 Codebase
 */
package org.bitbuckets.frc2014.commands;

import edu.wpi.first.wpilibj.SpeedController;

/**
 * Drives a specified speed controller for a certain time at a specified speed.
 * 
 * @author James Wyeth james.wyeth@gmail.com
 */
public class MotorDriveTime extends CommandBase {
    /** The speed controller the motor to drive is connected to. **/
    private SpeedController motor;
    /** The time when the command was started. Used to check the time the motor has driven for. **/
    private long timeInit;
    /** The speed at which the motor is run. A double from 0 to 1. **/
    private double speed;
    /** The amount of time the motor is run in milliseconds. **/
    private int time;
    
    /**.
     * The constructor. Sets the fields.
     * 
     * @param controller The speed controller the motor to drive is connected to.
     * @param speedPercent The speed at which the motor is run. A double from 0 to 1.
     * @param timeMillis The amount of time the motor should be run in milliseconds.
     */
    public MotorDriveTime(SpeedController controller, double speedPercent, int timeMillis) {
        motor = controller;
        speed = speedPercent;
        time = timeMillis;
    }

    /**
     * Initializes the command by sitting the initial time.
     */
    protected void initialize() {
        timeInit = System.currentTimeMillis();
    }

    /**
     * Called repeatedly. Set the speed of the motor.
     */
    protected void execute() {
        motor.set(speed);
    }

    /**
     * Tells the controller whether the command is finished.
     * 
     * @return Returns <code>true</code> if the command is finished. <code>false</code> otherwise.
     */
    protected boolean isFinished() {
        return System.currentTimeMillis() - timeInit >= time;
    }

    /**
     * The code to run after <code>isFinished</code> returns true. Stops the motor.
     */
    protected void end() {
        motor.set(0);
    }

    /**
     * The code to run if the command is interrupted. Calls <code>end()</code>.
     */
    protected void interrupted() {
    }
}
