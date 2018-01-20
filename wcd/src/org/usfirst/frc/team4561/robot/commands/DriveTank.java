package org.usfirst.frc.team4561.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

import org.usfirst.frc.team4561.robot.Robot;

/**
 *
 */
public class DriveTank extends Command {
	
	public DriveTank() {
		requires(Robot.driveTrain);
	}

	// Called just before this Command runs the first time
	@Override
	protected void initialize() {
	}

	// Called repeatedly when this Command is scheduled to run
	@Override
	protected void execute() {
			Robot.driveTrain.tankDrive(Robot.oi.getLeftStickY(),-Robot.oi.getLeftStickY());
		SmartDashboard.putNumber("Left Speed", Robot.driveTrain.getLeftSpeed());
		SmartDashboard.putNumber("Right Speed", Robot.driveTrain.getRightSpeed());
		SmartDashboard.putNumber("Left Pos", Robot.driveTrain.getLeftPos());
		SmartDashboard.putNumber("Right Pos", Robot.driveTrain.getRightPos());
	}

	// Make this return true when this Command no longer needs to run execute()
	@Override
	protected boolean isFinished() {
		return false;
	}

	// Called once after isFinished returns true
	@Override
	protected void end() {
	}

	// Called when another command which requires one or more of the same
	// subsystems is scheduled to run
	@Override
	protected void interrupted() {
	}
}
