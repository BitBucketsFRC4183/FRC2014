/* FRC 4183 - The Bit Buckets
 * Tucson, AZ
 *
 * FRC 2014 Codebase
 */
package org.bitbuckets.frc2014;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.Button;
import edu.wpi.first.wpilibj.buttons.JoystickButton;
import org.bitbuckets.frc2014.commands.*;

/**
 * 
 * 
 * @author Default
 */
public class OI {
    /**
     * The main joystick, will be a eStop Robotics CCI(Custom Control Interface)
     */
    public Joystick stick = new Joystick(RobotMap.JOY_1_PORT);
    
    /**
     * The button that fires the ball.
     */
    public Button fireButton = new JoystickButton(stick, 1);
    /**
     * The button that deploys the intake.
     */
    public Button intakeDeployButton = new JoystickButton(stick, 4);
    public Button latchPiston = new JoystickButton(stick, 5);
    /**
     * The button that deploys the intake and runs the roller in.
     */
    public Button outtakeButton = new JoystickButton(stick, 6);
    /**
     * The button that deploys the intake and runs the roller.
     */
    public Button intakeButton = new JoystickButton(stick, 8);
    /**
     * The button that runs the intake motor backwards.
     */
    public Button retractButton = new JoystickButton(stick, 9);
    /**
     * The button that makes the intake roller roll in.
     */
    public Button intakeRollerButton = new JoystickButton(stick, 12);
    /**
     * The button that controls the catapult winch
     */
    public Button winchButton = new JoystickButton(stick, 2);
     /**
     * The button that starts and stops the lights
     */
    //public Button lightsOnOffButton = new JoystickButton(stick, //needs to be bound to button//;
   
}

