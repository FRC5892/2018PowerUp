package org.usfirst.frc.team5892.robot;

public class OfficialBotMap extends RobotMap {
    public OfficialBotMap() {
        leftDrive = new MotorInfo[]{new MotorInfo(0, false), new MotorInfo(1, false)};
        rightDrive = new MotorInfo[]{new MotorInfo(2, false), new MotorInfo(3, false)};
        leftEncoder1 = 10; leftEncoder2 = 11;
        rightEncoder1 = 12; rightEncoder2 = 13;

        leftIntakeMotor = new MotorInfo(9, true);
        rightIntakeMotor = new MotorInfo(8, false);
        intakeBumperSwitch = 14;

        elevatorMotor = new MotorInfo(0, false);
        elevatorSwitches = new int[]{0, 1};

        leftBatwingRetainer = new MotorInfo(4, false); leftBatwingRetainerSensor = 2;
        leftBatwingWinch = new MotorInfo(5, false); leftBatwingWinchSensor = 3;
        rightBatwingRetainer = new MotorInfo(6, false); rightBatwingRetainerSensor = 4;
        rightBatwingWinch = new MotorInfo(7, false); rightBatwingWinchSensor = 5;
    }
}
