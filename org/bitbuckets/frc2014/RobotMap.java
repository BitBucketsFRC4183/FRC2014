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
    public static final int R_MOTOR = 1;
    public static final int L_MOTOR = 2;
    public static final int ROLLER_MOTOR = 3;
    
    public static final int INTAKE_RAISE_SOLENOID_R = 3;
    public static final int INTAKE_LOWER_SOLENOID_R = 4;
    public static final int INTAKE_RAISE_SOLENOID_L = 1;
    public static final int INTAKE_LOWER_SOLENOID_L = 2;
    
    public static final int COMPRESSOR_RELAY = 4;
    
    public static final int PRESSURE_SWITCH = 14;
    
    public static final int JOY_1_PORT = 1;
    
    // If you are using multiple modules, make sure to define both the port
    // number and the module. For example you with a rangefinder:
    // public static final int rangefinderPort = 1;
    // public static final int rangefinderModule = 1;
}
