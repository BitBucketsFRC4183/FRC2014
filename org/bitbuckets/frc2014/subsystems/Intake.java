
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
    private DoubleSolenoid deployerR;
    private DoubleSolenoid deployerL;
    
    public Intake() {
        super();
        roller  = new Victor(RobotMap.ROLLER_MOTOR);
        deployerR = new DoubleSolenoid(RobotMap.INTAKE_RAISE_SOLENOID_R, RobotMap.INTAKE_LOWER_SOLENOID_R);
        deployerL = new DoubleSolenoid(RobotMap.INTAKE_RAISE_SOLENOID_L, RobotMap.INTAKE_LOWER_SOLENOID_L);
    }
    
    public void initDefaultCommand() {
        //setDefaultCommand(new RetractIntake());
    }
    
    public void setIntakeRoller(int speed){
        roller.set(speed);
    }
    
    public void setDeployed(boolean deployed) {
        if(deployed) {
            deployerR.set(DoubleSolenoid.Value.kForward);
            deployerL.set(DoubleSolenoid.Value.kForward);
        } else {
            deployerR.set(DoubleSolenoid.Value.kReverse);
            deployerL.set(DoubleSolenoid.Value.kReverse);
        }
    }
}