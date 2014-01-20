
package org.bitbuckets.frc2014.subsystems;

import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.Victor;
import edu.wpi.first.wpilibj.command.Subsystem;
import org.bitbuckets.frc2014.RandomConstants;
import org.bitbuckets.frc2014.RobotMap;

/**
 *
 */
public class Catapault extends Subsystem {
    ////-----------------------Pneumatic-----------------------////
//    private DoubleSolenoid shootLeft;
//    private DoubleSolenoid shootRight;
//    
//    public Catapault(){
//        super();
//        shootLeft = new DoubleSolenoid(RobotMap.CATAPAULT_FIRE_SOLENOID_L, RobotMap.CATAPAULT_RETRACT_SOLENOID_L);
//        shootRight = new DoubleSolenoid(RobotMap.CATAPAULT_FIRE_SOLENOID_R, RobotMap.CATAPAULT_RETRACT_SOLENOID_R);
//    }
//    
//    public void initDefaultCommand() {
//        // Set the default command for a subsystem here.
//        //setDefaultCommand(new MySpecialCommand());
//    }
//    
//    public void setCatapaultFired(boolean fired){
//        if(fired){
//            shootLeft.set(DoubleSolenoid.Value.kForward);
//            shootRight.set(DoubleSolenoid.Value.kForward);
//        }else{
//            shootLeft.set(DoubleSolenoid.Value.kReverse);
//            shootRight.set(DoubleSolenoid.Value.kReverse);
//        }
//    }
    
    ////-----------------------Spring and winch-----------------------////
    
    private Victor winch;
    private DoubleSolenoid shifter;
    
    public DigitalInput retracted;
    
    public Catapault(){
        super();
        winch = new Victor(5);
        shifter = new DoubleSolenoid(RobotMap.WINCH_SHIFTER_1, RobotMap.WINCH_SHIFTER_2);
        retracted = new DigitalInput(RobotMap.CATAPAULT_LIMIT_SWITCH);
    }
    
    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
    
    public void setCatapaultFired(boolean fired){
        if(fired){
            shifter.set(DoubleSolenoid.Value.kForward);
        }else{
            shifter.set(DoubleSolenoid.Value.kReverse);
        }
        System.out.println("\t" + retracted.get() + "\t");
    }
    
    public void setCatapaultRetracted(boolean moving){
        if(moving){
            winch.set(RandomConstants.WINCH_SPEED);
        }else{
            winch.set(0);
        }
    }
    
}

