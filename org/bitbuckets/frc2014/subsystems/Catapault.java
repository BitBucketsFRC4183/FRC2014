/* FRC 4183 - The Bit Buckets
 * Tucson, AZ
 *
 * FRC 2014 Codebase
 */

package org.bitbuckets.frc2014.subsystems;

import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj.Talon;
import edu.wpi.first.wpilibj.command.Subsystem;
import org.bitbuckets.frc2014.RandomConstants;
import org.bitbuckets.frc2014.RobotMap;

/**
 * @author    
 * 
 * Collection of actuators and sensors that form the catapult subsystem.
 */
public class Catapault extends Subsystem {
    /** Ball-shifter winch powered by two MiniCIMs on Victors */
    private Talon winch;
    /** Double-acting cylinder to shift between low-gear and neutral */
    private DoubleSolenoid shifter;
    
    /** digital switch that is closed (false) when the winch is armed **/
    private DigitalInput retracted;
    /** Firing cylinder*/
    private Solenoid latch;
    
          
     
    
    /**
     * Catapult constructor, sets up actuators and sensors.
     */
    public Catapault(){
        super();
        winch = new Talon(RobotMap.WINCH_MOTOR);
        shifter = new DoubleSolenoid(RobotMap.WINCH_SHIFTER_A, RobotMap.WINCH_SHIFTER_B);
        retracted = new DigitalInput(RobotMap.CATAPAULT_LIMIT_SWITCH);
        latch = new Solenoid(RobotMap.CATAPULT_LATCH);
    }
    
    /**
     * Default command to run when subsystems are all initialized.
     */
    public void initDefaultCommand() {
        
    }    
    
    /**
     * Turns on winch motors.
     */
    public void setWinchMotorsOn(){
        winch.set(RandomConstants.WINCH_SPEED);
    }
    
    public void setWinchMotorsReverse(){
        winch.set(-RandomConstants.WINCH_SPEED);
    }
    /**
     * Turns off winch motors.
     */
    public void setWinchMotorsOff(){
        winch.set(0);
    }
    
    /**
     * Sets shifter to active gear.
     */
    public void setShifterActive(){
        shifter.set(DoubleSolenoid.Value.kForward);   
    }
    
    /**
     * Sets shifter to neutral gear.
     */
    public void setShifterNeutral(){
        shifter.set(DoubleSolenoid.Value.kReverse);
    }
    
    /**
     * Sets latch to open position to fire catapult.
     */
    public void setLatchOpen(){
        latch.set(true);
    }
    
    /**
     * Sets latch to closed position to lock catapult.
     */
    public void setLatchClosed(){
        latch.set(false);
    }
    
    public boolean getRetracted(){
        return retracted.get();
    }
}