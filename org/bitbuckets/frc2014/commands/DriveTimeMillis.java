/* FRC 4183 - The Bit Buckets
 * Tucson, AZ
 *
 * FRC 2014 Codebase
 */
package org.bitbuckets.frc2014.commands;

/**
 * Drives the robot for a specified time at a specified speed turning a specified amount.
 *
 * @author Cal Miller cal@bpmpc.net
 */
public class DriveTimeMillis extends CommandBase {
    /** The speed at which to drive. **/
    private double power;
    /** The amount of turning power to use. **/
    private double rotation;
    /** The time the robot needs to drive for. **/
    private long time;
    /** The time at which the command was initialized. **/
    private long timeInit;
    
    /**
     * Makes a new DriveTimeMillis command. Tells the robot that it needs the drivetrain subsystem to run and sets up the variables.
     * 
     * @param power The speed at which to drive.
     * @param rotation The amount of turning power to use.
     * @param time The time the robot needs to drive for.
     */
    public DriveTimeMillis(double power, double rotation, long time) {
        requires(driveTrain);
        
        this.power = power;
        this.rotation = rotation;
        this.time = time;
    }

    /**
     * Called when the command is initialized. Sets the time the command is initialized and starts the driving of the robot.
     */
    protected void initialize() {
        timeInit = System.currentTimeMillis();
        driveTrain.drive(power, rotation);
    }

    /**
     * Keeps the robot driving and the watchdog happy.
     */
    protected void execute() {
        driveTrain.drive(power, rotation);
    }

    /**
     * Returns true when the command is finished. Checks to see if the time is up.
     * 
     * @return true if the time is up or over.
     */
    protected boolean isFinished() {
        return System.currentTimeMillis() - timeInit >= time;
    }

    /**
     * Called once after isFinished returns true. Stops the drivetrain.
     */
    protected void end() {
            driveTrain.drive(0, 0);
    }

    /**
     * Called when another command which requires one or more of the same
     *  subsystems is scheduled to run.
     */
    protected void interrupted() {
    }
}
