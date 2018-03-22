package org.usfirst.frc.team5892.robot.subsystems.intake;

import edu.wpi.first.wpilibj.command.Command;
import org.usfirst.frc.team5892.robot.Robot;

public class OuttakeCommand extends Command {

    private final double power;

    public OuttakeCommand() {
        this(1);
    }

    public OuttakeCommand(double power) {
        requires(Robot.intake);
        this.power = Math.abs(power);
    }

    @Override
    protected void execute() {
        Robot.intake.setMotorPower(power);
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
