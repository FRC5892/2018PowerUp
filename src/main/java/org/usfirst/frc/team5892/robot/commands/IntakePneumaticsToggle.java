package org.usfirst.frc.team5892.robot.commands;

import edu.wpi.first.wpilibj.command.InstantCommand;
import org.usfirst.frc.team5892.robot.Robot;

public class IntakePneumaticsToggle extends InstantCommand {
    private final int index;

    public IntakePneumaticsToggle(int _index) {
        requires(Robot.intake);
        index = _index;
    }

    @Override
    protected void execute() {
        Robot.intake.toggle(index);
    }
}
