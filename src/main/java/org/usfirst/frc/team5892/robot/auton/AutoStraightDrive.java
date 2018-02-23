package org.usfirst.frc.team5892.robot.auton;

import edu.wpi.first.wpilibj.command.Command;
import org.usfirst.frc.team5892.HEROcode.pid.HEROicPIDController;
import org.usfirst.frc.team5892.robot.Robot;

public class AutoStraightDrive extends Command {
    private AutoStraightDriveController controller;
    private final double _nominalPower;
    private final int _encoderTarget;

    public AutoStraightDrive(double nominalPower, int encoderTarget) {
        requires(Robot.drive);
        controller = new AutoStraightDriveController();
        _nominalPower = nominalPower;
        _encoderTarget = encoderTarget;
    }

    @Override
    protected void initialize() {
        Robot.drive.resetGyro();
        Robot.drive.resetEncoders();
        controller.enable();
    }

    @Override
    protected boolean isFinished() {
        return Math.abs(Robot.drive.getLeft()) > _encoderTarget ||
                Math.abs(Robot.drive.getRight()) > _encoderTarget;
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
            setSetpoint(0);
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
