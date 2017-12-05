package org.usfirst.frc.team4561.robot;

/**
 * The RobotMap is a mapping from the ports sensors and actuators are wired into
 * to a variable name. This provides flexibility changing wiring, makes checking
 * the wiring easier and significantly reduces the number of magic numbers
 * floating around.
 */
public class RobotMap {
	public static final int RIGHT_JOYSTICK_PORT = 0;
	public static final int LEFT_JOYSTICK_PORT = 0;
	
	public static final int topRightMotor = 0;
	public static final int midRightMotor = 0;
	public static final int botRightMotor = 0;
	
	public static final int topLeftMotor = 0;
	public static final int midLeftMotor = 0;
	public static final int botLeftMotor = 0;
	
	public static final int DriveMode = 0; //1 is arcade drive, 0 is tank drive
	
	// If you are using multiple modules, make sure to define both the port
	// number and the module. For example you with a rangefinder:
	// public static int rangefinderPort = 1;
	// public static int rangefinderModule = 1;
}
