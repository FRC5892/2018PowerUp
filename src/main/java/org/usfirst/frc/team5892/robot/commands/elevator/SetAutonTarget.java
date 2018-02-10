package org.usfirst.frc.team5892.robot.commands.elevator;

import edu.wpi.first.wpilibj.command.InstantCommand;
import org.usfirst.frc.team5892.robot.Robot;

public class SetAutonTarget extends InstantCommand {
    private final int setTo;

    public SetAutonTarget(int newTarget){
        requires(Robot.elevator);
        setTo = newTarget;
    }

    @Override
    protected void execute() {
        Robot.elevator.target = setTo;
    }
}
