package org.usfirst.frc.team5892.robot.commands.elevator;

import edu.wpi.first.wpilibj.command.InstantCommand;
import org.usfirst.frc.team5892.robot.Robot;

public class SetElevatorTarget extends InstantCommand {
    private final int setTo;

    public SetElevatorTarget(int newTarget){
        requires(Robot.elevator);
        setTo = newTarget;
    }

    @Override
    protected void execute() {
        Robot.elevator.setTarget(setTo);
    }
}
