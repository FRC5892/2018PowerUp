package org.usfirst.frc.team5892.robot;

public class TempBotMap extends RobotMap{
    public TempBotMap() {
        leftDrive = new MotorInfo[]{new MotorInfo(0, false)};
        rightDrive = new MotorInfo[]{new MotorInfo(1, false)};
        leftEncoder1 = 0; leftEncoder2 = 1;
        rightEncoder1 = 2; rightEncoder2 = 3;

        intakeMotors = new MotorInfo[]{new MotorInfo(5, true), new MotorInfo(6)};
        intakeButton = 4;

        elevatorTalon = new MotorInfo(0);
        elevatorOtherMotor = new MotorInfo(4);
        elevatorLimitSwitch = 5;

        leftBatwingRetainer = new MotorInfo(7); //leftBatwingRetainerSensor = 5;
        leftBatwingWinch = new MotorInfo(2); //leftBatwingWinchSensor = 6;
        rightBatwingRetainer = new MotorInfo(8); //rightBatwingRetainerSensor = 7;
        rightBatwingWinch = new MotorInfo(3); //rightBatwingWinchSensor = 8;
    }
}
