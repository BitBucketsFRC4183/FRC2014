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
public class TwoBallAuto extends CommandGroup {
    
    public TwoBallAuto() {
        addSequential(new RollerOn());
        addSequential(new DeployIntake());
        addSequential(new WaitMillis(250)); //t = .25
        addSequential(new RollerOff());
        addSequential(new WaitMillis(750)); //t = 1
        addSequential(new Fire()); //t = 1.3
        addSequential(new WaitMillis(750)); //t = 1
        addSequential(new ArmCatapult()); //t = 2
        addSequential(new RollerOn());
        addSequential(new WaitMillis(1500)); //t = 3
        addSequential(new RetractIntake());
        addSequential(new RollerOff());
        addSequential(new WaitMillis(750)); //t = 3.8
        addSequential(new DeployIntake());
        addSequential(new RollerOn());
        addSequential(new WaitMillis(1500)); //t = 4.8
        addSequential(new RollerOff());
        addSequential(new Fire()); //t = 5.2
        addSequential(new WaitMillis(750)); //t = 6.2
        addSequential(new RetractIntake());
        addParallel(new DriveTimeMillis(.5,0,1500)); //t = 8.7
        addParallel(new ArmCatapult());
    }
}
