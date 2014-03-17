/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.bitbuckets.frc2014.commands.groups;

import edu.wpi.first.wpilibj.command.CommandGroup;
import org.bitbuckets.frc2014.commands.DriveTimeMillis;

/**
 *
 * @author Cal Miller cal@bpmpc.net
 */
public class AutoDrive extends CommandGroup {
    
    public AutoDrive() {
        addParallel(new DriveTimeMillis(.75,0,1250)); //10.0
    }
}
