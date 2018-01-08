package org.usfirst.frc.team4561.robot.commands;

import org.usfirst.frc.team4561.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;


public class DriveArcade extends Command {
	
	public DriveArcade() {
		requires(Robot.driveTrain);
	}
	
	protected void execute() {
		Robot.driveTrain.arcadeDrive(Robot.oi.getRightStickX(), Robot.oi.getRightStickY());
	}	  
	  
	protected void initialize() {}
	  
	protected void end() {}
	  
	protected void interrupted() {
		end();
	}
	
	@Override
	protected boolean isFinished() {
		return false;
	}

}
