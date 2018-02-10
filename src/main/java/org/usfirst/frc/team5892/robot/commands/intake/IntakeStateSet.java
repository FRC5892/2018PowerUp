package org.usfirst.frc.team5892.robot.commands.intake;

import edu.wpi.first.wpilibj.command.InstantCommand;
import org.usfirst.frc.team5892.robot.Robot;
import org.usfirst.frc.team5892.robot.subsystems.IntakeSubsystem;

public class IntakeStateSet extends InstantCommand {
    private final IntakeSubsystem.State state;
    private final IntakeSubsystem.State required;

    public IntakeStateSet(IntakeSubsystem.State newState) {
        this(newState, null);
    }

    public IntakeStateSet(IntakeSubsystem.State newState, IntakeSubsystem.State _required) {
        requires(Robot.intake);
        state = newState;
        required = _required;
    }

    @Override
    protected void execute() {
        if (required != null && Robot.intake.getState() != required) return;
        Robot.intake.setState(state);
    }
}
