
package org.bitbuckets.frc2014.commands;

import org.bitbuckets.frc2014.subsystems.Lights;

/**
 * Made by Nathan
 * same info as Lights subsystem applys here**
 */
public class SimpleLights extends CommandBase {

    public SimpleLights() {
        requires(li);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
        /**
        * checks if lights are on
        * if on turns them off
        * if off turns them on
        */
        if(li.isOn()) {//checks if lights are on
            li.changeLights(false); //turn lights off
        } else { //if not
            li.changeLights(true);//turn lights on
}
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return false;
    }

    // Called once after isFinished returns true
    protected void end() {
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}
