package org.usfirst.frc.team5892.robot.subsystems.elevator;

import edu.wpi.first.wpilibj.command.InstantCommand;
import org.usfirst.frc.team5892.robot.Robot;

class SwitchPressHandler extends InstantCommand {
    private final int switchIndex;

    SwitchPressHandler(int index) {
        requires(Robot.elevator);
        switchIndex = index;
    }

    @Override
    protected void execute() {
        Robot.elevator.setLastPressed(switchIndex);
    }

}
