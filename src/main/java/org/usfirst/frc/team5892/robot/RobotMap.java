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
	// Drive subsystem
	public MotorInfo[] leftDrive, rightDrive;
	public int leftEncoder1, leftEncoder2;
	public int rightEncoder1, rightEncoder2;

	// Intake subsystem
	public MotorInfo intakeMotorL;
	public MotorInfo intakeMotorR;

	// Elevator subsystem
	public MotorInfo elevatorTalon;
	public MotorInfo elevatorOtherMotor;

	// Batwing subsystem
	public MotorInfo leftBatwingRetainer, leftBatwingWinch;
	public MotorInfo rightBatwingRetainer, rightBatwingWinch;
	public int leftBatwingRetainerSensor, leftBatwingWinchSensor;
	public int rightBatwingRetainerSensor, rightBatwingWinchSensor;

	// ---

    /**
     * Maps the Spartan Board's encoder ports to digital ports. Add 1 for the other port.
     *
     * @param encoderPort The encoder port number on the Spartan Board.
     * @return The digital port number of the encoder
     */
	protected static int spartEnc(int encoderPort) {
	    return 10 + encoderPort * 2;
    }

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

		protected MotorInfo(int port) {
			this(port, false);
		}

		protected MotorInfo(int port, boolean inverted) {
			this.port = port;
			this.inverted = inverted;
		}

		public Victor makeVictor() {
			Victor ret = new Victor(port);
			ret.setInverted(inverted);
			return ret;
		}
	}
}
