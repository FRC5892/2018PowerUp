package org.usfirst.frc.team5892.robot.subsystems.elevator;

import edu.wpi.first.wpilibj.command.Command;
import org.usfirst.frc.team5892.robot.Robot;

@Deprecated
public class ElevatorBrake extends Command {

    public ElevatorBrake() {
        requires(Robot.elevator);
    }

    @Override
    protected void execute() {
        Robot.elevator.setBrake(true);
    }

    @Override
    protected boolean isFinished() {
        return false;
    }

    @Override
    protected void end() {
        Robot.elevator.setBrake(false);
    }
}
