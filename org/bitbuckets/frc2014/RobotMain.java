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
    DoubleSolenoid solenoid1 = new DoubleSolenoid(1, 2);
    DoubleSolenoid solenoid2 = new DoubleSolenoid(3, 4);
    DoubleSolenoid solenoid3 = new DoubleSolenoid(5, 6);
    DoubleSolenoid solenoid4 = new DoubleSolenoid(7, 8);
    
    Compressor compressor = new Compressor(RobotMap.PRESSURE_SWITCH, RobotMap.COMPRESSOR_RELAY);

    Command autonomousCommand;

    /**
     * This function is run when the robot is first started up and should be
     * used for any initialization code.
     */
    public void robotInit() {
        // instantiate the command used for the autonomous period
        autonomousCommand = new ExampleCommand();

        compressor.start();
        
        // Initialize all subsystems
        CommandBase.init();
    }

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

    public void teleopInit() {
	// This makes sure that the autonomous stops running when
        // teleop starts running. If you want the autonomous to 
        // continue until interrupted by another command, remove
        // this line or comment it out.
        autonomousCommand.cancel();
    }

    /**
     * This function is called periodically during operator control
     */
    public void teleopPeriodic() {
        Scheduler.getInstance().run();
        CommandBase.dt.drive(CommandBase.oi.stick.getAxis(Joystick.AxisType.kX), CommandBase.oi.stick.getAxis(Joystick.AxisType.kY));//our axis are reversed
        CommandBase.oi.intake_deploy_button.whileHeld(new IntakeBall());
        CommandBase.oi.intake_roller_button.whenPressed(new RollerOn());
        CommandBase.oi.intake_roller_button.whenReleased(new RollerOff());
        CommandBase.oi.intake_deploy_button.whenPressed(new DeployIntake());
        CommandBase.oi.intake_deploy_button.whenReleased(new RetractIntake());
        
    }
    
    /**
     * This function is called periodically during test mode
     */
    public void testPeriodic() {
        LiveWindow.run();
    }
}
