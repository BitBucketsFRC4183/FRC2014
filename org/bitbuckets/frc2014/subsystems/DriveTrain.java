
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
    
    public void drive(double outputMagnitude, double curve){
        double dMag = outputMagnitude - magnitudeBefore;
        double dCur = curve - curveBefore;
        int signMag = 1;
        int signCur = 1;
        
        if(dMag < 1)
            signMag = -1;
        if(dCur < 1)
            signCur = -1;
        
        if(Math.abs(dMag) > RandomConstants.maxMagChange)
            dMag = RandomConstants.maxMagChange*signCur;
        if(Math.abs(dCur) > RandomConstants.maxCurChange)
            dCur = RandomConstants.maxCurChange*signCur;
        
        drive.arcadeDrive(magnitudeBefore + dMag, -(curveBefore+dCur));
        magnitudeBefore = magnitudeBefore + dMag;
        curveBefore = curveBefore + dCur;
    }
}

