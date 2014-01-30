
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
    public Encoder encR;
    public Encoder encL;
    
    public DriveTrain() {
        super();
        drive  = new RobotDrive(RobotMap.R_MOTOR, RobotMap.L_MOTOR);
        encR = new Encoder(RobotMap.R_ENCODER_A, RobotMap.R_ENCODER_B);
        encL = new Encoder(RobotMap.L_ENCODER_A, RobotMap.L_ENCODER_B);
    }
    
    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
    /**
     * Basic driving method.  Can be used in autonomous and teleop.
     * @param outputMagnitude
     * @param curve 
     */
    public void drive(double throttle, double rotation){
        this.throttle = accelerationLimiter(this.throttle, throttle, RandomConstants.MAX_MAG_CHANGE);
        this.rotation = accelerationLimiter(this.rotation, rotation, RandomConstants.MAX_CUR_CHANGE);
        drive.arcadeDrive(this.throttle, -this.rotation);
    }
    
    /**
     * More sophicsticated driving method for teleop.
     * @param outputMagnitude
     * @param curve 
     */
    public void cheesyDrive(double outputMagnitude, double curve) {
        //See http://www.chiefdelphi.com/forums/showpost.php?p=1181728&postcount=2 for reference.
        if(outputMagnitude >= RandomConstants.THROTTLE_CUTOFF)
            curve *= (RandomConstants.TURN_GAIN * Math.abs(outputMagnitude));
        
        double tLeft = outputMagnitude + curve;
        double tRight = outputMagnitude - curve;

        drive.tankDrive(tLeft + skim(tRight), tRight + skim(tLeft));
    }
    
    /**
     * If drive speed for one side > 1, subtract some of the difference from other side's speed to maintain constant turning performance.
     * Used in cheesyDrive.
     * @param v
     * @return 
     */
    public double skim(double v) {
        if(v > 1.0) {
            return -((v - 1.0) * RandomConstants.SKIM_GAIN);
        } else if (v < -1.0)
            return -((v + 1.0) * RandomConstants.SKIM_GAIN);
        return 0;
    }
    
    /**
     * 
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

