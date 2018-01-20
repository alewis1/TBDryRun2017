package org.usfirst.frc.team4561.robot.commands;

import org.usfirst.frc.team4561.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

public class ResetEncoders extends Command {

	@Override
	protected void execute() {
		Robot.driveTrain.resetEncoders();
	}
	protected boolean isFinished() {
		// TODO Auto-generated method stub
		return false;
	}

}
