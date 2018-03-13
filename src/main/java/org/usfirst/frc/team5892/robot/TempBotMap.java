package org.usfirst.frc.team5892.robot;

public class TempBotMap extends RobotMap{
    public TempBotMap() {
        leftDrive = new MotorInfo[]{new MotorInfo(0, false)};
        rightDrive = new MotorInfo[]{new MotorInfo(1, false)};
        leftEncoder1 = 0; leftEncoder2 = 1;
        rightEncoder1 = 2; rightEncoder2 = 3;

        intakeMotors = new MotorInfo[]{new MotorInfo(2, true), new MotorInfo(3)};
        intakeButton = 4;

        elevatorTalon = new MotorInfo(0);
        elevatorOtherMotor = new MotorInfo(4);
        elevatorLimitSwitch = 5;

        leftBatwingRetainer = new MotorInfo(5); //leftBatwingRetainerSensor = 5;
        leftBatwingWinch = new MotorInfo(6); //leftBatwingWinchSensor = 6;
        rightBatwingRetainer = new MotorInfo(7); //rightBatwingRetainerSensor = 7;
        rightBatwingWinch = new MotorInfo(8); //rightBatwingWinchSensor = 8;
    }
}
