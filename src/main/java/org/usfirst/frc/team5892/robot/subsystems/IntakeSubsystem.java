package org.usfirst.frc.team5892.robot.subsystems;

import edu.wpi.first.wpilibj.*;
import edu.wpi.first.wpilibj.command.Subsystem;
import org.usfirst.frc.team5892.robot.Robot;

public class IntakeSubsystem extends Subsystem {
    public static final double MOTOR_POWER = 0.5;
    public static final double ULTRASONIC_THRESHOLD = 0.6;
    public static final double ULTRASONIC_TOLERANCE = 0.03;

    private final Victor leftMotor, rightMotor;
    private final Solenoid leftPiston, rightPiston;
    private final DigitalInput leftBumper, rightBumper;
    private final AnalogInput ultrasonicSensor;
    public boolean intaking;
    private boolean cubeInside;

    public IntakeSubsystem() {
        leftMotor = Robot.map.leftIntakeMotor.makeVictor();
        rightMotor = Robot.map.rightIntakeMotor.makeVictor();
        leftPiston = new Solenoid(Robot.map.leftIntakePiston);
        rightPiston = new Solenoid(Robot.map.rightIntakePiston);
        leftBumper = new DigitalInput(Robot.map.leftIntakeBumper);
        rightBumper = new DigitalInput(Robot.map.rightIntakeBumper);
        ultrasonicSensor = new AnalogInput(Robot.map.intakeUltrasonic);

        addChild(leftMotor); addChild(rightMotor);
        addChild(leftPiston); addChild(rightPiston);
        addChild(leftBumper); addChild(rightBumper);
        addChild(ultrasonicSensor);
    }

    @Override
    protected void initDefaultCommand() {}

    public void setLeft(double power) {
        leftMotor.set(power);
    }

    public void setRight(double power) {
        rightMotor.set(power);
    }

    public void setPistons(boolean on) {
        leftPiston.set(on);
        rightPiston.set(on);
    }

    public boolean leftBumper() {
        return leftBumper.get();
    }

    public boolean rightBumper() {
        return rightBumper.get();
    }

    public boolean cubeInside() {
        return cubeInside;
    }

    @Override
    public void periodic() {
        if (cubeInside)
            if (ultrasonicSensor.getVoltage() > ULTRASONIC_THRESHOLD - ULTRASONIC_TOLERANCE)
                cubeInside = false;
        else
            if (ultrasonicSensor.getVoltage() < ULTRASONIC_THRESHOLD + ULTRASONIC_TOLERANCE)
                cubeInside = true;
    }
}
