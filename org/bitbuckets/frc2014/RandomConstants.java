/* FRC 4183 - The Bit Buckets
 * Tucson, AZ
 *
 * FRC 2014 Codebase
 */
package org.bitbuckets.frc2014;

/**
 * Random constants used in lots of places.
 * 
 * @author James Wyeth james.wyeth@gmail.com
 */
public class RandomConstants {
    
    ///////////////----Drivetrain----///////////////
    /** The maximum magnitude change. Used in stock drive. **/
    public static final double MAX_MAG_CHANGE = .5;
    /** The maximum curve change. Used in stock drive. **/
    public static final double MAX_CUR_CHANGE = .5;
    /** The maximum skim gain. Used in cheesy drive. **/
    public static final double SKIM_GAIN = .5;
    /** The maximum turn gain. Used in cheesy drive. **/
    public static final double TURN_GAIN = 1.0;
    /** The cutoff for the throttle. Used in cheesy drive. **/
    public static final double THROTTLE_CUTOFF = .3;
    
    /** The amount of ticks given out by the encoder per rotation. **/
    public static final int TICKS_PER_ROTATION = 1000;
    /** The amount of encoder ticks it takes to go one inch. Ticks per rotation divided by wheel circumference. **/
    public static final int TICKS_PER_INCH = (int)(TICKS_PER_ROTATION/(4*Math.PI));
    /** The KP for the pid controller used to drive n inches. **/
    public static final double INCH_PID_KP = 0.3;
    /** The KI for the pid controller used to drive n inches. **/
    public static final double INCH_PID_KI = 0.3;
    /** The KD for the pid controller used to drive n inches. **/
    public static final double INCH_PID_KD = 0.3;
    /** The max acceleration for the auton drivestraight. **/
    public static final double INCH_MAX_ACCEL = .1;
    
    /** The KP for the pid controller used to turn n degrees. **/
    public static final double DEG_PID_KP = 0.3;
    /** The KI for the pid controller used to turn n degrees.. **/
    public static final double DEG_PID_KI = 0.3;
    /** The KD for the pid controller used to turn n degrees. **/
    public static final double DEG_PID_KD = 0.3;
    /** The max acceleration for the auton driveturn. **/
    public static final double DEG_MAX_ACCEL = .1;
    
    ///////////////----Catapault----///////////////
    /**  **/
    public static final double WINCH_SPEED = 1.0;
}
