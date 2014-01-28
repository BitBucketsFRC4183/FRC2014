
package org.bitbuckets.frc2014.subsystems;

import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.Relay;
import org.bitbuckets.frc2014.RobotMap;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 * Created by Nathan Rix
 * Needs ALOT of work but its a start
 * also this is my first class when it comes to FRC
 */
public class Lights extends Subsystem {
    private Relay light;
    
    public Lights(){
        super();
        light = new Relay(RobotMap.LIGHT_RELAY);
    }

    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
    
    /**
     * 
     * @param lightOn 
     */
    public void set(boolean lightOn){
        if(lightOn){
            light.set(Relay.Value.kOn);
        }else{
            light.set(Relay.Value.kOff);
        }
    }
    
    /**
     * 
     * @return If the light is on.
     */
    public boolean isOn() {
        return light.get() == Relay.Value.kOn;
    }
}

