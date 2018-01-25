package org.usfirst.frc.team5892.robot;

public class BallbasaurDriveMap extends RobotMap {
    public BallbasaurDriveMap() {
        MotorInfo[] _leftDrive = {new MotorInfo(7, true), new MotorInfo(3, true)};
        leftDrive = _leftDrive;

        MotorInfo[] _rightDrive = {new MotorInfo(8, false), new MotorInfo(2, false)};
        rightDrive = _rightDrive;
    }
}
