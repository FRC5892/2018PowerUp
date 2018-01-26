package org.usfirst.frc.team5892.robot;

public class BallbasaurDriveMap extends RobotMap {
    public BallbasaurDriveMap() {
        leftDrive = new MotorInfo[]{new MotorInfo(7, true), new MotorInfo(3, true)};
        rightDrive = new MotorInfo[]{new MotorInfo(8, false), new MotorInfo(2, false)};
    }
}
