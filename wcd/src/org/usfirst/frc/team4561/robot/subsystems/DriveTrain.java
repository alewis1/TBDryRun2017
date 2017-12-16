package org.usfirst.frc.team4561.robot.subsystems;

import com.ctre.CANTalon;

import edu.wpi.first.wpilibj.RobotDrive;

import edu.wpi.first.wpilibj.command.Subsystem;
import org.usfirst.frc.team4561.robot.RobotMap;

import com.ctre.CANTalon;
import edu.wpi.first.wpilibj.RobotDrive;
import org.usfirst.frc.team4561.robot.commands.DriveArcade;
import org.usfirst.frc.team4561.robot.commands.DriveTank;

/**
 *
 */
public class DriveTrain extends Subsystem {

	private CANTalon frontRight;
	private CANTalon frontLeft;
	
	private CANTalon midRight;
	private CANTalon midLeft;
	
	private CANTalon rearRight;
	private CANTalon rearLeft;
		
	private RobotDrive robotDrive; 

	public void initDefaultCommand() {
		if (RobotMap.DRIVE_MODE == 1) {
			setDefaultCommand(new DriveArcade());
		}
		else {
			setDefaultCommand(new DriveTank());
		}
    }
	
	public DriveTrain() {
		frontRight = new CANTalon(RobotMap.FRONT_RIGHT_MOTOR_PORT);
		frontLeft = new CANTalon(RobotMap.FRONT_LEFT_MOTOR_PORT);
		
		midRight = new CANTalon(RobotMap.MID_RIGHT_MOTOR_PORT);
		
		// Sets other motors as slaves to masters FrontLeft/Right, set doesn't set power, it sets a slave
		midRight.changeControlMode(CANTalon.TalonControlMode.Follower);
		midRight.set(RobotMap.FRONT_RIGHT_MOTOR_PORT);
		
		rearRight = new CANTalon(RobotMap.BOT_RIGHT_MOTOR_PORT);
		rearRight.changeControlMode(CANTalon.TalonControlMode.Follower);
		rearRight.set(RobotMap.FRONT_RIGHT_MOTOR_PORT);
		
		midLeft = new CANTalon(RobotMap.MID_LEFT_MOTOR_PORT);
		midLeft.changeControlMode(CANTalon.TalonControlMode.Follower);
		midLeft.set(RobotMap.FRONT_LEFT_MOTOR_PORT);
		
		rearLeft = new CANTalon(RobotMap.BOT_LEFT_MOTOR_PORT);
		rearLeft.changeControlMode(CANTalon.TalonControlMode.Follower);
		rearLeft.set(RobotMap.FRONT_LEFT_MOTOR_PORT);
		
		// Puts motors into RobotDrive class
		robotDrive = new RobotDrive(frontLeft, frontRight);

	}
	
	public void tankDrive(double leftPower, double rightPower) {
		robotDrive.tankDrive(leftPower, rightPower);
	}
	
	public void arcadeDrive (double leftPower, double rightPower) {
		robotDrive.arcadeDrive(leftPower, rightPower);
	}
}
