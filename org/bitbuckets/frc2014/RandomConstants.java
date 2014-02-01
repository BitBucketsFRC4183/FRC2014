/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package org.bitbuckets.frc2014;

/**
 *
 * @author admin
 */
public class RandomConstants {
    
    //Drivetrain:
    public static final double MAX_MAG_CHANGE = .5;
    public static final double MAX_CUR_CHANGE = .5;
    public static final double SKIM_GAIN = .5;
    public static final double TURN_GAIN = 1.0;
    public static final double THROTTLE_CUTOFF = .3;
    
    /** The amount of ticks given out by the encoder per rotation. **/
    public static final int TICKS_PER_ROTATION = 1000;
    
    /** The amount of encoder ticks it takes to go one inch. Ticks per rotation divided by wheel circumference. **/
    public static final int TICKS_PER_INCH = TICKS_PER_ROTATION/1;
    /** The KP for the pid controller used to drive n inches. **/
    public static final double INCH_PID_KP = 0.3;
    /** The KI for the pid controller used to drive n inches. **/
    public static final double INCH_PID_KI = 0.3;
    /** The KD for the pid controller used to drive n inches. **/
    public static final double INCH_PID_KD = 0.3;
    /** The KF for the pid controller used to drive n inches. **/
    public static final double INCH_PID_KF = 0.3;
    /** The tolerence for the pid controller used to drive n inches. **/
    public static final double INCH_PID_TOL = .1;
    
    
    ///////////////----Catapault----///////////////
    /** The speed of the winch. **/
    public static final double WINCH_SPEED = 1.0;
    
    ///////////////----Intake----///////////////
    /** The constant that controls the speed of the intake roller. **/
    public static final double INTAKE_FORWARDS = -1;
    /** The constant that turns the intake roller off. **/
    public static final double INTAKE_OFF = 0;
    /** The constant that controls the speed of the intake roller in the opposite direction. **/
    public static final double INTAKE_BACKWARDS = 1;
}
