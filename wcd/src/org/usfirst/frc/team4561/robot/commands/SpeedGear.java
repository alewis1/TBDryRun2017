package org.usfirst.frc.team4561.robot.commands;

import org.usfirst.frc.team4561.robot.Robot;
import org.usfirst.frc.team4561.robot.RobotMap;

import edu.wpi.first.wpilibj.command.Command;

/**
 * Changes the gear to the speed gear.
 * Requires the Transmission solenoid.
 * TODO: Change names
 * @author Zane T, Ben G
 */
public class SpeedGear extends Command {

    public SpeedGear() {
        // requires(Robot.transmission);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	setTimeout(1);
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	// Actually change the gear
    	// Robot.transmission.speedGear();
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return isTimedOut();
    }

    // Called once after isFinished returns true
    protected void end() {
    	// Robot.transmission.stop();
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    	end();
    }
}
