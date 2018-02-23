package org.usfirst.frc.team5892.robot.subsystems.elevator;

import edu.wpi.first.wpilibj.command.Command;
import org.usfirst.frc.team5892.robot.Robot;

public class AutonElevatorRun extends Command {

    private final double _power;

    public AutonElevatorRun(double power, double timeout) {
        requires(Robot.elevator);
        _power = power;
        setTimeout(timeout);
    }

    @Override
    protected void execute() {
        Robot.elevator.setMotorPower(_power);
    }

    @Override
    protected boolean isFinished() {
        return isTimedOut();
    }

    @Override
    protected void end() {
        Robot.elevator.setMotorPower(0);
    }
}
