package org.bitbuckets.frc2014;

/**
 * The RobotMap is a mapping from the ports sensors and actuators are wired into
 * to a variable name. This provides flexibility changing wiring, makes checking
 * the wiring easier and significantly reduces the number of magic numbers
 * floating around.
 */
public class RobotMap {
    // For example to map the left and right motors, you could define the
    // following variables to use with your drivetrain subsystem.
    /**
     * The right motor on the drivetrain.
     */
    public static final int R_MOTOR = 1;
    /**
     * The left motor on the drivetrain.
     */
    public static final int L_MOTOR = 2;
    /**
     * The left motor for the roller intake
     */
    public static final int ROLLER_MOTOR = 3;
    /**
     * 
     */
    public static final int WINCH_MOTOR = 4;
    
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
    
    /**
     * The relay the compressor is plugged in to
     */
    public static final int COMPRESSOR_RELAY = 4;
    
    /**
     * The limit switch that says when the catapult is all the way back.
     */
    public static final int CATAPAULT_LIMIT_SWITCH = 1;
    /**
     * The switch that tells the compressor the max pressure
     */
    public static final int PRESSURE_SWITCH = 14;
    
    /**
     * The port the joystick is plugged in to
     */
    public static final int JOY_1_PORT = 1;
    
    // If you are using multiple modules, make sure to define both the port
    // number and the module. For example you with a rangefinder:
    // public static final int rangefinderPort = 1;
    // public static final int rangefinderModule = 1;
}
