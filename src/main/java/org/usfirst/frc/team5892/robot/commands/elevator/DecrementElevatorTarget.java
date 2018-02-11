package org.usfirst.frc.team5892.robot.commands.elevator;

import edu.wpi.first.wpilibj.command.InstantCommand;
import org.usfirst.frc.team5892.robot.Robot;
//Class used to lower the position of the elevator by operator
public class DecrementElevatorTarget extends InstantCommand {
    public DecrementElevatorTarget(){
        requires(Robot.elevator);
    }
    //
    @Override
    protected void execute(){
        if (Robot.elevator.getTarget() > 0)
            Robot.elevator.setTarget(Robot.elevator.getTarget() - 1);
    }
}

