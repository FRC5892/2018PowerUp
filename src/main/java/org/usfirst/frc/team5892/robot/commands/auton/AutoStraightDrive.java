package org.usfirst.frc.team5892.robot.commands.auton;

import edu.wpi.first.wpilibj.command.Command;
import org.usfirst.frc.team5892.HEROcode.pid.HEROicPIDController;
import org.usfirst.frc.team5892.robot.Robot;

public class AutoStraightDrive extends Command {
    private AutoStraightDriveController controller;
    private final double nominalPower;
    //private static Preferences prefs = Preferences.getInstance();

    public AutoStraightDrive(double _nominalPower, double timeout) {
        requires(Robot.drive);
        controller = new AutoStraightDriveController();
        nominalPower = _nominalPower;
        // TODO encoders
        setTimeout(timeout);
    }

    @Override
    protected void initialize() {
        Robot.drive.resetGyro();
        //controller.setPID(prefs.getDouble("kP", 0), prefs.getDouble("kI", 0), prefs.getDouble("kD", 0));
        controller.enable();
    }

    @Override
    protected boolean isFinished() {
        return isTimedOut();
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
            Robot.drive.arcadeDrive(nominalPower, output);
        }
    }
}
