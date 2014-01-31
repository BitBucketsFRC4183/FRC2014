
package org.bitbuckets.frc2014.subsystems;

import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.RobotDrive;
import edu.wpi.first.wpilibj.command.Subsystem;
import org.bitbuckets.frc2014.RandomConstants;
import org.bitbuckets.frc2014.RobotMap;

/**
 *
 */
public class DriveTrain extends Subsystem {
    // Put methods for controlling this subsystem
    // here. Call these from Commands.
    private RobotDrive drive;
    private double throttle = 1;
    private double rotation = 1;
    
    public DriveTrain() {
        super();
        drive  = new RobotDrive(RobotMap.R_MOTOR, RobotMap.L_MOTOR);
    }
    
    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
    
    /**
     * Arcade driving method. Used in teleop.
     * 
     * @param outputMagnitude
     * @param curve 
     */
    public void drive(double throttle, double rotation){
        throttle = accelerationLimiter(throttle, throttle, RandomConstants.MAX_MAG_CHANGE);
        rotation = accelerationLimiter(rotation, rotation, RandomConstants.MAX_CUR_CHANGE);
        drive.arcadeDrive(throttle, rotation);
    }
    
    /**
     * Limits the acceleration of the motors so that they don't kill the clutch.
     * 
     * @param oldValue The value from the previous iteration.
     * @param requestedValue The value being requested to be changed to.
     * @param maxChange The maximum amount the value can change per iteration.
     * @return The limited value.
     */
    public double accelerationLimiter(double oldValue, double requestedValue, double maxChange){
        if(requestedValue - oldValue > maxChange)
            return oldValue + maxChange;
        else if(oldValue - requestedValue > maxChange)
            return oldValue - maxChange;
        else
            return requestedValue;
    }
}

