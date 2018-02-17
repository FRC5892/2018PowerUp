package org.usfirst.frc.team5892.robot.subsystems.drive;

import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj.buttons.Trigger;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import org.usfirst.frc.team5892.robot.Robot;

class JoystickDriveCommand extends Command {
    private static final double SLOW_MULTIPLIER = 0.5;
    private final Trigger slowMode;
    
    private final double increment;
    private double currentMove;
    private double currentTurn;

    JoystickDriveCommand() {
        requires(Robot.drive);
        slowMode = Robot.m_oi.player1.slowMode();
        increment = TimedRobot.DEFAULT_PERIOD * 2;
    }

    @Override
    protected void initialize() {
        currentMove = 0;
        currentTurn = 0;
    }

    @Override
    protected void execute() {
        double mult = slowMode.get() ? SLOW_MULTIPLIER : 1;
        double moveTarget = Robot.m_oi.player1.moveAxis() * mult, turnTarget = Robot.m_oi.player1.turnAxis() * mult;

        if (moveTarget < currentMove) {
            System.out.print("moveTarget < ");
            currentMove += increment;
            if (moveTarget > currentMove) moveTarget = currentMove;
        } else if (moveTarget > currentMove) {
            currentMove -= increment;
            if (moveTarget < currentMove) moveTarget = currentMove;
        }

        if (turnTarget < currentTurn) {
            currentTurn += increment;
            if (turnTarget > currentTurn) turnTarget = currentTurn;
        } else if (turnTarget > currentTurn) {
            currentTurn -= increment;
            if (turnTarget < currentTurn) turnTarget = currentTurn;
        }

        SmartDashboard.putNumber("Drive Move Target", moveTarget);
        SmartDashboard.putNumber("Drive Turn Target", turnTarget);
        SmartDashboard.putNumber("Drive Current Move", moveTarget);
        SmartDashboard.putNumber("Drive Current Turn", turnTarget);
        Robot.drive.arcadeDrive(currentMove, currentTurn);
    }

    @Override
    protected boolean isFinished() {
        return false;
    }
}
