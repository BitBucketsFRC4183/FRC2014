
package org.bitbuckets.frc2014.subsystems;

import edu.wpi.first.wpilibj.Victor;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.DoubleSolenoid;
import org.bitbuckets.frc2014.RobotMap;

/**
 *
 */
public class Intake extends Subsystem {
    // Put methods for controlling this subsystem
    // here. Call these from Commands.
    public Victor roller;
    public DoubleSolenoid deployer_r;
    public DoubleSolenoid deployer_l;
    
    public Intake() {
        super();
        roller  = new Victor(RobotMap.ROLLER_MOTOR);
        deployer_r = new DoubleSolenoid(RobotMap.INTAKE_RAISE_SOLENOID_R, RobotMap.INTAKE_LOWER_SOLENOID_R);
        deployer_l = new DoubleSolenoid(RobotMap.INTAKE_RAISE_SOLENOID_L, RobotMap.INTAKE_LOWER_SOLENOID_L);
    }
    
    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
    
    public void setIntakeRoller(int speed){
        roller.set(speed);
    }
    
    public void setDeployed(boolean deployed) {
        if(deployed) {
            deployer_r.set(DoubleSolenoid.Value.kForward);
            deployer_l.set(DoubleSolenoid.Value.kForward);
        } else {
            deployer_r.set(DoubleSolenoid.Value.kReverse);
            deployer_l.set(DoubleSolenoid.Value.kReverse);
        }
    }
}