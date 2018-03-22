package org.usfirst.frc.team5892.robot.subsystems.intake;

import edu.wpi.first.wpilibj.command.Command;
import org.usfirst.frc.team5892.robot.Robot;

public class IntakeControl extends Command {

    public IntakeControl() {
        requires(Robot.intake);
    }

    @Override
    protected void execute() {
        Robot.intake.setMotorPower(Robot.m_oi.player1.intake());
    }

    @Override
    protected boolean isFinished() {
        return false;
    }
}
