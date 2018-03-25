package org.usfirst.frc.team5892.robot.subsystems.intake;

import edu.wpi.first.wpilibj.Sendable;
import edu.wpi.first.wpilibj.SpeedController;
import edu.wpi.first.wpilibj.command.Subsystem;
import org.usfirst.frc.team5892.robot.MathUtils;
import org.usfirst.frc.team5892.robot.Robot;
import org.usfirst.frc.team5892.robot.RobotMap;

public class IntakeSubsystem extends Subsystem {
    public static final double INTAKE_POWER = 1;
    public static final double OUTTAKE_POWER = 1;

    private final SpeedController wheels;

    public IntakeSubsystem() {
        wheels = RobotMap.makeVictorGroup(Robot.map.intakeMotors);

        addChild("Wheels", (Sendable) wheels);
    }


    @Override
    protected void initDefaultCommand() {
        setDefaultCommand(new IntakeControl());
    }

    public void setMotorPower(double power) {
        wheels.set(-MathUtils.scalePlusMinus(power, INTAKE_POWER, OUTTAKE_POWER));
    }
}
