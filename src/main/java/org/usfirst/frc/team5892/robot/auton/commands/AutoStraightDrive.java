package org.usfirst.frc.team5892.robot.auton.commands;

import edu.wpi.first.wpilibj.command.Command;
import org.usfirst.frc.team5892.HEROcode.pid.HEROicPIDController;
import org.usfirst.frc.team5892.robot.Robot;

public class AutoStraightDrive extends Command {
    private AutoStraightDriveController controller;
    private final double _nominalPower;
    private final double _targetAngle;
    private final int _encoderTarget;

    public AutoStraightDrive(double nominalPower, double targetAngle, int encoderTarget) {
        requires(Robot.drive);
        _nominalPower = nominalPower;
        _targetAngle = targetAngle;
        _encoderTarget = encoderTarget;
        controller = new AutoStraightDriveController();
    }

    public AutoStraightDrive(double nominalPower, double targetAngle, int encoderTarget, double timeout) {
        this(nominalPower, targetAngle, encoderTarget);
        setTimeout(timeout);
    }

    @Override
    protected void initialize() {
        Robot.drive.resetEncoders();
        controller.enable();
    }

    @Override
    protected boolean isFinished() {
        return Math.abs(Robot.drive.getLeft()) > _encoderTarget ||
                Math.abs(Robot.drive.getRight()) > _encoderTarget || isTimedOut();
    }

    @Override
    protected void end() {
        controller.disable();
    }

    private class AutoStraightDriveController extends HEROicPIDController {

        private static final double kP = 0.05;
        private static final double kI = 0.1;
        private static final double kD = 0;
        AutoStraightDriveController() {
            super(kP, kI, kD);
            setSetpoint(_targetAngle);
        }

        @Override
        public double getPIDInput() {
            return Robot.drive.gyroAngle();
        }

        @Override
        public void usePIDOutput(double output) {
            Robot.drive.arcadeDrive(_nominalPower, output);
        }
    }
}
