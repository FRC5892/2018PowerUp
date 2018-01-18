package org.usfirst.frc.team5892.robot.commands.auton;

import org.usfirst.frc.team5892.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;



public class AutoTankDrive extends Command {

    final double left;
    final double right;

    public AutoTankDrive(double _left, double _right, double duration) {
        requires(Robot.driveSubsystem);
        left = _left;
        right = _right;
        setTimeout(duration);
    }

    @Override
    protected void initialize() {
        Robot.driveSubsystem.tankDrive(left, right);
    }

    @Override
    protected boolean isFinished() {
        return isTimedOut();
    }

    @Override
    protected final void end() {
        Robot.driveSubsystem.reset();
    }
}