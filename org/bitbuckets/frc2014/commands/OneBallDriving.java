/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.bitbuckets.frc2014.commands;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 * @author admin
 */
public class OneBallDriving extends CommandGroup {
    
    public OneBallDriving() {
        CommandGroup firingseq = new CommandGroup();
        firingseq.addSequential(new WaitMillis(500));
        firingseq.addSequential(new RollerOn());
        firingseq.addSequential(new WaitMillis(100));
        firingseq.addSequential(new DeployIntake());
        firingseq.addSequential(new WaitMillis(1700));
        firingseq.addSequential(new Fire());
        firingseq.addSequential(new WaitMillis(500));
        
        //Start Auto        
        addSequential(new ArmCatapult()); //t = 3.55
        addSequential(new DeployIntake());
        addParallel(new RollerOn());
        addSequential(new WaitMillis(1500)); //t = 5.05
        addSequential(new RetractIntake());
        addSequential(new WaitMillis(1000)); //t = 6.05
        addParallel(new DriveTimeMillis(.5,0,3500)); //10.0
        addSequential(firingseq);
        addSequential(new ArmCatapult());
    }
}
