/* FRC 4183 - The Bit Buckets
 * Tucson, AZ
 *
 * FRC 2014 Codebase
 */
package org.bitbuckets.frc2014.commands;

import edu.wpi.first.wpilibj.command.Command;
import org.bitbuckets.frc2014.OI;
import org.bitbuckets.frc2014.subsystems.Catapault;
import org.bitbuckets.frc2014.subsystems.DriveTrain;
import org.bitbuckets.frc2014.subsystems.Intake;

/**
 * The base for all commands. All commands should extend CommandBase. It stores all of the subsystems to be used by the commands(and sometimes something else, like RobotMain).
 * @author Default
 */
public abstract class CommandBase extends Command {
    /** The operator interface. **/
    public static OI oi;
    /** The drivetrain on the bottom of the robot. **/
    public static DriveTrain driveTrain;
    /** The intake on the front of the robot. **/
    public static Intake intake;
    /** The catapult in the middle of the robot. **/
    public static Catapault catapult;

    /**
     * The default constructor. Sets the name of this 'command' to "Command Base".
     */
    public CommandBase() {
        super("Command Base");
    }

    /**
     * Initializes all of the subsystems. Also, DO NOT delete or move this, or everything will break. It's kinda sorta maybe just a little important.
     */
    public static void init() {
        // Please do NOT move or delete this. It will break stuff. Just don't.
        oi = new OI();
        driveTrain = new DriveTrain();
        intake = new Intake();
        catapult = new Catapault();
    }
}
