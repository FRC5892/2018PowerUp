package org.usfirst.frc.team5892.robot;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

public class OfficialBotMap extends RobotMap {
    public OfficialBotMap() {
        leftDrive = new MotorInfo[]{new MotorInfo(0, false), new MotorInfo(1, false)};
        rightDrive = new MotorInfo[]{new MotorInfo(2, false), new MotorInfo(3, false)};

        elevatorMotor = new MotorInfo(4, false);
        elevatorSwitches = new int[]{};
    }
}
