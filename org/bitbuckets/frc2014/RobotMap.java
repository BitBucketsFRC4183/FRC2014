/* FRC 4183 - The Bit Buckets
 * Tucson, AZ
 *
 * FRC 2014 Codebase
 */
package org.bitbuckets.frc2014;

/**
 * 
 * 
 * @author Default
 */
public class RobotMap {
    
    /////////////////////////////////////////////////////////////////////////////
    /////////////////////////////////----PWM----/////////////////////////////////
    /////////////////////////////////////////////////////////////////////////////
    
    /**
     * The right motor on the drivetrain.
     */
    public static final int R_MOTOR = 1;
    /**
     * The left motor on the drivetrain.
     */
    public static final int L_MOTOR = 2;
    /**
     * The intake roller motor.
     */
    public static final int ROLLER_MOTOR = 3;
    /**
     * Mini-CIMs driving ball-shifter winch.
     */
    public static final int WINCH_MOTOR = 4;
    
    ///////////////////////////////////////////////////////////////////////////////////
    /////////////////////////////////----SOLENOIDS----/////////////////////////////////
    ///////////////////////////////////////////////////////////////////////////////////
    
    /**
     * The first port for the double solenoid controlling the winch shifter.
     */
    public static final int WINCH_SHIFTER_1 = 1;
    /**
     * The second port for the double solenoid controlling the winch shifter.
     */
    public static final int WINCH_SHIFTER_2 = 2;
    /**
     * The first port for the double solenoid controlling the intake pistons.
     */
    public static final int INTAKE_SOLENOID_1 = 3;
    /**
     * The second port for the double solenoid controlling the intake pistons.
     */
    public static final int INTAKE_SOLENOID_2 = 4;
    
    ///////////////////////////////////////////////////////////////////////////////
    /////////////////////////////////----RELAY----/////////////////////////////////
    ///////////////////////////////////////////////////////////////////////////////
    
    /**
     * The relay that's connected to the lights.
     */
    public static final int LIGHT_RELAY = 2;
    /**
     * The relay the compressor is plugged in to
     */
    public static final int COMPRESSOR_RELAY = 4;
    
    /////////////////////////////////////////////////////////////////////////////
    /////////////////////////////////----DIO----/////////////////////////////////
    /////////////////////////////////////////////////////////////////////////////
    
    /**
     * The limit switch that says when the catapult is all the way back.
     */
    public static final int CATAPAULT_LIMIT_SWITCH = 1;
    /**
     * The right encoder for the drivetrain.
     */
    public static final int R_ENCODER_A = 2;
    /**
     * The right encoder for the drivetrain.
     */
    public static final int R_ENCODER_B = 3;
    /**
     * The left encoder for the drivetrain.
     */
    public static final int L_ENCODER_A = 4;
    /**
     * The left encoder for the drivetrain.
     */
    public static final int L_ENCODER_B = 5;
    /**
     * The switch that tells the compressor the max pressure
     */
    public static final int PRESSURE_SWITCH = 14;
    
    
    ///////////////////////////////////////////////////////////////////////////////
    /////////////////////////////////----OTHER----/////////////////////////////////
    ///////////////////////////////////////////////////////////////////////////////
    
    /**
     * The port the joystick is plugged in to
     */
    public static final int JOY_1_PORT = 1;
}
