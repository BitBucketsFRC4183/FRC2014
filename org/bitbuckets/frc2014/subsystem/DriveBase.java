
package org.bitbuckets.frc2014.subsystem;

import edu.wpi.first.wpilibj.RobotDrive;
import edu.wpi.first.wpilibj.command.Subsystem;
import org.bitbuckets.frc2014.RobotMap;

/**
 *
 */
public class DriveBase extends Subsystem {
    // Put methods for controlling this subsystem
    // here. Call these from Commands.
    RobotMap rm;
    public RobotDrive drive = new RobotDrive(rm.rightMotor, rm.leftMotor);

    public void initDefaultCommand() {}
    
    public void drive(double outputMagnitude, double curve){
        drive.drive(outputMagnitude, curve);
    }
}

