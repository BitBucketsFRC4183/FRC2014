/* FRC 4183 - The Bit Buckets
 * Tucson, AZ
 *
 * FRC 2014 Codebase
 */

package org.bitbuckets.frc2014.subsystems;

import edu.wpi.first.wpilibj.RobotDrive;
import edu.wpi.first.wpilibj.command.Subsystem;
import org.bitbuckets.frc2014.RandomConstants;
import org.bitbuckets.frc2014.RobotMap;
import java.lang.Math;

/**
 * @author James Wyeth    
 * 
 * Collection of actuators and sensors that form the drive train subsystem.
 */
public class DriveTrain extends Subsystem {
    /** Base driving system standard in wpilibj */
    public RobotDrive drive;
    /** Forward/backward power ranging from -1 (backwards) to 1 (forwards). */
    private double throttle = 0;
    /** Rotational power ranging from -1 (counter clockwise) to 1 (clockwise). */
    private double rotation = 0;
    /** Left throttle for tank drive. Ranges from -1(backwards) to 1(forwards). **/
    private double throttleLeft = 0;
    /** Right throttle for tank drive. Ranges from -1(backwards) to 1(forwards). **/
    private double throttleRight = 0;
    
    /**
     * Drivetrain constructor, sets up basic robot drive.
     */
    public DriveTrain() {
        super();
        drive  = new RobotDrive(RobotMap.R_MOTOR_A, RobotMap.R_MOTOR_B, RobotMap.L_MOTOR_A, RobotMap.L_MOTOR_B);
        drive.setExpiration(.25);
    }

    /**
     * Default command to run when subsystems are all initialized.
     */
    public void initDefaultCommand() {

    }
    
    /**
     * Basic tank driving method.  Can be used in autonomous and teleop.
     * 
     * @param left The left joystick throttle. Ranges from -1(backwards) to 1(forwards).
     * @param right The right joystick throttle. Ranges from -1(backwards) to 1(forwards).
     */
    public void tankDrive(double left, double right){
        throttleLeft = accelerationLimiter(throttleLeft, left, RandomConstants.MAX_TANK_CHANGE);
        throttleRight = accelerationLimiter(throttleRight, right, RandomConstants.MAX_TANK_CHANGE);
        drive.tankDrive(throttleLeft, throttleRight);
    }
    
    /**
     * Basic arcade driving method. Can be used in autonomous and teleop.
     * 
     * @param outputMagnitude The forward/backward power from -1 (backwards) to 1 (forward).
     * @param curve The rotational power from -1 (counterclockwise) to 1 (clockwise).
     */
    public void drive(double outputMagnitude, double curve){
        throttle = accelerationLimiter(throttle, outputMagnitude, RandomConstants.MAX_MAG_CHANGE);
        rotation = accelerationLimiter(rotation, curve, RandomConstants.MAX_CUR_CHANGE);
        drive.arcadeDrive(-throttle, -rotation);
    }
    
    /**
     * More sophicsticated driving method for teleop based on team 254's 
     * "cheesy drive". 
     * See reference:
     * http://www.chiefdelphi.com/forums/showpost.php?p=1181728&postcount=2
     * 
     * @param outputMagnitude The forward/backward power from -1 (backwards) to 1 (forward).
     * @param curve The rotational power from -1 (counterclockwise) to 1 (clockwise).
     */
    public void cheesyDrive(double outputMagnitude, double curve) {
        if(outputMagnitude >= RandomConstants.THROTTLE_CUTOFF) {
            curve *= (RandomConstants.TURN_GAIN * Math.abs(outputMagnitude));
        }
        
        double tLeft = outputMagnitude + curve;
        double tRight = outputMagnitude - curve;

        drive.tankDrive(tLeft + skim(tRight), tRight + skim(tLeft));
    }
    
    /**
     * If drive speed for one side > 1, subtract some of the difference from 
     * the other side's speed to maintain constant turning performance.
     * Used by cheesyDrive.
     * 
     * @param   val     value to "skim"
     * @return          sign(val) - val, scaled by some constant SKIM_GAIN,
     *                  if the absolute value of val is > 1, 0 otherwise
     */
    private double skim(double val) {
        return (Math.abs(val) > 1)
                ? ((Math.abs(val)>0 ? 1 : -1) - val) * RandomConstants.SKIM_GAIN
                : 0;
    }
    
    /**
     * Bounds the change in a value to some limit maxChange.
     * 
     * @param   oldValue        The value from the previous iteration.
     * @param   requestedValue  The value being requested to be changed to.
     * @param   maxChange       The maximum amount the value can change per iteration.
     * @return                  The limited value.
     */
    public double accelerationLimiter(double oldValue, 
            double requestedValue, double maxChange) {
        if(requestedValue - oldValue > maxChange) {
            return oldValue + maxChange;
        } else if(oldValue - requestedValue > maxChange) {
            return oldValue - maxChange;
        } else {
            return requestedValue;
        }
    }
    public void setWatchDogEnabled(boolean enabled) {
        drive.setSafetyEnabled(enabled);
    }
}

