package org.usfirst.frc.team4561.robot.commands;

import org.usfirst.frc.team4561.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

public class TurnAround extends Command {

	@Override
	protected boolean isFinished() {
		// TODO Auto-generated method stub
		return true;
	}
	
	protected void execute(){
		Robot.driveTrain.resetGyro();
		Robot.driveTrain.goToAngle(180);
	}

}
