package org.usfirst.frc.team5892.robot.subsystems.intake;

import edu.wpi.first.wpilibj.command.Command;
import org.usfirst.frc.team5892.robot.Robot;

public class RunIntake extends Command {

    private final double _power;
    private final boolean _stopWithButton;

    public RunIntake(double power) {
        this(power, false);
    }

    public RunIntake(double power, boolean stopWithButton) {
        requires(Robot.intake);
        _power = power;
        _stopWithButton = stopWithButton;
    }

    @Override
    protected void execute() {
        Robot.intake.setMotorPower(_power);
    }

    @Override
    protected boolean isFinished() {
        return _stopWithButton && Robot.intake.isButtonPressed();
    }

    @Override
    protected void end() {
        Robot.intake.setMotorPower(0);
    }
}
