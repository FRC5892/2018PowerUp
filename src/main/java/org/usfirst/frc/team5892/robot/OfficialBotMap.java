package org.usfirst.frc.team5892.robot;

public class OfficialBotMap extends RobotMap {
    public OfficialBotMap() {
        leftDrive = new MotorInfo[]{new MotorInfo(0, false), new MotorInfo(1, false)};
        rightDrive = new MotorInfo[]{new MotorInfo(3, false), new MotorInfo(4, false)};
    }
}