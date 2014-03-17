/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.bitbuckets.frc2014.commands.groups;

import edu.wpi.first.wpilibj.command.CommandGroup;
import org.bitbuckets.frc2014.commands.ArmCatapult;
import org.bitbuckets.frc2014.commands.DriveTimeMillis;
import org.bitbuckets.frc2014.commands.Fire;
import org.bitbuckets.frc2014.commands.IntakeDeploy;
import org.bitbuckets.frc2014.commands.IntakeRetract;
import org.bitbuckets.frc2014.commands.RollerForward;
import org.bitbuckets.frc2014.commands.WaitMillis;

/**
 *
 * @author admin
 */
public class AutoOneBallDriveKevin extends CommandGroup {
    
    public AutoOneBallDriveKevin() {
        CommandGroup firingseq = new CommandGroup();
        firingseq.addSequential(new WaitMillis(500));
        firingseq.addSequential(new RollerForward());
        firingseq.addSequential(new WaitMillis(100));
        firingseq.addSequential(new IntakeDeploy());
        firingseq.addSequential(new WaitMillis(1700));
        firingseq.addSequential(new Fire());
        firingseq.addSequential(new WaitMillis(500));
        
        //Start Auto        
        addSequential(new ArmCatapult()); //t = 3.55
        addSequential(new IntakeDeploy());
        addParallel(new RollerForward());
        addSequential(new WaitMillis(1500)); //t = 5.05
        addSequential(new IntakeRetract());
        addSequential(new WaitMillis(1000)); //t = 6.05
        addParallel(new DriveTimeMillis(.5,0,3500)); //10.0
        addSequential(firingseq);
        addSequential(new ArmCatapult());
    }
}
