package org.usfirst.frc.team5892.robot.subsystems.elevator;

import edu.wpi.first.wpilibj.command.InstantCommand;
import org.usfirst.frc.team5892.robot.Robot;

public class ToggleElevatorOverride extends InstantCommand {

    public ToggleElevatorOverride() {
        requires(Robot.elevator);
    }

    @Override
    protected void execute() {
        Robot.elevator.override = !Robot.elevator.override;
    }
}
