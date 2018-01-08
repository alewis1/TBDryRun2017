package org.usfirst.frc.team4561.robot.subsystems;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;
import com.ctre.phoenix.motorcontrol.ControlMode;

import edu.wpi.first.wpilibj.command.Subsystem;
import org.usfirst.frc.team4561.robot.RobotMap;

import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import org.usfirst.frc.team4561.robot.commands.DriveArcade;
import org.usfirst.frc.team4561.robot.commands.DriveTank;

/**
 *
 */
public class DriveTrain extends Subsystem {

	private WPI_TalonSRX frontRight;
	private WPI_TalonSRX frontLeft;
	
	private WPI_TalonSRX midRight;
	private WPI_TalonSRX midLeft;
	
	private WPI_TalonSRX rearRight;
	private WPI_TalonSRX rearLeft;
	
	private ControlMode follower = com.ctre.phoenix.motorcontrol.ControlMode.Follower;
	private ControlMode percentOutput = com.ctre.phoenix.motorcontrol.ControlMode.PercentOutput;
		
	private DifferentialDrive robotDrive; 

	public void initDefaultCommand() {
		if (RobotMap.DRIVE_MODE == 1) {
			setDefaultCommand(new DriveArcade());
		}
		else {
			setDefaultCommand(new DriveTank());
		}
    }
	
	public DriveTrain() {
		frontRight = new WPI_TalonSRX(RobotMap.FRONT_RIGHT_MOTOR_PORT);
		frontLeft = new WPI_TalonSRX(RobotMap.FRONT_LEFT_MOTOR_PORT);
		
		midRight = new WPI_TalonSRX(RobotMap.MID_RIGHT_MOTOR_PORT);
		
		// Sets other motors as slaves to masters FrontLeft/Right, set doesn't set power, it sets a slave
		midRight.set(follower, RobotMap.FRONT_RIGHT_MOTOR_PORT);
		
		rearRight = new WPI_TalonSRX(RobotMap.BOT_RIGHT_MOTOR_PORT);
		rearRight.set(follower, RobotMap.FRONT_RIGHT_MOTOR_PORT);
		
		midLeft = new WPI_TalonSRX(RobotMap.MID_LEFT_MOTOR_PORT);
		midLeft.set(follower, RobotMap.FRONT_LEFT_MOTOR_PORT);
		
		rearLeft = new WPI_TalonSRX(RobotMap.BOT_LEFT_MOTOR_PORT);
		rearLeft.set(follower, RobotMap.FRONT_LEFT_MOTOR_PORT);
		
		// Puts motors into RobotDrive class
		robotDrive = new DifferentialDrive(frontLeft, frontRight);

	}
	
	public void tankDrive(double leftPower, double rightPower) {
		robotDrive.tankDrive(leftPower, rightPower);
	}
	
	public void arcadeDrive (double leftPower, double rightPower) {
		robotDrive.arcadeDrive(leftPower, rightPower);
	}
}
