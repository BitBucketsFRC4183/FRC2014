
package org.bitbuckets.frc2014.commands;

import org.bitbuckets.frc2014.subsystems.Lights;

/**
 * Made by Nathan
 same intakefo as Lights subsystem applys here**
 */
public class SimpleLights extends CommandBase {

    public SimpleLights() {
        requires(lights);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
        if(lights.isOn()){
            lights.set(false);
        }else{
            lights.set(true);
        }
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return true;
    }

    // Called once after isFinished returns true
    protected void end() {
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}
