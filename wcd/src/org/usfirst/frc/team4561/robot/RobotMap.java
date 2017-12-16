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
	
	// Joystick configuration
	public static final double RIGHT_JOYSTICK_DEAD_ZONE = 0.25;
	public static final double LEFT_JOYSTICK_DEAD_ZONE = 0.25;
	public static final double RIGHT_JOYSTICK_REDUCTION = 0.25;
	public static final double LEFT_JOYSTICK_REDUCTION = 0.25;
	
	public static final int FRONT_RIGHT_MOTOR_PORT = 0;
	public static final int MID_RIGHT_MOTOR_PORT = 0;
	public static final int BOT_RIGHT_MOTOR_PORT = 0;
	
	public static final int FRONT_LEFT_MOTOR_PORT = 0;
	public static final int MID_LEFT_MOTOR_PORT = 0;
	public static final int BOT_LEFT_MOTOR_PORT = 0;
	
	public static final int DRIVE_MODE = 0; // 1 is arcade drive, 0 is tank drive
	public static final int PCM_PORT = 0;
	public static final int TRANSMISSION_SOLENOID_PORT = 0;
	public static final int TRANSMISSION_SOLENOID_TWO_PORT = 0;
	public static final int TRANSMISSION_SPEED_BUTTON = 0;
	public static final int TRANSMISSION_TORQUE_BUTTON = 0;
	
	// If you are using multiple modules, make sure to define both the port
	// number and the module. For example you with a rangefinder:
	// public static int rangefinderPort = 1;
	// public static int rangefinderModule = 1;
}
