package org.usfirst.frc.team4561.robot.subsystems;

import org.usfirst.frc.team4561.robot.RobotMap;

import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 * This subsystem contains the methods to switch the gear types.
 * @author Zane T, Ben G, Morgan B
 */
public class Transmission extends Subsystem {

    // Creates a new Solenoid using the info from RobotMap
	
	public String currentState = "Unknown";
	public String lastChange = "None";
	
	private DoubleSolenoid doubleSolenoidTrans;
	
	public Transmission() {
		doubleSolenoidTrans = new DoubleSolenoid(RobotMap.PCM_PORT, RobotMap.TRANSMISSION_SOLENOID_PORT, RobotMap.TRANSMISSION_SOLENOID_TWO_PORT);
	}
	
    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
    
    //TODO: These two methods are temporary and can be switched around.
  	public void torqueGear() {
		doubleSolenoidTrans.set(DoubleSolenoid.Value.kForward);
		lastChange = currentState = "Torque";
    }
    
  	public void speedGear() {
		doubleSolenoidTrans.set(DoubleSolenoid.Value.kReverse);
		lastChange = currentState = "Speed";
    }
  	
  	public void stop() {
  		doubleSolenoidTrans.set(DoubleSolenoid.Value.kOff);
  		currentState = "Off";
  	}
  	
}