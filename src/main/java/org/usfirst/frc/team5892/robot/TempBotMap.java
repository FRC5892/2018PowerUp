package org.usfirst.frc.team5892.robot;

public class TempBotMap extends RobotMap{
    public TempBotMap() {
        leftDrive = new MotorInfo[] {new MotorInfo(0, false), new MotorInfo(1, false)};
        rightDrive = new MotorInfo[] {new MotorInfo(2, false), new MotorInfo(3, false)};
        rightEncoder1 = spartEnc(0);
        rightEncoder2 = spartEnc(0) + 1;
    }
}
