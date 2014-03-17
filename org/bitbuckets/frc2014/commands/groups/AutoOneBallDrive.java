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
import org.bitbuckets.frc2014.commands.RollerOff;
import org.bitbuckets.frc2014.commands.WaitMillis;

/**
 *
 * @author Cal Miller cal@bpmpc.net
 */
public class AutoOneBallDrive extends CommandGroup {
    
    public AutoOneBallDrive() {
        addSequential(new ArmCatapult()); //t = 3.55
        addSequential(new IntakeDeploy());
        addParallel(new RollerForward());
        addSequential(new WaitMillis(1500)); //t = 5.05
        addSequential(new IntakeRetract());
        addSequential(new WaitMillis(1000)); //t = 6.05
        addSequential(new DriveTimeMillis(.5,0,2500)); //10.0
        addSequential(new WaitMillis(1000)); //t=.5
        addSequential(new IntakeDeploy());
        addParallel(new RollerForward());
        addSequential(new WaitMillis(500)); //t = 1
        addSequential(new RollerOff());
        addSequential(new WaitMillis(1250)); //t = 1.75
        addSequential(new Fire());
        addSequential(new WaitMillis(750)); //t = 2.5
        addSequential(new ArmCatapult());
        addParallel(new IntakeRetract());
    }
}
