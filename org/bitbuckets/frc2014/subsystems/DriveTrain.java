
package org.bitbuckets.frc2014.subsystems;

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
    public RobotDrive drive;
    double magnitudeBefore = 1;
    double curveBefore = 1;
    
    public DriveTrain() {
        super();
        drive  = new RobotDrive(RobotMap.R_MOTOR, RobotMap.L_MOTOR);
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
    public void drive(double outputMagnitude, double curve){
        double dMag = outputMagnitude - magnitudeBefore;
        double dCur = curve - curveBefore;
        int signMag = 1;
        int signCur = 1;
        
        if(dMag < 1)
            signMag = -1;
        if(dCur < 1)
            signCur = -1;
        
        if(Math.abs(dMag) > RandomConstants.MAX_MAG_CHANGE)
            dMag = RandomConstants.MAX_MAG_CHANGE*signCur;
        if(Math.abs(dCur) > RandomConstants.MAX_CUR_CHANGE)
            dCur = RandomConstants.MAX_CUR_CHANGE*signCur;
        
        drive.arcadeDrive(magnitudeBefore + dMag, -(curveBefore+dCur));
        magnitudeBefore = magnitudeBefore + dMag;
        curveBefore = curveBefore + dCur;
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
}

