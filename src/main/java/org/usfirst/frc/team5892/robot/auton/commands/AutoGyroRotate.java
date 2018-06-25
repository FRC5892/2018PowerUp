package org.usfirst.frc.team5892.robot.auton.commands;

import edu.wpi.first.wpilibj.Preferences;
import edu.wpi.first.wpilibj.command.Command;
import org.usfirst.frc.team5892.HEROcode.pid.HEROicPIDController;
import org.usfirst.frc.team5892.robot.Robot;

public class AutoGyroRotate extends Command {
    private static final double TOLERANCE = 1;

    private static final Preferences prefs = Preferences.getInstance();

    private final AutoGyroRotateController controller;
    private final double _targetAngle;
    private final double _powerMult;
    private boolean hasBeenUntrue = false;

    public AutoGyroRotate(double targetAngle) {
        this(targetAngle, 1);
    }

    public AutoGyroRotate(double targetAngle, double powerMult) {
        requires(Robot.drive);
        controller = new AutoGyroRotateController();
        controller.setSetpoint(targetAngle);
        _targetAngle = targetAngle;
        _powerMult = powerMult;
    }

    @Override
    protected void initialize() {
        hasBeenUntrue = false;
        controller.setPID(prefs.getDouble("kP", 0), prefs.getDouble("kI", 0), prefs.getDouble("kD", 0));
        controller.enable();
    }

    @Override
    protected boolean isFinished() {
        boolean ret = Robot.drive.gyroAngle() > _targetAngle - TOLERANCE &&
                Robot.drive.gyroAngle() < _targetAngle + TOLERANCE;
        if (!ret) hasBeenUntrue = true;
        return hasBeenUntrue && ret; // sometimes the gyro reset hasn't gone through by now. (might as well leave this in.)
    }

    @Override
    protected void end() {
        controller.disable();
        Robot.drive.stop();
    }

    private class AutoGyroRotateController extends HEROicPIDController {

        private static final double kP = 0.005;
        private static final double kI = 0.0055;
        private static final double kD = 0.015;
        AutoGyroRotateController() {
            super(kP, kI, kD);
        }

        @Override
        public double getPIDInput() {
            return Robot.drive.gyroAngle();
        }

        @Override
        public void usePIDOutput(double output) {
            Robot.drive.arcadeDrive(0, output * _powerMult);
        }
    }
}
