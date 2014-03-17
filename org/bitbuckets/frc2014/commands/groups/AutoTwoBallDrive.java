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
import org.bitbuckets.frc2014.commands.*;
import org.bitbuckets.frc2014.commands.groups.*;

/**
 *
 * @author Cal Miller cal@bpmpc.net
 */
public class AutoTwoBallDrive extends CommandGroup {
    
    public AutoTwoBallDrive() {
        addSequential(new IntakeDeployShortRoller());
        addSequential(new WaitMillis(500));
        addSequential(new DriveTimeMillis(.4,0,1500));
        addSequential(new WaitMillis(750));
        addSequential(new Fire());
        addSequential(new WaitMillis(250));
        addSequential(new ArmCatapult());
        addSequential(new RollerForward());
        addSequential(new WaitMillis(2000));
        addSequential(new RollerOff());
        addSequential(new Fire());
        addSequential(new WaitMillis(250));
        addSequential(new IntakeRetract());
        addParallel(new ArmCatapult());

    }
}
