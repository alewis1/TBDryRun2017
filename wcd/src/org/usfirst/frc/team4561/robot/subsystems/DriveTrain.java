package org.usfirst.frc.team4561.robot.subsystems;

import com.ctre.CANTalon;

import edu.wpi.first.wpilibj.RobotDrive;

import edu.wpi.first.wpilibj.command.Subsystem;
import org.usfirst.frc.team4561.robot.RobotMap;

import com.ctre.CANTalon;
import edu.wpi.first.wpilibj.RobotDrive;

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
		/*if (arcadeOrTank == 1) {
			setDefaultCommand(arcadeDrive());
		}
		else {
			setDefaultCommand(tankDrive());
		}*/
    }
	
	public DriveTrain() {
		frontRight = new CANTalon(RobotMap.topRightMotor);
		frontLeft = new CANTalon(RobotMap.topLeftMotor);
		
		midRight = new CANTalon(RobotMap.midRightMotor);
		
		// Sets other motors as slaves to masters FrontLeft/Right, set doesn't set power, it sets a slave
		midRight.changeControlMode(CANTalon.TalonControlMode.Follower);
		midRight.set(RobotMap.topRightMotor);
		
		rearRight = new CANTalon(RobotMap.botRightMotor);
		rearRight.changeControlMode(CANTalon.TalonControlMode.Follower);
		rearRight.set(RobotMap.topRightMotor);
		
		midLeft = new CANTalon(RobotMap.midLeftMotor);
		midLeft.changeControlMode(CANTalon.TalonControlMode.Follower);
		midLeft.set(RobotMap.topLeftMotor);
		
		rearLeft = new CANTalon(RobotMap.botLeftMotor);
		rearLeft.changeControlMode(CANTalon.TalonControlMode.Follower);
		rearLeft.set(RobotMap.topLeftMotor);
		
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
