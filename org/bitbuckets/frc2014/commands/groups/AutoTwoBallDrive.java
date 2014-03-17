/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.bitbuckets.frc2014.commands.groups;

import org.bitbuckets.frc2014.commands.groups.IntakeBall;
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
public class AutoTwoBallDrive extends CommandGroup {
    
    public AutoTwoBallDrive() {
        addSequential(new RollerForward());
        addSequential(new IntakeDeploy());
        addSequential(new WaitMillis(250)); //t = .25
        addSequential(new RollerOff());
        addSequential(new WaitMillis(750)); //t = 1
        addSequential(new Fire()); //t = 1.3
        addSequential(new WaitMillis(750)); //t = 2.05
        addSequential(new ArmCatapult()); //t = 3.55
        addSequential(new RollerForward());
        addSequential(new WaitMillis(1500)); //t = 5.05
        addSequential(new IntakeRetract());
        addSequential(new RollerOff());
        addSequential(new WaitMillis(1000)); //t = 6.05
        addSequential(new IntakeBall());
        addSequential(new WaitMillis(1500)); //t = 7.55
        addSequential(new RollerOff());
        addSequential(new Fire()); //t = 8.85
        addSequential(new WaitMillis(250)); //t = 9.2
        addSequential(new IntakeRetract());
        addParallel(new DriveTimeMillis(.75,0,800)); //10.0
        addParallel(new ArmCatapult());
    }
}
