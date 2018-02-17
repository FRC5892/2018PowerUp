package org.usfirst.frc.team5892.robot.subsystems.intake;

import edu.wpi.first.wpilibj.*;
import edu.wpi.first.wpilibj.buttons.Trigger;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import org.usfirst.frc.team5892.HEROcode.inline.InlineTrigger;
import org.usfirst.frc.team5892.robot.Robot;
import org.usfirst.frc.team5892.robot.subsystems.intake.IntakeWindDown;

public class IntakeSubsystem extends Subsystem {
    public static final double RUNNING_POWER = 0.5;
    public static final double SLOW_POWER = 0.2;

    private final SpeedControllerGroup armMotors;
    private final DigitalInput bumperSwitch;
    State state = State.IDLE;

    public boolean override = false;

    public IntakeSubsystem() {
        armMotors = new SpeedControllerGroup(Robot.map.leftIntakeMotor.makeVictor(),
                Robot.map.rightIntakeMotor.makeVictor());
        bumperSwitch = new DigitalInput(Robot.map.intakeBumperSwitch);

        addChild(armMotors);
        addChild(bumperSwitch);
    }

    @Override
    protected void initDefaultCommand() {
        new InlineTrigger(() -> !override && state == State.RUNNING && bumperSwitch.get())
                .whenActive(new IntakeWindDown());
    }

    public void setMotorPower(double power) {
        armMotors.set(power);
    }

    @Override
    public void periodic() {
        SmartDashboard.putBoolean("Intake Override", override);
        if (override) {
            armMotors.set(Robot.m_oi.player2.manualIntakeWheels());
        }
    }

    enum State {
        IDLE,
        RUNNING,
        HOLDING,
        EXTRUDING
    }
}
