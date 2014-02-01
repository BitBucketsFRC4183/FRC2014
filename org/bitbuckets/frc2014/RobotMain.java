/*----------------------------------------------------------------------------*/
/* Copyright (c) FIRST 2008. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file intake the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package org.bitbuckets.frc2014;


import edu.wpi.first.wpilibj.Compressor;
import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.Scheduler;
import edu.wpi.first.wpilibj.livewindow.LiveWindow;
import org.bitbuckets.frc2014.commands.*;

/**
 * The VM is configured to automatically run this class, and to call the
 functions corresponding to each mode, as described intake the IterativeRobot
 documentation. If you change the name of this class or the package after
 creating this project, you must also update the manifest file intake the resource
 directory.
 */
public class RobotMain extends IterativeRobot {
    /** The compressor. */
    private Compressor compressor = new Compressor(RobotMap.PRESSURE_SWITCH, RobotMap.COMPRESSOR_RELAY);

    /**
     * The method that is called when the robot is turned on or code has finished downloading.
     */
    public void robotInit() {
        // Initialize all subsystems
        CommandBase.init();
        CommandBase.oi.fireButton.whenPressed(new Fire());
        CommandBase.oi.retractButton.whenPressed(new UnFire());
        CommandBase.oi.intakeRollerButton.whenPressed(new RollerOn());
        CommandBase.oi.intakeRollerButton.whenReleased(new RollerOff());
        CommandBase.oi.outtakeButton.whenPressed(new OuttakeBall());
        CommandBase.oi.outtakeButton.whenReleased(new RollerOff());
        CommandBase.oi.intakeDeployButton.whenPressed(new DeployIntake());
        CommandBase.oi.intakeDeployButton.whenReleased(new RetractIntake());
        CommandBase.oi.intakeButton.whenPressed(new IntakeBall());
        CommandBase.oi.intakeButton.whenReleased(new IntakeBallOff());
        //CommandBase.oi.lightsOnOffButton.whenPressed(new SimpleLights());
    }

    /**
     * The method run when autonomous is started.
     */
    public void autonomousInit() {
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
        
        compressor.start();
    }

    /**
     * The method that is called periodically throughout teleop.
     */
    public void teleopPeriodic() {
        Scheduler.getInstance().run();
        CommandBase.driveTrain.drive(CommandBase.oi.stick.getAxis(Joystick.AxisType.kX), 
                CommandBase.oi.stick.getAxis(Joystick.AxisType.kY));
    }
    
    /**
     * The method that is called periodically throughout test.
     */
    public void testPeriodic() {
        LiveWindow.run();
    }
}
