package org.usfirst.frc.team5892.robot.subsystems.intake;

import edu.wpi.first.wpilibj.*;
import edu.wpi.first.wpilibj.command.Subsystem;
import org.usfirst.frc.team5892.robot.Robot;

public class IntakeSubsystem extends Subsystem {
    public static final double RUNNING_POWER = 0.7;
    public static final double SLOW_POWER = 0.2;

    private final SpeedController wheels;

    public IntakeSubsystem() {
        wheels = Robot.map.intakeMotor.makeVictor();

        addChild(wheels);
    }

    @Override
    protected void initDefaultCommand() {
        setDefaultCommand(new IntakeControl());
    }

    public void setMotorPower(double power) {
        wheels.set(power);
    }
}
