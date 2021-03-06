/* FRC 4183 - The Bit Buckets
 * Tucson, AZ
 *
 * FRC 2014 Codebase
 */

package org.bitbuckets.frc2014.subsystems;

import edu.wpi.first.wpilibj.Victor;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.DoubleSolenoid;
import org.bitbuckets.frc2014.RobotMap;
import org.bitbuckets.frc2014.commands.RetractIntake;

/**
 * @author    
 * 
 * Collection of actuators and sensors that form the intake subsystem.
 */
public class Intake extends Subsystem {
    /** Top ABS intake roller driven by RS550 on a Victor */
    private Victor rollerTop;
    /** Top ABS intake roller driven by RS550 on a Victor */
    private Victor rollerLeft;
    /** Top ABS intake roller driven by RS550 on a Victor */
    private Victor rollerRight;
    /** Two double-acting cylinders to raise/lower the intake arm */
    private DoubleSolenoid deployer;
    
    /**
     * Intake constructor, sets up intake rollers and arm solenoids.
     */
    public Intake() {
        super();
        rollerTop = new Victor(RobotMap.TOP_ROLLER_MOTOR);
        rollerLeft = new Victor(RobotMap.LEFT_ROLLER_MOTOR);
        rollerRight = new Victor(RobotMap.RIGHT_ROLLER_MOTOR);
        deployer = new DoubleSolenoid(RobotMap.INTAKE_SOLENOID_1, 
                RobotMap.INTAKE_SOLENOID_2);
    }
    
    /**
     * Default command to run when subsystems are all initialized.
     */
    public void initDefaultCommand() {
        new RetractIntake();
    }

    /**
     * Sets the speed of the intake roller.
     * @param   speed   intake roller speed from -1 (out) to 1 (in)
     */
    public void setIntakeRoller(double speed){
        rollerTop.set(speed);
        rollerLeft.set(-speed);
        rollerRight.set(speed);
    }
    
    /**
     * Sets the state of the intake arm.
     * @param   deployed    true to set intake out, false to pull it in
     */
    public void setDeployed(boolean deployed) {
        if(deployed) {
            deployer.set(DoubleSolenoid.Value.kForward);
        } else {
            deployer.set(DoubleSolenoid.Value.kReverse);
        }
    }
}