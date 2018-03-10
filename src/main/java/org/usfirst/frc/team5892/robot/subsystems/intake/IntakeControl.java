package org.usfirst.frc.team5892.robot.subsystems.intake;

import edu.wpi.first.wpilibj.command.Command;
import org.usfirst.frc.team5892.robot.Robot;

public class IntakeControl extends Command {

    public IntakeControl() {
        requires(Robot.intake);
    }

    @Override
    protected void execute() {
        double power = Robot.m_oi.player2.intake();
        if (Math.abs(power) < 0.1) Robot.intake.setMotorPower(0.1);
        else Robot.intake.setMotorPower(Robot.m_oi.player2.intake());
    }

    @Override
    protected boolean isFinished() {
        return false;
    }
}
