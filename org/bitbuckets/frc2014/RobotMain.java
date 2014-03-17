/* FRC 4183 - The Bit Buckets
 * Tucson, AZ
 *
 * FRC 2014 Codebase
 */
package org.bitbuckets.frc2014;


import org.bitbuckets.frc2014.commands.groups.AutoOneBallDriveKevin;
import org.bitbuckets.frc2014.commands.groups.IntakeBall;
import edu.wpi.first.wpilibj.Compressor;
import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.Scheduler;
import org.bitbuckets.frc2014.commands.*;
import org.bitbuckets.frc2014.commands.groups.IntakeDeployShortRoller;
import org.bitbuckets.frc2014.commands.groups.IntakeOffRetract;

/**
 * The main robot class. Whenever the robot changes state, something here is called. This is were everything is called from.
 * 
 * @author Default
 */
public class RobotMain extends IterativeRobot {
    /** The compressor on the robot. */
    private Compressor compressor = new Compressor(RobotMap.PRESSURE_SWITCH, RobotMap.COMPRESSOR_RELAY);
    /** The autonomous selection switch to decide between two and one ball auto. Not yet implemented **/
    private DigitalInput autonSelect = new DigitalInput(RobotMap.AUTON_SELECT_SWITCH);
    /** The command that is executed in autonomous. This exists so it can be canceled when teleop starts so autonomous doesn't try to carry on running. **/
    private Command autonCommand;

    /**
     * The method that is called when the robot is turned on or code has finished downloading.
     */
    public void robotInit() {
        // Adds all the buttons 
        CommandBase.init();
        CommandBase.oi.fireButton.whenPressed(new Fire());
        CommandBase.oi.winchButton.whenPressed(new ArmCatapult());
        CommandBase.oi.outtakeButton.whenPressed(new RollerReverse());
        CommandBase.oi.outtakeButton.whenReleased(new RollerOff());
        CommandBase.oi.intakeButton.whenPressed(new IntakeBall());
        CommandBase.oi.intakeButton.whenReleased(new IntakeOffRetract());
        CommandBase.oi.catchButton.whenPressed(new IntakeDeployShortRoller());
        CommandBase.oi.catchButton.whenReleased(new IntakeRetract());
    }

    /**
     * The method run when autonomous is initialized. Initializes the autonomous command, starts the compressor, and starts the autonomous command.
     */
    public void autonomousInit() {
        autonCommand = new AutoOneBallDriveKevin();//AutoOneBall();
        compressor.start();
        autonCommand.start();
    }

    /**
     * The method that is called periodically throughout autonomous. Polls the current running commands. In this case, only autonomous command.
     */
    public void autonomousPeriodic() {
        Scheduler.getInstance().run();
    }

    /**
     * The method run when teleop is initialized. If the autonomous command exists, it KEELs it. Also makes sure the compressor is running if autonomous hasn't happened.
     */
    public void teleopInit() {
        if(autonCommand != null) {
            autonCommand.cancel();
        }
        compressor.start();
    }

    /**
     * The method that is called periodically throughout teleop. Polls any currently running commands and inputs the joystick axes to the drive command that is being used.
     */
    public void teleopPeriodic() {
        Scheduler.getInstance().run();
        //CommandBase.driveTrain.tankDrive(CommandBase.oi.JoyRight.getAxis(Joystick.AxisType.kY), CommandBase.oi.JoyLeft.getAxis(Joystick.AxisType.kY));
        //CommandBase.driveTrain.drive(CommandBase.oi.Control.getY(), CommandBase.oi.Control.getX());
        CommandBase.driveTrain.cheesyDrive(-CommandBase.oi.Control.getY(), -CommandBase.oi.Control.getX());
        //System.out.println(CommandBase.oi.Control.getY()+"  "+ CommandBase.oi.Control.getX());
    }
}