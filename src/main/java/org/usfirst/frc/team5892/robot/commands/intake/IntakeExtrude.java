package org.usfirst.frc.team5892.robot.commands.intake;

import edu.wpi.first.wpilibj.command.Command;
import org.usfirst.frc.team5892.robot.Robot;
import org.usfirst.frc.team5892.robot.subsystems.IntakeSubsystem;

public class IntakeExtrude extends Command {
    private static final double TIME = 0.5;

    public IntakeExtrude() {
        requires(Robot.intake);
        setTimeout(TIME);
    }

    @Override
    protected void initialize() {
        Robot.intake.setMotorPower(-IntakeSubsystem.RUNNING_POWER);
        Robot.intake.setPistons(false);
        Robot.intake.state = IntakeSubsystem.State.EXTRUDING;
    }

    @Override
    protected boolean isFinished() {
        return isTimedOut();
    }

    @Override
    protected void end() {
        Robot.intake.setMotorPower(0);
        Robot.intake.state = IntakeSubsystem.State.IDLE;
    }
}
