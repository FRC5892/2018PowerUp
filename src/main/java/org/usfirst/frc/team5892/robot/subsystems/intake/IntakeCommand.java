package org.usfirst.frc.team5892.robot.subsystems.intake;

import edu.wpi.first.wpilibj.command.Command;
import org.usfirst.frc.team5892.robot.Robot;

public class IntakeCommand extends Command {

    private final double power;

    public IntakeCommand() {
        this(1);
    }

    public IntakeCommand(double power) {
        requires(Robot.intake);
        this.power = Math.abs(power);
    }

    @Override
    protected void execute() {
        if (!Robot.intake.isButtonPressed()) Robot.intake.setMotorPower(-power);
        else Robot.intake.setMotorPower(0);
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
