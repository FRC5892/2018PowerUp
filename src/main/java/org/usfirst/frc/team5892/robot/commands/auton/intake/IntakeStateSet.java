package org.usfirst.frc.team5892.robot.commands.auton.intake;

import edu.wpi.first.wpilibj.command.InstantCommand;
import org.usfirst.frc.team5892.robot.Robot;
import org.usfirst.frc.team5892.robot.subsystems.IntakeSubsystem;

public class IntakeStateSet extends InstantCommand {
    private final IntakeSubsystem.State state;

    public IntakeStateSet(IntakeSubsystem.State newState) {
        requires(Robot.intake);
        state = newState;
    }

    @Override
    protected void execute() {
        Robot.intake.setState(state);
    }
}
