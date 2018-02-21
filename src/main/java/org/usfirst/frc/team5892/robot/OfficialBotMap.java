package org.usfirst.frc.team5892.robot;

public class OfficialBotMap extends RobotMap {
    public OfficialBotMap() {
        leftDrive = new MotorInfo[]{new MotorInfo(0, false), new MotorInfo(1, false)};
        rightDrive = new MotorInfo[]{new MotorInfo(2, false), new MotorInfo(3, false)};
        leftEncoder1 = 10; leftEncoder2 = 11;
        rightEncoder1 = 12; rightEncoder2 = 13;

        intakeMotor = new MotorInfo(7, false);

        elevatorTalon = new MotorInfo(0, false);
        elevatorOtherMotor = new MotorInfo(4, false);

        leftBatwingRetainer = new MotorInfo(5, true); leftBatwingRetainerSensor = 2;
        leftBatwingWinch = new MotorInfo(8, false); leftBatwingWinchSensor = 3;
        rightBatwingRetainer = new MotorInfo(6, false); rightBatwingRetainerSensor = 4;
        rightBatwingWinch = new MotorInfo(9, true); rightBatwingWinchSensor = 5;
    }
}
