/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.bitbuckets.frc2014.commands.groups;

import edu.wpi.first.wpilibj.command.CommandGroup;
import org.bitbuckets.frc2014.commands.RollerOff;
import org.bitbuckets.frc2014.commands.WaitMillis;

/**
 *
 * @author Cal Miller cal@bpmpc.net
 * 
 */
public class IntakeDeployShortRoller extends CommandGroup {
    
    public IntakeDeployShortRoller() {
        addSequential(new IntakeBall());
        addSequential(new WaitMillis(250));
        addSequential(new RollerOff());
    }
}
