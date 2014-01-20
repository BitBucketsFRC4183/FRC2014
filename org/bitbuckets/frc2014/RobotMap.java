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
     * The left solenoid for the intake to raise
     */
    public static final int INTAKE_RAISE_SOLENOID_L = 1;
    /**
     * The left solenoid for the intake to lower
     */
    public static final int INTAKE_LOWER_SOLENOID_L = 2;
    /**
     * The right solenoid that raises the intake
     */
    public static final int INTAKE_RAISE_SOLENOID_R = 3;
    /**
     * The right solenoid that lowers the intake
     */
    public static final int INTAKE_LOWER_SOLENOID_R = 4;
    /**
     * The left solenoid that fires the catapult
     */
    public static final int CATAPAULT_FIRE_SOLENOID_L = 5;
    /**
     * The left solenoid that retracts the catapult
     */
    public static final int CATAPAULT_RETRACT_SOLENOID_L = 6;
    /**
     * The right solenoid that fires the catapult
     */
    public static final int CATAPAULT_FIRE_SOLENOID_R = 7;
    /**
     * The right catapult that retracts the catapult
     */
    public static final int CATAPAULT_RETRACT_SOLENOID_R = 8;
    
    /**
     * The relay the compressor is plugged in to
     */
    public static final int COMPRESSOR_RELAY = 4;
    
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
