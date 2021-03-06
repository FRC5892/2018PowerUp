package org.usfirst.frc.team5892.robot;

public class OfficialBotMap extends RobotMap {
    public OfficialBotMap() {
        leftDrive = new MotorInfo[]{new MotorInfo(0, false)};
        rightDrive = new MotorInfo[]{new MotorInfo(1, false)};
        leftEncoder1 = 0; leftEncoder2 = 1;
        rightEncoder1 = 2; rightEncoder2 = 3;

        intakeMotors = new MotorInfo[]{new MotorInfo(5, true), new MotorInfo(6)};

        elevatorTalon = new MotorInfo(0);
        elevatorOtherMotor = new MotorInfo(4, true);
        elevatorHighSwitch = 5;
        elevatorLowSwitch = 6;
        elevatorBrake1 = 2;
        elevatorBrake2 = 3;

        leftBatwingRetainer = new MotorInfo(7);
        leftBatwingWinch = new MotorInfo(2);
        leftBatwingSensor = 7;

        rightBatwingRetainer = new MotorInfo(8);
        rightBatwingWinch = new MotorInfo(3);
        rightBatwingSensor = 8;

        selfClimbArm = new MotorInfo(8);
        selfClimbWinch = new MotorInfo[]{new MotorInfo(2), new MotorInfo(9, true)};

        cameras = false;
    }
}
