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
    private final DoubleSolenoid leftPiston, rightPiston;
    private final DigitalInput bumperSwitch;
    State state = State.IDLE;

    public boolean override = false;
    private static Trigger manualLeft;
    private static Trigger manualRight;

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
        new InlineTrigger(() -> !override && state == State.RUNNING && bumperSwitch.get())
                .whenActive(new IntakeWindDown());
    }

    public void setMotorPower(double power) {
        armMotors.set(power);
    }

    public void setPistons(boolean grab) {
        DoubleSolenoid.Value val = convertValue(grab);
        leftPiston.set(val);
        rightPiston.set(val);
    }

    private DoubleSolenoid.Value convertValue(boolean on) {
        return on ? DoubleSolenoid.Value.kForward : DoubleSolenoid.Value.kReverse;
    }

    @Override
    public void periodic() {
        SmartDashboard.putBoolean("Intake Override", override);
        if (override) {
            if (manualLeft == null && Robot.m_oi != null) {
                manualLeft = Robot.m_oi.player2.manualIntakeLeftP();
                manualRight = Robot.m_oi.player2.manualIntakeRightP();
            }
            armMotors.set(Robot.m_oi.player2.manualIntakeWheels());
            leftPiston.set(convertValue(manualLeft.get()));
            rightPiston.set(convertValue(manualRight.get()));
        }
    }

    enum State {
        IDLE,
        RUNNING,
        HOLDING,
        EXTRUDING
    }
}
