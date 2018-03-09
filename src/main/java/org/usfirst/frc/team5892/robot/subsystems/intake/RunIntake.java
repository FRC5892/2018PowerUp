package org.usfirst.frc.team5892.robot.subsystems.intake;

import edu.wpi.first.wpilibj.command.Command;
import org.usfirst.frc.team5892.robot.Robot;

public class RunIntake extends Command {

    private final double _power;

    public RunIntake(double power) {
        requires(Robot.intake);
        _power = power;
    }

    @Override
    protected void execute() {
        Robot.intake.setMotorPower(_power);
    }

    @Override
    protected boolean isFinished() {
        return false;
    }

    @Override
    protected void end() {
        Robot.intake.setMotorPower(0);
    }
}
