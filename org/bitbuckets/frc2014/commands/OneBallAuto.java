/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.bitbuckets.frc2014.commands;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 * @author Cal Miller cal@bpmpc.net
 */
public class OneBallAuto extends CommandGroup {
    
    public OneBallAuto() {
        addSequential(new ArmCatapult()); //t = 3.55
        addSequential(new DeployIntake());
        addParallel(new RollerOn());
        addSequential(new WaitMillis(1500)); //t = 5.05
        addSequential(new RetractIntake());
        addSequential(new WaitMillis(1000)); //t = 6.05
        addSequential(new DriveTimeMillis(.5,0,2500)); //10.0
        addSequential(new WaitMillis(500)); //t=.5
        addSequential(new DeployIntake());
        addParallel(new RollerOn());
        addSequential(new WaitMillis(500)); //t = 1
        addSequential(new RollerOff());
        addSequential(new WaitMillis(750)); //t = 1.75
        addSequential(new Fire());
        addSequential(new WaitMillis(750)); //t = 2.5
        addSequential(new ArmCatapult());
        addParallel(new RetractIntake());
    }
}
