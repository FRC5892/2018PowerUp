package org.usfirst.frc.team5892.robot;

public class TempBotMap extends RobotMap{
    public TempBotMap() {
        leftDrive = new MotorInfo[]{new MotorInfo(0, false)};
        rightDrive = new MotorInfo[]{new MotorInfo(1, false)};
        leftEncoder1 = 0; leftEncoder2 = 1;
        rightEncoder1 = 2; rightEncoder2 = 3;

        intakeLeft = new MotorInfo(2);
        intakeRight = new MotorInfo(3);

        elevatorTalon = new MotorInfo(0);
        elevatorOtherMotor = new MotorInfo(4, true);

        leftBatwingRetainer = new MotorInfo(5); leftBatwingRetainerSensor = 4;
        leftBatwingWinch = new MotorInfo(6); leftBatwingWinchSensor = 5;
        rightBatwingRetainer = new MotorInfo(7); rightBatwingRetainerSensor = 6;
        rightBatwingWinch = new MotorInfo(8); rightBatwingWinchSensor = 7;
    }
}
