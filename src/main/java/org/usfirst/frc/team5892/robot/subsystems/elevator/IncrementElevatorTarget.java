package org.usfirst.frc.team5892.robot.subsystems.elevator;

import edu.wpi.first.wpilibj.command.InstantCommand;
import org.usfirst.frc.team5892.robot.Robot;
//Class used to raise the position of the elevator by operator
public class IncrementElevatorTarget extends InstantCommand {

    public IncrementElevatorTarget() {
        requires(Robot.elevator);
    }

    @Override
    protected void execute() {
        if (Robot.elevator.getTarget() < ElevatorSubsystem.positions.length)
            Robot.elevator.setTarget(Robot.elevator.getTarget() + 1);
    }
}
