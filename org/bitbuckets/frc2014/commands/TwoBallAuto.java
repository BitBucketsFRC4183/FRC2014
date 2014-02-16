/* FRC 4183 - The Bit Buckets
 * Tucson, AZ
 *
 * FRC 2014 Codebase
 */

package org.bitbuckets.frc2014.commands;

/**
 * @author    Cal Miller cal@bpmpc.net
 * 
 * <description>
 */

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 * @author Cal Miller
 */
public class TwoBallAuto extends CommandGroup {
    public TwoBallAuto() {
        //need to change Fire and ArmCatapult commands.  I'm using them as suggested in issue #25 on Github.
        addSequential(new ArmCatapult());
        addSequential(new DriveStraight(24,36));
        addSequential(new Fire());
        addSequential(new RollerOn());
        addSequential(new WaitMillis(1000));
        addSequential(new RetractIntake());
        addSequential(new WaitMillis(500));
        addSequential(new ArmCatapult());
        addSequential(new Fire());
        addSequential(new DriveStraight(36,36));
        addParallel(new RetractIntake());
        addSequential(new DriveTurn(180,270));

    }
    
}
