/* FRC 4183 - The Bit Buckets
 * Tucson, AZ
 *
 * FRC 2014 Codebase
 */
package org.bitbuckets.frc2014;


import edu.wpi.first.wpilibj.Compressor;
import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.Scheduler;
import edu.wpi.first.wpilibj.livewindow.LiveWindow;
import org.bitbuckets.frc2014.commands.*;

/**
 * 
 * 
 * @author Default
 */
public class RobotMain extends IterativeRobot {
    /** The compressor. */
    private Compressor compressor = new Compressor(RobotMap.PRESSURE_SWITCH, RobotMap.COMPRESSOR_RELAY);
    private DigitalInput autonSelect = new DigitalInput(RobotMap.AUTON_SELECT_SWITCH); 
    private Command autonCommand;

    /**
     * The method that is called when the robot is turned on or code has finished downloading.
     */
    public void robotInit() {
        // Initialize all subsystems
        CommandBase.init();
        CommandBase.oi.fireButton.whenPressed(new Fire());
        CommandBase.oi.winchButton.whenPressed(new ArmCatapult());
        CommandBase.oi.outtakeButton.whenPressed(new OuttakeBall());
        CommandBase.oi.outtakeButton.whenReleased(new RollerOff());
        CommandBase.oi.intakeButton.whenPressed(new IntakeBall());
        CommandBase.oi.intakeButton.whenReleased(new RetractIntake());
        CommandBase.oi.catchButton.whenPressed(new DeployIntake());
        CommandBase.oi.catchButton.whenReleased(new RetractIntake());
    }

    /**
     * The method run when autonomous is started.
     */
    public void autonomousInit() {
        autonCommand = new OneBallDriving();//OneBallAuto();
        compressor.start();
        autonCommand.start();
    }

    /**
     * The method that is called periodically throughout autonomous.
     */
    public void autonomousPeriodic() {
        Scheduler.getInstance().run();
    }

    /**
     * The method run when teleop is started.
     */
    public void teleopInit() {
	// This makes sure that the autonomous stops running when
        // teleop starts running. If you want the autonomous to 
        // continue until interrupted by another command, remove
        // this line or commen tit out.
        
        System.out.print("Teleop Started");
        if(autonCommand != null) {
            autonCommand.cancel();
        }
        compressor.start();
    }

    /**
     * The method that is called periodically throughout teleop.
     */
    public void teleopPeriodic() {
        Scheduler.getInstance().run();
        //CommandBase.driveTrain.tankDrive(CommandBase.oi.JoyRight.getAxis(Joystick.AxisType.kY), CommandBase.oi.JoyLeft.getAxis(Joystick.AxisType.kY));
        //CommandBase.driveTrain.drive(CommandBase.oi.Control.getY(), CommandBase.oi.Control.getX());
        CommandBase.driveTrain.cheesyDrive(-CommandBase.oi.Control.getY(), -CommandBase.oi.Control.getX());
        //System.out.println(CommandBase.oi.Control.getY()+"  "+ CommandBase.oi.Control.getX());
    }
    
    /**
     * The method that is called periodically throughout test.
     */
    public void testPeriodic() {
        LiveWindow.run();
    }
}
