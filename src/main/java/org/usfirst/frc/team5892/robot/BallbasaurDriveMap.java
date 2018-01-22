package org.usfirst.frc.team5892.robot;

public class BallbasaurDriveMap extends RobotMap {
    public BallbasaurDriveMap() {
        leftDrive1 = new MotorInfo(7, true);
        leftDrive2 = new MotorInfo(3, true);
        leftDrive3 = new MotorInfo(1, false);

        rightDrive1 = new MotorInfo(8, false);
        rightDrive2 = new MotorInfo(2, false);
        rightDrive3 = new MotorInfo(4, true);
    }
}
