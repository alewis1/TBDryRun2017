package org.usfirst.frc.team4561.robot.commands;

import org.usfirst.frc.team4561.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;


public class DriveArcade extends Command {
	
	
	
	public DriveArcade() {
		
		requires(Robot.DriveTrain);
	}
	
	  protected void execute() {
		  
	    	Robot.DriveTrain.arcadeDrive(Robot.oi.getRightStickX(), Robot.oi.getRightStickY());
	    }	  
	  
	  protected void initialize() {}
	  
	  
	  
	  protected void end() {}
	  
	  
	  
	  protected void interrupted() {
		  end();
	  }
	  
	@Override
	protected boolean isFinished() {
		// TODO Auto-generated method stub
		return false;
	}

}
