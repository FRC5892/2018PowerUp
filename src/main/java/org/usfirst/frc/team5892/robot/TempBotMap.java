package org.usfirst.frc.team5892.robot;

public class TempBotMap extends RobotMap{
    public TempBotMap() {
        leftDrive = new MotorInfo[] {new MotorInfo(4, false), new MotorInfo(5, false)};
        rightDrive = new MotorInfo[] {new MotorInfo(8, false), new MotorInfo(9, false)};

        leftIntakeMotor = new MotorInfo(1, false);
        rightIntakeMotor = new MotorInfo(2, true);
        leftIntakePiston = 0;
        rightIntakePiston = 1;
        leftIntakeBumper = 0;
        rightIntakeBumper = 1;
        intakeUltrasonic = 0;
    }
}
