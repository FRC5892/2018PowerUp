package org.usfirst.frc.team5892.robot.commands.intake;

import edu.wpi.first.wpilibj.command.Command;
import org.usfirst.frc.team5892.robot.Robot;
import org.usfirst.frc.team5892.robot.subsystems.IntakeSubsystem;

public class IntakeWindDown extends Command {
    private static final double TIME = 2;

    public IntakeWindDown() {
        requires(Robot.intake);
        setTimeout(TIME);
    }

    @Override
    protected void initialize() {
        Robot.intake.setPistons(true);
        Robot.intake.state = IntakeSubsystem.State.HOLDING;
    }

    @Override
    protected void execute() {
        Robot.intake.setMotorPower(IntakeSubsystem.SLOW_POWER * (1 - timeSinceInitialized() / TIME));
    }

    @Override
    protected boolean isFinished() {
        return isTimedOut();
    }

    @Override
    protected void end() {
        Robot.intake.setMotorPower(0);
    }
}
