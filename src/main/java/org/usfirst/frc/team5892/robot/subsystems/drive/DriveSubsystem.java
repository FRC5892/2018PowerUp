package org.usfirst.frc.team5892.robot.subsystems.drive;

import edu.wpi.first.wpilibj.ADXRS450_Gyro;
import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.GyroBase;
import edu.wpi.first.wpilibj.SpeedControllerGroup;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import org.usfirst.frc.team5892.robot.Robot;
import org.usfirst.frc.team5892.robot.RobotMap;

public class DriveSubsystem extends Subsystem {
    private final SpeedControllerGroup leftDrive;
    private final SpeedControllerGroup rightDrive;
    private final DifferentialDrive drive;
    private final Encoder leftEncoder;
    private final Encoder rightEncoder;
    private final GyroBase gyro;

    public DriveSubsystem() {
        leftDrive = RobotMap.makeVictorGroup(Robot.map.leftDrive);
        rightDrive = RobotMap.makeVictorGroup(Robot.map.rightDrive);
        drive = new DifferentialDrive(leftDrive, rightDrive);
        leftEncoder = new Encoder(Robot.map.leftEncoder1, Robot.map.leftEncoder2);
        rightEncoder = new Encoder(Robot.map.rightEncoder1, Robot.map.rightEncoder2);
        gyro = new ADXRS450_Gyro();

        addChild(drive); addChild(gyro);
        addChild(leftEncoder); addChild(rightEncoder);
    }

    @Override
    protected void initDefaultCommand() {
        setDefaultCommand(new JoystickDriveCommand());
    }

    public void arcadeDrive(double move, double turn) {
        drive.arcadeDrive(move, turn);
    }

    public void tankDrive(double left, double right) {
        drive.tankDrive(left, right);
    }

    public void stop() {
        leftDrive.set(0);
        rightDrive.set(0);
    }

    public double getLeft() {
        return leftEncoder.get();
    }

    public double getRight() {
        return rightEncoder.get();
    }

    public void resetEncoders() {
        leftEncoder.reset();
        rightEncoder.reset();
    }

    public void resetGyro() {
        gyro.reset();
    }

    public double gyroAngle() {
        return gyro.getAngle();
    }
}
