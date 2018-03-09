package org.usfirst.frc.team5892.robot.subsystems.elevator;

import edu.wpi.first.wpilibj.command.Command;
import org.usfirst.frc.team5892.robot.Robot;

public class RunElevator extends Command {

    private final double _power;

    public RunElevator(double power) {
        requires(Robot.elevator);
        _power = power;
    }

    @Override
    protected void execute() {
        Robot.elevator.setMotorPower(_power);
    }

    @Override
    protected boolean isFinished() {
        return false;
    }

    @Override
    protected void end() {
        Robot.elevator.setMotorPower(0);
    }
}
