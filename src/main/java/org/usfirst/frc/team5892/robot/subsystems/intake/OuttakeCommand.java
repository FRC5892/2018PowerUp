package org.usfirst.frc.team5892.robot.subsystems.intake;

import edu.wpi.first.wpilibj.command.Command;
import org.usfirst.frc.team5892.robot.Robot;

public class OuttakeCommand extends Command {

    public OuttakeCommand() {
        requires(Robot.intake);
    }

    @Override
    protected void initialize() {
        Robot.intake.intaking = false;
    }

    @Override
    protected void execute() {
        Robot.intake.setMotorPower(1);
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
