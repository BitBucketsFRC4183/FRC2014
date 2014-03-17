/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.bitbuckets.frc2014.commands.groups;

import edu.wpi.first.wpilibj.command.CommandGroup;
import org.bitbuckets.frc2014.RandomConstants;
import org.bitbuckets.frc2014.commands.Fire;
import org.bitbuckets.frc2014.commands.RollerReverse;
import org.bitbuckets.frc2014.commands.WaitMillis;

/**
 *
 * @author admin
 */
public class Pass extends CommandGroup {
    
    public Pass() {
        addParallel(new Fire());
        addSequential(new WaitMillis(RandomConstants.PASS_FIRE_DELAY));
        addSequential(new RollerReverse());
    }
}
