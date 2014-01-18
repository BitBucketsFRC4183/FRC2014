
package org.bitbuckets.frc2014.subsystems;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.command.Subsystem;
import org.bitbuckets.frc2014.RobotMap;

/**
 *
 */
public class Catapault extends Subsystem {
    private DoubleSolenoid shootLeft;
    private DoubleSolenoid shootRight;
    
    public Catapault(){
        super();
        shootLeft = new DoubleSolenoid(RobotMap.CATAPAULT_FIRE_SOLENOID_L, RobotMap.CATAPAULT_RETRACT_SOLENOID_L);
        shootRight = new DoubleSolenoid(RobotMap.CATAPAULT_FIRE_SOLENOID_R, RobotMap.CATAPAULT_RETRACT_SOLENOID_R);
    }

    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
    
    public void setCatapaultFired(boolean fired){
        if(fired){
            shootLeft.set(DoubleSolenoid.Value.kForward);
            shootRight.set(DoubleSolenoid.Value.kForward);
        }
        else{
            shootLeft.set(DoubleSolenoid.Value.kReverse);
            shootRight.set(DoubleSolenoid.Value.kReverse);
        }
    }
}

