package org.usfirst.frc.team5892.robot.commands.elevator;

import edu.wpi.first.wpilibj.command.InstantCommand;
import org.usfirst.frc.team5892.robot.Robot;

public class SwitchPressHandler extends InstantCommand {
    private final int asncapoinvapevin; // im tired can you tell

    public SwitchPressHandler(int index) {
        requires(Robot.elevator);
        asncapoinvapevin = index;
    }

    @Override
    protected void execute() {
        Robot.elevator.lastPressed = asncapoinvapevin;
    }

}
