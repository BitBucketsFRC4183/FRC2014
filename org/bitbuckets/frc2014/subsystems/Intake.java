
package org.bitbuckets.frc2014.subsystems;

import edu.wpi.first.wpilibj.Victor;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.DoubleSolenoid;
import org.bitbuckets.frc2014.RobotMap;
import org.bitbuckets.frc2014.commands.RetractIntake;

/**
 *
 */
public class Intake extends Subsystem {
    // Put methods for controlling this subsystem
    // here. Call these from Commands.
    private Victor roller;
    private DoubleSolenoid deployer;
    
    public Intake() {
        super();
        roller  = new Victor(RobotMap.ROLLER_MOTOR);
        deployer = new DoubleSolenoid(RobotMap.INTAKE_SOLENOID_1, RobotMap.INTAKE_SOLENOID_2);
    }
    
    public void initDefaultCommand() {
        //setDefaultCommand(new RetractIntake());
    }
    
    public void setIntakeRoller(int speed){
        roller.set(speed);
    }
    
    public void setDeployed(boolean deployed) {
        if(deployed) {
            deployer.set(DoubleSolenoid.Value.kForward);
        } else {
            deployer.set(DoubleSolenoid.Value.kReverse);
        }
    }
}