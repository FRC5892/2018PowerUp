package org.usfirst.frc.team5892.robot.subsystems.drive;

import edu.wpi.first.wpilibj.buttons.Trigger;
import edu.wpi.first.wpilibj.command.Command;
import org.usfirst.frc.team5892.robot.Robot;

class JoystickDriveCommand extends Command {
    private static final double SLOW_MULTIPLIER = 0.5;
    private static final double MAX_ACCELERATION = 12;
    private final Trigger slowMode;

    JoystickDriveCommand() {
        requires(Robot.drive);
        slowMode = Robot.m_oi.player1.slowMode();
    }

    @Override
    protected void execute() {
        double mult = slowMode.get() ? SLOW_MULTIPLIER : DriveSubsystem.FLAT_REDUCE;
        if (Math.abs(Robot.drive.accelerometer()) > MAX_ACCELERATION) mult *= 0.3;
        Robot.drive.arcadeDrive(Robot.m_oi.player1.moveAxis() * mult, Robot.m_oi.player1.turnAxis() * mult);
    }

    @Override
    protected boolean isFinished() {
        return false;
    }
}
