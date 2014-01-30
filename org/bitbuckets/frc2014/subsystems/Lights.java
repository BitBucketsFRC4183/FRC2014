/* FRC 4183 - The Bit Buckets
 * Tucson, AZ
 *
 * FRC 2014 Codebase
 */

package org.bitbuckets.frc2014.subsystems;

import edu.wpi.first.wpilibj.Relay;
import org.bitbuckets.frc2014.RobotMap;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 * @author    
 * 
 * Collection of actuators and interfaces for the lights subsystem.
 */
public class Lights extends Subsystem {
    /** Lights are powered by a relay for now */
    private Relay light;
    
    /**
     * Lights constructor, sets up relay module.
     */
    public Lights(){
        super();
        light = new Relay(RobotMap.LIGHT_RELAY);
    }

    /**
     * Default command to run when subsystems are all initialized.
     */
    public void initDefaultCommand() {

    }
    
    /**
     * Sets the state of the lights relay.
     * @param   lightOn   true to power lights, false to turn them off
     */
    public void set(boolean lightOn){
        light.set(lightOn ? Relay.Value.kOn : Relay.Value.kOff);
    }
    
    /**
     * Gets the state of the lights relay.
     * @return   true if lights are on, false otherwise
     */
    public boolean isOn() {
        return (light.get() == Relay.Value.kOn);
    }
}

