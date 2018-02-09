/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package org.usfirst.frc.team5892.robot;

import edu.wpi.first.wpilibj.SpeedControllerGroup;
import edu.wpi.first.wpilibj.Victor;

/**
 * The RobotMap is a mapping from the ports sensors and actuators are wired into
 * to a variable name. This provides flexibility changing wiring, makes checking
 * the wiring easier and significantly reduces the number of magic numbers
 * floating around.
 */
public class RobotMap {
	public MotorInfo[] leftDrive, rightDrive;

    public MotorInfo leftIntakeMotor, rightIntakeMotor;
    public int leftIntakePiston, rightIntakePiston;
    public int leftIntakeBumper, rightIntakeBumper;
    public int intakeUltrasonic;

    public static SpeedControllerGroup makeVictorGroup(MotorInfo... motors) {
    	Victor[] victors = new Victor[motors.length-1];
		for (int i = 1; i < motors.length; i++) {
			victors[i-1] = motors[i].makeVictor();
		}
		return new SpeedControllerGroup(motors[0].makeVictor(), victors);
	}

	public class MotorInfo {
	    public final int port;
	    public final boolean inverted;

	    protected MotorInfo(int _port, boolean _inverted) {
	        port = _port;
	        inverted = _inverted;
        }

	    public Victor makeVictor() {
	        Victor ret = new Victor(port);
	        ret.setInverted(inverted);
	        return ret;
        }
    }
}
