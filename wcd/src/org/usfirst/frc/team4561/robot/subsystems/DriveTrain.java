package org.usfirst.frc.team4561.robot.subsystems;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;
import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.FeedbackDevice;
import com.ctre.phoenix.motorcontrol.StatusFrameEnhanced;

import edu.wpi.first.wpilibj.command.Subsystem;
import org.usfirst.frc.team4561.robot.RobotMap;

import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import org.usfirst.frc.team4561.robot.commands.DriveArcade;
import org.usfirst.frc.team4561.robot.commands.DriveMagic;
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
			setDefaultCommand(new DriveMagic());
		}
    }
	
	public DriveTrain() {
		frontRight = new WPI_TalonSRX(RobotMap.FRONT_RIGHT_MOTOR_PORT);
		frontLeft = new WPI_TalonSRX(RobotMap.FRONT_LEFT_MOTOR_PORT);
		
		//frontLeft.configSelectedFeedbackSensor(FeedbackDevice.QuadEncoder, 0,0);
		//frontRight.configSelectedFeedbackSensor(FeedbackDevice.QuadEncoder, 0, 0);
		
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
		//robotDrive = new DifferentialDrive(frontLeft, frontRight);
		
		frontLeft.setSelectedSensorPosition(0, 0, 0);
		frontRight.setSelectedSensorPosition(0, 0, 0);
		
		frontLeft.config_kF(0, 0.226, 0);
		frontLeft.config_kP(0, 2, 0);
		frontLeft.config_kI(0, 0.005, 0);
		frontLeft.config_kD(0, 20, 0);
		frontLeft.config_IntegralZone(0, 50, 0);
		frontLeft.configMotionCruiseVelocity(1333, 0);
		frontLeft.configMotionAcceleration(333, 0);
		frontLeft.configNominalOutputForward(0, 0);
		frontLeft.configNominalOutputReverse(0, 0);
		frontLeft.configPeakOutputForward(1, 0);
		frontLeft.configPeakOutputReverse(-1, 0);
		frontLeft.setStatusFramePeriod(StatusFrameEnhanced.Status_13_Base_PIDF0, 10, 0);
		frontLeft.setStatusFramePeriod(StatusFrameEnhanced.Status_10_MotionMagic, 10, 0);
		
		frontRight.config_kF(0, 0.51, 0);
		frontRight.config_kP(0, 2, 0);
		frontRight.config_kI(0, 0.005, 0);
		frontRight.config_kD(0, 20, 0);
		frontRight.config_IntegralZone(0, 50, 0);
		frontRight.configMotionCruiseVelocity(670, 0);
		frontRight.configMotionAcceleration(166, 0);
		frontRight.configNominalOutputForward(0, 0);
		frontRight.configNominalOutputReverse(0, 0);
		frontRight.configPeakOutputForward(1, 0);
		frontRight.configPeakOutputReverse(-1, 0);
		frontRight.setStatusFramePeriod(StatusFrameEnhanced.Status_13_Base_PIDF0, 10, 0);
		frontRight.setStatusFramePeriod(StatusFrameEnhanced.Status_10_MotionMagic, 10, 0);

	}
	
	public void tankDrive(double leftPower, double rightPower) {
		frontLeft.set(ControlMode.PercentOutput, leftPower);
		frontRight.set(ControlMode.PercentOutput, rightPower);
		//robotDrive.tankDrive(leftPower, rightPower);
	}
	
	public void arcadeDrive (double leftPower, double rightPower) {
		//robotDrive.arcadeDrive(leftPower, rightPower);
	}
	public void magicDrive (double leftRot, double rightRot){
		frontLeft.set(ControlMode.MotionMagic, leftRot);
		frontRight.set(ControlMode.MotionMagic, rightRot);
	}
	public double getLeftSpeed(){
		return frontLeft.getSelectedSensorVelocity(0);
	}
	public double getRightSpeed(){
		return frontRight.getSelectedSensorVelocity(0);
	}
	public double getLeftPos(){
		return frontLeft.getSelectedSensorPosition(0);
	}
	public double getRightPos(){
		return frontRight.getSelectedSensorPosition(0);
	}
	public void resetEncoders(){
		frontLeft.setSelectedSensorPosition(0, 0, 0);
		frontRight.setSelectedSensorPosition(0, 0, 0);
	}
}
