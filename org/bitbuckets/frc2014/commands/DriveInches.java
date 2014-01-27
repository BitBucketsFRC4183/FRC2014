
package org.bitbuckets.frc2014.commands;

import edu.wpi.first.wpilibj.PIDController;
import org.bitbuckets.frc2014.RandomConstants;

/**
 *
 * @author bradmiller
 */
public class DriveInches extends CommandBase {

    private double ticks;
    private PIDController pidControlR;
    private PIDController pidControlL;
    
    public DriveInches(double inches) {
        // Use requires() here to declare subsystem dependencies
        requires(dt);
        ticks = inches*RandomConstants.TICKS_PER_INCH;
//        pidControlR = new PIDController(RandomConstants.INCH_PID_KP, RandomConstants.INCH_PID_KI, RandomConstants.INCH_PID_KD, RandomConstants.INCH_PID_KF, dt.encR, );
//        pidControlL = new PIDController(RandomConstants.INCH_PID_KP, RandomConstants.INCH_PID_KI, RandomConstants.INCH_PID_KD, RandomConstants.INCH_PID_KF, dt.encL, );
        
        pidControlR.setSetpoint(ticks);
        pidControlL.setSetpoint(ticks);
        
        pidControlR.setPercentTolerance(RandomConstants.INCH_PID_TOL);
        pidControlL.setPercentTolerance(RandomConstants.INCH_PID_TOL);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
        pidControlR.enable();
        pidControlL.enable();
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
        
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return false;
    }

    // Called once after isFinished returns true
    protected void end() {
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}
