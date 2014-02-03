/* FRC 4183 - The Bit Buckets
 * Tucson, AZ
 *
 * FRC 2014 Codebase
 */

package org.bitbuckets.frc2014.subsystems;

import edu.wpi.first.wpilibj.Encoder;
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
    /** Base driving system standard in wpilibj **/
    public RobotDrive drive;
    /** Forward/backward power ranging from -1 (bwd) to 1 (fwd) **/
    private double throttle = 1;
    /** Rotational power ranging from -1 (ccw) to 1 (cw) **/
    private double rotation = 1;
    /** Right encoder. **/
    private Encoder encR;
    /** Left encoder. **/
    private Encoder encL;
    
    /**
     * Drivetrain constructor, sets up basic robot drive.
     */
    public DriveTrain() {
        super();
        drive  = new RobotDrive(RobotMap.R_MOTOR, RobotMap.L_MOTOR);
        encR = new Encoder(RobotMap.R_ENCODER_A, RobotMap.R_ENCODER_B);
        encL = new Encoder(RobotMap.L_ENCODER_A, RobotMap.L_ENCODER_B);
    }

    /**
     * Default command to run when subsystems are all initialized.
     */
    public void initDefaultCommand() {

    }
    
    /**
     * Gets the distance of the right encoder since the last reset.
     * 
     * @return The distance of the right encoder.
     */
    public double getEncDistR(){
        return encR.getDistance();
    }
    
    /**
     * Gets the distance of the left encoder since the last reset.
     * 
     * @return The distance of the left encoder.
     */
    public double getEncDistL(){
        return encL.getDistance();
    }
    
    /**
     * Gets the rate of the right encoder.
     * 
     * @return The rate of the right encoder.
     */
    public double getEncRateR(){
        return encR.getRate();
    }
    
    /**
     * Gets the rate of the left encoder.
     * 
     * @return The rate of the left encoder.
     */
    public double getEncRateL(){
        return encL.getRate();
    }
    
    /**
     * Basic driving method.  Can be used in autonomous and teleop.
     * 
     * @param   throttle    forward/backward power from -1 (bwd) to 1 (fwd)     
     * @param   rotation    rotational power from -1 (ccw) to 1 (cw)
     */
    public void drive(double throttle, double rotation){
        throttle = accelerationLimiter(throttle, throttle, RandomConstants.MAX_MAG_CHANGE);
        rotation = accelerationLimiter(rotation, rotation, RandomConstants.MAX_CUR_CHANGE);
        drive.arcadeDrive(throttle, rotation);
    }
    
    /**
     * Used for auton.
     * 
     * @param left
     * @param right 
     */
    public void tankDrive(double left, double right){
        drive.tankDrive(left, right);
    }
    
    /**
     * More sophicsticated driving method for teleop based on team 254's 
     * "cheesy drive". 
     * See reference:
     * http://www.chiefdelphi.com/forums/showpost.php?p=1181728&postcount=2
     * 
     * @param   outputMagnitude    forward/backward power from -1 (bwd) to 1 (fwd) 
     * @param   curve              rotational power from -1 (ccw) to 1 (cw)
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
}

