package org.usfirst.frc.team5892.robot.subsystems.intake;

import edu.wpi.first.wpilibj.*;
import edu.wpi.first.wpilibj.command.Subsystem;
import org.usfirst.frc.team5892.robot.Robot;

public class IntakeSubsystem extends Subsystem {
    public static final double RUNNING_POWER = 0.7;
    public static final double SLOW_POWER = 0.2;

    private final SpeedControllerGroup armMotors;

    public IntakeSubsystem() {
        armMotors = new SpeedControllerGroup(Robot.map.leftIntakeMotor.makeVictor(),
                Robot.map.rightIntakeMotor.makeVictor());

        addChild(armMotors);
    }

    @Override
    protected void initDefaultCommand() {
        setDefaultCommand(new IntakeControl());
    }

    public void setMotorPower(double power) {
        armMotors.set(power);
    }
}
