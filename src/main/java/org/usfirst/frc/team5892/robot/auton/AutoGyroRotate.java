package org.usfirst.frc.team5892.robot.auton;

import edu.wpi.first.wpilibj.command.Command;
import org.usfirst.frc.team5892.HEROcode.pid.HEROicPIDController;
import org.usfirst.frc.team5892.robot.Robot;

public class AutoGyroRotate extends Command {
    private static final double TOLERANCE = 0.5;

    private final AutoGyroRotateController controller;
    private final double turnValue;
    private boolean hasBeenUntrue = false;
    public AutoGyroRotate(double _turnValue) {
        requires(Robot.drive);
        controller = new AutoGyroRotateController();
        controller.setSetpoint(_turnValue);
        turnValue = _turnValue;
    }

    @Override
    protected void initialize() {
        hasBeenUntrue = false;
        Robot.drive.resetGyro();
        controller.enable();
    }

    @Override
    protected boolean isFinished() {
        boolean ret = Robot.drive.gyroAngle() > turnValue - TOLERANCE &&
                Robot.drive.gyroAngle() < turnValue + TOLERANCE;
        if (!ret) hasBeenUntrue = true;
        return hasBeenUntrue && ret; // sometimes the gyro reset hasn't gone through by now.
    }

    @Override
    protected void end() {
        controller.disable();
        Robot.drive.stop();
    }

    private class AutoGyroRotateController extends HEROicPIDController {

        private static final double kP = 0.004;
        private static final double kI = 0.006;
        private static final double kD = 0.02;
        AutoGyroRotateController() {
            super(kP, kI, kD);
        }

        @Override
        public double getPIDInput() {
            return Robot.drive.gyroAngle();
        }

        @Override
        public void usePIDOutput(double output) {
            System.out.println("PID output is " + output);
            Robot.drive.arcadeDrive(0, output);
        }
    }
}
