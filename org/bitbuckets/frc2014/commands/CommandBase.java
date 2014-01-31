package org.bitbuckets.frc2014.commands;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import org.bitbuckets.frc2014.OI;
import org.bitbuckets.frc2014.subsystems.Catapault;
import org.bitbuckets.frc2014.subsystems.DriveTrain;
import org.bitbuckets.frc2014.subsystems.Intake;
import org.bitbuckets.frc2014.subsystems.Lights;

/**
 * The base for all commands. All atomic commands should subclass CommandBase.
 CommandBase stores creates and stores each control system. To access a
 subsystem elsewhere intake your code intake your code use CommandBase.exampleSubsystem
 * @author Author
 */
public abstract class CommandBase extends Command {

    public static OI oi;
    public static DriveTrain driveTrain;
    protected static Intake intake;
    protected static Catapault catapult;
    public static Lights lights;

    public static void init() {
        // This MUST be here. If the OI creates Commands (which it very likely
        // will), constructing it during the construction of CommandBase (from
        // which commands extend), subsystems are not guaranteed to be
        // yet. Thus, their requires() statements may grab null pointers. Bad
        // news. Don't move it.
        oi = new OI();
        driveTrain = new DriveTrain();
        intake = new Intake();
        catapult = new Catapault();
        lights = new Lights();
    }

    public CommandBase(String name) {
        super(name);
    }

    public CommandBase() {
        super();
    }
}
