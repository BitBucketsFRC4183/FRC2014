/* FRC 4183 - The Bit Buckets
 * Tucson, AZ
 *
 * FRC 2014 Codebase
 */

package org.bitbuckets.frc2014.subsystems;

import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.Victor;
import edu.wpi.first.wpilibj.command.Subsystem;
import org.bitbuckets.frc2014.RandomConstants;
import org.bitbuckets.frc2014.RobotMap;

/**
 * @author    
 * 
 * Collection of actuators and sensors that form the catapult subsystem.
 */
public class Catapault extends Subsystem {
    private Victor winch;           // MiniCIM ball-shifter driven winch
    private DoubleSolenoid shifter; // pneumatic shifter
    
    /** digital switch that is closed (false) when the winch is armed **/
    public DigitalInput retracted;
    
    /**
     * Catapult constructor, sets up actuators and sensors.
     */
    public Catapault(){
        super();
        winch = new Victor(RobotMap.WINCH_MOTOR);
        shifter = new DoubleSolenoid(RobotMap.WINCH_SHIFTER_1, RobotMap.WINCH_SHIFTER_2);
        retracted = new DigitalInput(RobotMap.CATAPAULT_LIMIT_SWITCH);
    }
    
    /**
     * Default command to run when subsystems are all initialized.
     */
    public void initDefaultCommand() {
        
    }
    
    /**
     * Sets the state of the pneumatic shifting solenoid to shift the ball
     * shifter into neutral position to fire or low-gear for winching.
     * @param     fired    fires catapult when true, engages motor otherwise
     */
    public void setCatapaultFired(boolean fired){
        if(fired){
            shifter.set(DoubleSolenoid.Value.kForward);
        }else{
            shifter.set(DoubleSolenoid.Value.kReverse);
        }
        System.out.println("\t" + retracted.get() + "\t");
    }

    /**
     * Winches back the catapult by driving the ball-shifter motor(s).
     * @param     moving    enables winch motor when true, disables when false
     */
    public void setCatapaultRetracted(boolean moving){
        if(moving){
            winch.set(RandomConstants.WINCH_SPEED);
        }else{
            winch.set(0);
        }
    }
    
}

