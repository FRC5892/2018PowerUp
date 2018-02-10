package org.usfirst.frc.team5892.robot;

public class TempBotMap extends RobotMap{
    public TempBotMap() {
        leftDrive = new MotorInfo[] {new MotorInfo(4, false), new MotorInfo(5, false)};
        rightDrive = new MotorInfo[] {new MotorInfo(8, false), new MotorInfo(9, false)};
    }
}
