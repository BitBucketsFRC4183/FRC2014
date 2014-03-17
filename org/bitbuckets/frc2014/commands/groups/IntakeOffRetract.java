/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.bitbuckets.frc2014.commands.groups;

import edu.wpi.first.wpilibj.command.CommandGroup;
import org.bitbuckets.frc2014.commands.IntakeRetract;
import org.bitbuckets.frc2014.commands.RollerOff;

/**
 *
 * @author admin
 */
public class IntakeOffRetract extends CommandGroup {
    
    public IntakeOffRetract() {
        addSequential(new IntakeRetract());
        addSequential(new RollerOff());
    }
}
