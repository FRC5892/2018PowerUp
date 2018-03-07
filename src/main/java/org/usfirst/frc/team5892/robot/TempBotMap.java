package org.usfirst.frc.team5892.robot;

public class TempBotMap extends RobotMap{
    public TempBotMap() {
        leftDrive = new MotorInfo[]{new MotorInfo(1)};
        rightDrive = new MotorInfo[]{new MotorInfo(2)};
        leftEncoder1 = 0; leftEncoder2 = 1;
        rightEncoder1 = 2; rightEncoder2 = 3;

        elevatorTalon = new MotorInfo(3);
        elevatorOtherMotor = new MotorInfo(4, true);
    }
}
