package org.usfirst.frc.team4561.robot;

import edu.wpi.first.wpilibj.buttons.Button;
import edu.wpi.first.wpilibj.buttons.JoystickButton;

import org.usfirst.frc.team4561.robot.commands.SpeedGear;
import org.usfirst.frc.team4561.robot.commands.TorqueGear;

import edu.wpi.first.wpilibj.Joystick;

/**
 * This class is the glue that binds the controls on the physical operator
 * interface to the commands and command groups that allow control of the robot.
 */
public class OI {
	private static Joystick leftStick = new Joystick (RobotMap.LEFT_JOYSTICK_PORT);
	private static Joystick rightStick = new Joystick (RobotMap.RIGHT_JOYSTICK_PORT);
	private JoystickButton shiftSpeedButton = new JoystickButton(leftStick, RobotMap.TRANSMISSION_SPEED_BUTTON);
	private JoystickButton shiftTorqueButton = new JoystickButton(leftStick, RobotMap.TRANSMISSION_TORQUE_BUTTON);
	
	public OI() {
		shiftSpeedButton.whenPressed(new SpeedGear());
		shiftTorqueButton.whenPressed(new TorqueGear());
	}
	
	// Joystick inputs
	/**
	 * Get the value given by the right stick's Y-axis. Applies dead zone and reduction.
     * @return double Right joystick's Y-axis, -1...1
     * @see {@link #getRightStickX() getRightStickX}
     * @see {@link #getLeftStickY() getLeftStickY}
     * @see {@link #getLeftStickX() getLeftStickX}
     * @author Kaiz
	 */
	public double getRightStickY() {
		double rightStickY = rightStick.getY();
		
		// Dead zone management
		if (Math.abs(rightStick.getMagnitude()) < RobotMap.RIGHT_JOYSTICK_DEAD_ZONE) {
			rightStickY = 0;
		}
		
		// Reductions - joystick reduction reduces velocity from given joystick direction
		if (rightStickY > 0) {
			rightStickY = (rightStickY - RobotMap.RIGHT_JOYSTICK_REDUCTION) * (1/(1-RobotMap.LEFT_JOYSTICK_REDUCTION));
			if (rightStickY < 0) {
				rightStickY = 0;
			}
		} else if (rightStickY < 0) {
			rightStickY = (rightStickY + RobotMap.RIGHT_JOYSTICK_REDUCTION) * (1/(1-RobotMap.LEFT_JOYSTICK_REDUCTION));
			if (rightStickY > 0) 
			{
				rightStickY = 0;
			}
		}
		return rightStickY;
	}

	/**
	 * Get the value given by the right stick's X-axis. Applies dead zone and reduction.
     * @return double Right joystick's X-axis, -1...1
     * @see {@link #getRightStickY() getRightStickY}
     * @see {@link #getLeftStickY() getLeftStickY}
     * @see {@link #getLeftStickX() getLeftStickX}
     * @author Kaiz
	 */
	public double getRightStickX() {
		double rightStickX = rightStick.getX();
		
		// Dead zone management
		if (Math.abs(rightStick.getMagnitude()) < RobotMap.RIGHT_JOYSTICK_DEAD_ZONE) {
			rightStickX = 0;
		}
		
		// Reductions
		if (rightStickX > 0) {
			rightStickX = (rightStickX - RobotMap.RIGHT_JOYSTICK_REDUCTION) * (1/(1-RobotMap.LEFT_JOYSTICK_REDUCTION));
			if (rightStickX < 0) {
				rightStickX = 0;
			}
		} else if (rightStickX < 0) {
			rightStickX = (rightStickX + RobotMap.RIGHT_JOYSTICK_REDUCTION) * (1/(1-RobotMap.LEFT_JOYSTICK_REDUCTION));
			if (rightStickX > 0) {
				rightStickX = 0;
			}
		}
		return rightStickX;
	}
	
	/**
	 * Get the value given by the left stick's Y-axis. Applies dead zone and reduction.
     * @return double Left joystick's Y-axis , -1...1
     * @see {@link #getRightStickY() getRightStickY}
     * @see {@link #getRightStickX() getRightStickX}
     * @see {@link #getLeftStickX() getLeftStickX}
     * @author Kaiz
	 */
	public double getLeftStickY() {
		double leftStickY = leftStick.getY();
		
		// Dead zone management
		if (Math.abs(leftStick.getMagnitude()) < RobotMap.LEFT_JOYSTICK_DEAD_ZONE) {
			leftStickY = 0;
		}
		
		// Reductions
		if (leftStickY > 0) {
			leftStickY = (leftStickY - RobotMap.LEFT_JOYSTICK_REDUCTION) * (1/(1-RobotMap.LEFT_JOYSTICK_REDUCTION));
			if(leftStickY < 0) {
				leftStickY = 0;
			}
		} else if (leftStickY < 0) {
			leftStickY = (leftStickY + RobotMap.LEFT_JOYSTICK_REDUCTION) * (1/(1-RobotMap.LEFT_JOYSTICK_REDUCTION));
			if (leftStickY > 0) {
				leftStickY = 0;
			}
		}
		return leftStickY;
	}
	
	/**
	 * Get the value given by the left stick's X-axis. Applies dead zone and reduction.
     * @return double Left joystick's X-axis, -1...1
     * @see {@link #getRightStickY() getRightStickY}
     * @see {@link #getRightStickX() getRightStickX}
     * @see {@link #getLeftStickY() getLeftStickY}
     * @author Kaiz
	 */
	public double getLeftStickX() {
		double leftStickX = leftStick.getX();
		
		// Dead zone management
		if (Math.abs(leftStick.getMagnitude()) < RobotMap.LEFT_JOYSTICK_DEAD_ZONE) {
			leftStickX = 0;
		}
		
		// Reductions
		if (leftStickX > 0) {
			leftStickX = (leftStickX - RobotMap.LEFT_JOYSTICK_REDUCTION) * (1/(1-RobotMap.LEFT_JOYSTICK_REDUCTION));
			if(leftStickX < 0){
				leftStickX = 0;
			}
		} else if (leftStickX < 0) {
			leftStickX = (leftStickX + RobotMap.LEFT_JOYSTICK_REDUCTION) * (1/(1-RobotMap.LEFT_JOYSTICK_REDUCTION));
			if(leftStickX > 0) {
				leftStickX = 0;
			}
		}
		return leftStickX;
	}
	
	public boolean getLeftTrigger(){
		return leftStick.getRawButton(1);
	}
	
	public boolean getRightTrigger(){
		return rightStick.getRawButton(1);
	}
	//// CREATING BUTTONS
	// One type of button is a joystick button which is any button on a
	//// joystick.
	// You create one by telling it which joystick it's on and which button
	// number it is.
	// Joystick stick = new Joystick(port);
	// Button button = new JoystickButton(stick, buttonNumber);

	// There are a few additional built in buttons you can use. Additionally,
	// by subclassing Button you can create custom triggers and bind those to
	// commands the same as any other Button.

	//// TRIGGERING COMMANDS WITH BUTTONS
	// Once you have a button, it's trivial to bind it to a button in one of
	// three ways:

	// Start the command when the button is pressed and let it run the command
	// until it is finished as determined by it's isFinished method.
	// button.whenPressed(new ExampleCommand());

	// Run the command while the button is being held down and interrupt it once
	// the button is released.
	// button.whileHeld(new ExampleCommand());

	// Start the command when the button is released and let it run the command
	// until it is finished as determined by it's isFinished method.
	// button.whenReleased(new ExampleCommand());
}
