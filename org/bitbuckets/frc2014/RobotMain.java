/*----------------------------------------------------------------------------*/
/* Copyright (c) FIRST 2008. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package org.bitbuckets.frc2014;


import edu.wpi.first.wpilibj.Compressor;
import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.Scheduler;
import edu.wpi.first.wpilibj.livewindow.LiveWindow;
import org.bitbuckets.frc2014.commands.*;

/**
 * The VM is configured to automatically run this class, and to call the
 * functions corresponding to each mode, as described in the IterativeRobot
 * documentation. If you change the name of this class or the package after
 * creating this project, you must also update the manifest file in the resource
 * directory.
 */
public class RobotMain extends IterativeRobot {
    /**
     * The compressor.
     */
    private Compressor compressor = new Compressor(RobotMap.PRESSURE_SWITCH, RobotMap.COMPRESSOR_RELAY);
    private Command autonomousCommand;

    /**
     * This function is run when the robot is first started up and should be
     * used for any initialization code.
     */
    public void robotInit() {
        // instantiate the command used for the autonomous period
        autonomousCommand = new ExampleCommand();
        
        // Initialize all subsystems
        CommandBase.init();
        CommandBase.oi.fireButton.whenPressed(new Fire());
        CommandBase.oi.fireButton.whenReleased(new UnFire());
        CommandBase.oi.intakeRollerButton.whenPressed(new RollerOn());
        CommandBase.oi.intakeRollerButton.whenReleased(new RollerOff());
        CommandBase.oi.outtakeButton.whenPressed(new OuttakeBall());
        CommandBase.oi.outtakeButton.whenReleased(new IntakeBallOff());
        CommandBase.oi.intakeDeployButton.whenPressed(new DeployIntake());
        CommandBase.oi.intakeDeployButton.whenReleased(new RetractIntake());
        CommandBase.oi.intakeButton.whenPressed(new IntakeBall());
        CommandBase.oi.intakeButton.whenReleased(new IntakeBallOff());
    }

    /**
     * The method run at the beginning of autonomous.
     */
    public void autonomousInit() {
        // schedule the autonomous command (example)
        autonomousCommand.start();
    }

    /**
     * This function is called periodically during autonomous
     */
    public void autonomousPeriodic() {
        Scheduler.getInstance().run();
    }

    /**
     * The code that runs at the beginning of teleop.
     */
    public void teleopInit() {
	// This makes sure that the autonomous stops running when
        // teleop starts running. If you want the autonomous to 
        // continue until interrupted by another command, remove
        // this line or commen tit out.
        
        compressor.start();
        
        //new DriveTeleop();
        
        autonomousCommand.cancel();
    }

    /**
     * This function is called periodically during operator control
     */
    public void teleopPeriodic() {
        Scheduler.getInstance().run();
        CommandBase.dt.drive(CommandBase.oi.stick.getAxis(Joystick.AxisType.kX), CommandBase.oi.stick.getAxis(Joystick.AxisType.kY));

    }
    
    /**
     * This function is called periodically during test mode
     */
    public void testPeriodic() {
        LiveWindow.run();
    }
}
