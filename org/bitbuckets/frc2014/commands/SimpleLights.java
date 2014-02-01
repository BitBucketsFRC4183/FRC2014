/* FRC 4183 - The Bit Buckets
 * Tucson, AZ
 *
 * FRC 2014 Codebase
 */

package org.bitbuckets.frc2014.commands;

import org.bitbuckets.frc2014.subsystems.Lights;

/**
 * @author    Nathan Rix nathan@tucsonconnect.org
 * 
 * If button pressed turns on lights if same button pressed again turns off
 */
public class SimpleLights extends CommandBase {
    
    /**
     * Makes a new SimpleLights command
     */
    public SimpleLights() {
        requires(lights);
    }
    
    /**
     * Turns lights on.
     */
    protected void initialize() {
        if(lights.isOn()){
            lights.set(false);
        }else{
            lights.set(true);
        }
    }

    /**
     * Called repeatedly when this Command is scheduled to run.
     */
    protected void execute() {
    }

    /**
     * Make this return true when this Command no longer needs to run execute().
     * 
     * @return Always returns true;
     */
    protected boolean isFinished() {
        return true;
    }

    /**
     * Called once after isFinished returns true.
     */
    protected void end() {
    }

    /**
     * Called when another command which requires one or more of the same
     *  subsystems is scheduled to run.
     */
    protected void interrupted() {
    }
}
