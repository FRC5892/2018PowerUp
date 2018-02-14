package org.usfirst.frc.team5892.robot.subsystems.intake;

import edu.wpi.first.wpilibj.command.InstantCommand;
import org.usfirst.frc.team5892.robot.Robot;

public class ToggleIntakeOverride extends InstantCommand {

    public ToggleIntakeOverride() {
        requires(Robot.intake);
    }

    @Override
    protected void execute() {
        Robot.intake.override = !Robot.intake.override;
    }
}
