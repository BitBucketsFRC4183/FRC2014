/* FRC 4183 - The Bit Buckets
 * Tucson, AZ
 *
 * FRC 2014 Codebase
 */
package org.bitbuckets.frc2014;

/**
 * The map of the physical robot. Not really a map. More of a list of where everything is plugged in. on the robot.
 * 
 * @author Default
 */
public class RobotMap {
    
    /////////////////////////////////////////////////////////////////////////////
    /////////////////////////////////----PWM----/////////////////////////////////
    /////////////////////////////////////////////////////////////////////////////
    
    /**
     * The front right motor on the drivetrain.
     */
    public static final int R_MOTOR_A = 1;
    /**
     * The rear right motor on the drivetrain.
     */
    public static final int R_MOTOR_B = 2;
    /**
     * The front left motor on the drivetrain.
     */
    public static final int L_MOTOR_A = 3;
    /**
     * The rear left motor on the drivetrain.
     */
    public static final int L_MOTOR_B = 4;
    /**
     * The front intake roller motor.
     */
    public static final int FRONT_ROLLER_MOTOR = 5;
    /**
     * The right intake roller motor.
     */
    public static final int RIGHT_ROLLER_MOTOR = 6;
    /**
     * The left intake roller motor.
     */
    public static final int LEFT_ROLLER_MOTOR = 7;
    /**
     * The CIMs driving the winch.
     */
    public static final int WINCH_MOTOR = 8;
    
    ///////////////////////////////////////////////////////////////////////////////////
    /////////////////////////////////----SOLENOIDS----/////////////////////////////////
    ///////////////////////////////////////////////////////////////////////////////////
    
    /**
     * The first port for the double solenoid controlling the intake pistons.
     */
    public static final int INTAKE_SOLENOID_A = 1;
    /**
     * The second port for the double solenoid controlling the intake pistons.
     */
    public static final int INTAKE_SOLENOID_B = 2;
    /**
     * The first port for the double solenoid controlling the winch shifter.
     */
    public static final int WINCH_SHIFTER_A = 3;
    /**
     * The second port for the double solenoid controlling the winch shifter.
     */
    public static final int WINCH_SHIFTER_B = 4;
    /**
     * The latch solenoid for firing
     */
    public static final int CATAPULT_LATCH = 5;
    
    ///////////////////////////////////////////////////////////////////////////////
    /////////////////////////////////----RELAY----/////////////////////////////////
    ///////////////////////////////////////////////////////////////////////////////
    
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
     * The first channel of the right encoder for the drivetrain.
     */
    public static final int R_ENCODER_A = 2;
    /**
     * The second channel on the right encoder for the drivetrain.
     */
    public static final int R_ENCODER_B = 2;
    /**
     * The first channel for the left encoder for the drivetrain.
     */
    public static final int L_ENCODER_A = 4;
    /**
     * The second channel for the left encoder for the drivetrain.
     */
    public static final int L_ENCODER_B = 4;
    /**
     * The switch used to choose between autonomous modes.
     */
    public static final int AUTON_SELECT_SWITCH = 13;
    /**
     * The switch that tells the compressor if max pressure has been reached.
     */
    public static final int PRESSURE_SWITCH = 14;
    
    
    ///////////////////////////////////////////////////////////////////////////////
    /////////////////////////////////----OTHER----/////////////////////////////////
    ///////////////////////////////////////////////////////////////////////////////
    
    /**
     * The port the CCI (Custom Controller Interface) is plugged into.
     */
    public static final int CCI_PORT = 1;
    /**
     * The port the right joystick is plugged into.
     */
    public static final int JOY_RIGHT_PORT = 2;
    /**
     * The port the left joystick is plugged into.
     */
    public static final int JOY_LEFT_PORT = 3;
}
