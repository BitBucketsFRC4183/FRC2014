/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.bitbuckets.frc2014.commands.groups;

import edu.wpi.first.wpilibj.command.CommandGroup;
import org.bitbuckets.frc2014.commands.IntakeDeploy;
import org.bitbuckets.frc2014.commands.RollerForward;

/**
 *
 * @author admin
 */
public class IntakeBall extends CommandGroup {
    
    public IntakeBall() {
        addSequential(new IntakeDeploy());
        addSequential(new RollerForward());
    }
}
