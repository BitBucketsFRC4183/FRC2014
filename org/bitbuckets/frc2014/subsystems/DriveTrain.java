
package org.bitbuckets.frc2014.subsystems;

import edu.wpi.first.wpilibj.RobotDrive;
import edu.wpi.first.wpilibj.command.Subsystem;
import org.bitbuckets.frc2014.RobotMap;

/**
 *
 */
public class DriveTrain extends Subsystem {
    // Put methods for controlling this subsystem
    // here. Call these from Commands.
    public RobotDrive drive;
    
    public DriveTrain() {
        super();
        drive  = new RobotDrive(RobotMap.rightMotor, RobotMap.leftMotor);
    }
    
    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
    
    public void drive(double outputMagnitude, double curve){
        drive.drive(outputMagnitude, curve);
    }
}

