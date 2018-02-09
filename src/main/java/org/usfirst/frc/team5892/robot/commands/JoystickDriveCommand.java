package org.usfirst.frc.team5892.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import org.usfirst.frc.team5892.robot.Robot;

public class JoystickDriveCommand extends Command {

    public JoystickDriveCommand() {
        requires(Robot.drive);
    }

    @Override
    protected void execute() {
        Robot.drive.arcadeDrive(Robot.m_oi.player1.moveAxis(), Robot.m_oi.player1.turnAxis());
    }

    @Override
    protected boolean isFinished() {
        return false;
    }
}
