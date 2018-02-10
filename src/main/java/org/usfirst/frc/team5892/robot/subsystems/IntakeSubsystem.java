package org.usfirst.frc.team5892.robot.subsystems;

import edu.wpi.first.wpilibj.*;
import edu.wpi.first.wpilibj.buttons.Trigger;
import edu.wpi.first.wpilibj.command.Subsystem;
import org.usfirst.frc.team5892.HEROcode.inline.InlineTrigger;
import org.usfirst.frc.team5892.HEROcode.sensormap.Sensor;
import org.usfirst.frc.team5892.robot.Robot;
import org.usfirst.frc.team5892.robot.commands.auton.intake.IntakeBumperStop;
import org.usfirst.frc.team5892.robot.commands.auton.intake.IntakeStateSet;

public class IntakeSubsystem extends Subsystem {
    public static final double MOTOR_POWER = 0.5;
    public static final double ULTRASONIC_THRESHOLD = 0.6;
    public static final double ULTRASONIC_TOLERANCE = 0.03;

    private final Victor leftMotor, rightMotor;
    private final Solenoid leftPiston, rightPiston;
    private final DigitalInput leftBumper, rightBumper;
    private final AnalogInput ultrasonicSensor;
    private boolean cubeInside;
    private State state;

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
    protected void initDefaultCommand() {
        new InlineTrigger(() -> Robot.m_oi.player2.tempBtn1().get() && state == State.INTAKING).whenActive(new IntakeBumperStop(leftMotor));
        new InlineTrigger(() -> Robot.m_oi.player2.tempBtn2().get() && state == State.INTAKING).whenActive(new IntakeBumperStop(rightMotor));

        Trigger ultrasonicTrigger = new InlineTrigger(() -> cubeInside);
        ultrasonicTrigger.whenActive(new IntakeStateSet(State.INTAKING));
        ultrasonicTrigger.whenInactive(new IntakeStateSet(State.IDLE));
    }

    public State getState() {
        return state;
    }

    public void setState(State newState) {
        System.out.println(newState);
        state = newState;
        switch (newState) {
            case IDLE:
                leftMotor.set(0);
                rightMotor.set(0);
                leftPiston.set(false);
                rightPiston.set(false);
                break;
            case RUNNING:
                leftMotor.set(MOTOR_POWER);
                rightMotor.set(MOTOR_POWER);
                leftPiston.set(false);
                rightPiston.set(false);
                break;
            case INTAKING:
                leftMotor.set(MOTOR_POWER);
                rightMotor.set(MOTOR_POWER);
                leftPiston.set(true);
                rightPiston.set(true);
                break;
            case EXTRUDING:
                leftMotor.set(-MOTOR_POWER);
                rightMotor.set(-MOTOR_POWER);
                leftPiston.set(true);
                rightPiston.set(true);
                break;
        }
    }

    @Override
    public void periodic() {
        if (cubeInside)
            if (ultrasonicSensor.getVoltage() > ULTRASONIC_THRESHOLD + ULTRASONIC_TOLERANCE)
                cubeInside = false;
        else
            if (ultrasonicSensor.getVoltage() < ULTRASONIC_THRESHOLD - ULTRASONIC_TOLERANCE)
                cubeInside = true;
    }

    public enum State {
        IDLE,
        RUNNING,
        INTAKING,
        EXTRUDING
    }
}
