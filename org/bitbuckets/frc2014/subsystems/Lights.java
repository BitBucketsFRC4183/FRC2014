
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
    private Relay light1;
    private boolean lightOn;
    
    public Lights(){
        super();
        light1 = new Relay(2);
    }

    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
    
    public void changeLights(boolean lightOn){
        boolean isOnVar = lightOn;
        
        /**
         * if set to true turns lights on
         * if set to false turns lights off
        */
        if (lightOn){
            light1.set(Relay.Value.kOn);
        } else {
            light1.set(Relay.Value.kOff);
        }
    }
    public boolean isOn() {
        return lightOn;
        /**
         * if its true lights on
         * if false lights off
        */ 
    }
}

