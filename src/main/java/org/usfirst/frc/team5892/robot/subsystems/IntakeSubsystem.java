package org.usfirst.frc.team5892.robot.subsystems;

import edu.wpi.first.wpilibj.*;
import edu.wpi.first.wpilibj.buttons.Trigger;
import edu.wpi.first.wpilibj.command.Subsystem;
import org.usfirst.frc.team5892.HEROcode.inline.InlineTrigger;
import org.usfirst.frc.team5892.robot.Robot;
import org.usfirst.frc.team5892.robot.commands.intake.IntakeWindDown;

public class IntakeSubsystem extends Subsystem {
    public static final double RUNNING_POWER = 0.5;
    public static final double SLOW_POWER = 0.2;

    private final SpeedControllerGroup armMotors;
    private final DoubleSolenoid leftPiston, rightPiston;
    private final DigitalInput bumperSwitch;
    public State state = State.IDLE;

    public IntakeSubsystem() {
        armMotors = new SpeedControllerGroup(Robot.map.leftIntakeMotor.makeVictor(),
                Robot.map.rightIntakeMotor.makeVictor());
        leftPiston = new DoubleSolenoid(Robot.map.leftIntakePiston1, Robot.map.leftIntakePiston2);
        rightPiston = new DoubleSolenoid(Robot.map.rightIntakePiston1, Robot.map.rightIntakePiston2);
        bumperSwitch = new DigitalInput(Robot.map.intakeBumperSwitch);

        addChild(armMotors);
        addChild(leftPiston); addChild(rightPiston);
        addChild(bumperSwitch);
    }

    @Override
    protected void initDefaultCommand() {
        new InlineTrigger(() -> state == State.RUNNING && bumperSwitch.get())
                .whenActive(new IntakeWindDown());
    }

    public void setMotorPower(double power) {
        armMotors.set(power);
    }

    public void setPistons(boolean grab) {
        leftPiston.set(grab ? DoubleSolenoid.Value.kForward : DoubleSolenoid.Value.kReverse);
        rightPiston.set(grab ? DoubleSolenoid.Value.kForward : DoubleSolenoid.Value.kReverse);
    }

    public enum State {
        IDLE,
        RUNNING,
        HOLDING,
        EXTRUDING
    }
}
