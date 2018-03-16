package org.usfirst.frc.team5892.robot.auton;

import edu.wpi.first.wpilibj.command.Command;
import org.usfirst.frc.team5892.robot.Robot;



public class AutoTankDrive extends Command {

    private final double left;
    private final double right;
    private final int encoderTarget;

    public AutoTankDrive(double _left, double _right, int _encoderTarget) {
        requires(Robot.drive);
        left = _left;
        right = _right;
        encoderTarget = _encoderTarget;
    }

    public AutoTankDrive(double _left, double _right, int _encoderTarget, double timeout) {
        this(_left, _right, _encoderTarget);
        setTimeout(timeout);
    }

    @Override
    protected void initialize() {
        Robot.drive.resetEncoders();
        Robot.drive.tankDrive(left, right);
    }

    @Override
    protected boolean isFinished() {
        return Math.abs(Robot.drive.getLeft()) > encoderTarget ||
                Math.abs(Robot.drive.getRight()) > encoderTarget || isTimedOut();
    }

    @Override
    protected final void end() {
        Robot.drive.stop();
    }
}