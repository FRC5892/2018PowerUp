package org.usfirst.frc.team5892.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import org.usfirst.frc.team5892.robot.Robot;

public class IntakeMotorControl extends Command {

    public IntakeMotorControl() {
        requires(Robot.intake);
    }

    @Override
    protected void execute() {
        Robot.intake.setMotors(Robot.m_oi.player2.intakeMotors() / 2);
    }

    @Override
    protected boolean isFinished() {
        return true;
    }
}
