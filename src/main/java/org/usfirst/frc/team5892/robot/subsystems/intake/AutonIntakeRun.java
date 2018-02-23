package org.usfirst.frc.team5892.robot.subsystems.intake;

import edu.wpi.first.wpilibj.command.Command;
import org.usfirst.frc.team5892.robot.Robot;

public class AutonIntakeRun extends Command {

    private final double _power;

    public AutonIntakeRun(double power, double timeout) {
        requires(Robot.intake);
        _power = power;
        setTimeout(timeout);
    }

    @Override
    protected void execute() {
        Robot.intake.setMotorPower(_power);
    }

    @Override
    protected boolean isFinished() {
        return isTimedOut();
    }

    @Override
    protected void end() {
        Robot.intake.setMotorPower(0);
    }
}
