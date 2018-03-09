package org.usfirst.frc.team5892.robot.subsystems.intake;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;
import edu.wpi.first.wpilibj.*;
import edu.wpi.first.wpilibj.command.Subsystem;
import org.usfirst.frc.team5892.robot.MathUtils;
import org.usfirst.frc.team5892.robot.Robot;

public class IntakeSubsystem extends Subsystem {
    public static final double INTAKE_POWER = 1;
    public static final double OUTTAKE_POWER = 0.7;

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
        wheels.set(MathUtils.scalePlusMinus(power, INTAKE_POWER, OUTTAKE_POWER));
    }
}
