package org.usfirst.frc.team5892.robot.subsystems.drive;

import edu.wpi.first.wpilibj.*;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj.interfaces.Accelerometer;
import edu.wpi.first.wpilibj.interfaces.Gyro;
import org.usfirst.frc.team5892.robot.Robot;
import org.usfirst.frc.team5892.robot.RobotMap;

public class DriveSubsystem extends Subsystem {
    private final SpeedControllerGroup leftDrive;
    private final SpeedControllerGroup rightDrive;
    private final DifferentialDrive drive;
    private final Encoder leftEncoder;
    private final Encoder rightEncoder;
    private final Gyro gyro;
    private final Accelerometer accele;

    public DriveSubsystem() {
        leftDrive = RobotMap.makeVictorGroup(Robot.map.leftDrive);
        rightDrive = RobotMap.makeVictorGroup(Robot.map.rightDrive);
        drive = new DifferentialDrive(leftDrive, rightDrive);
        leftEncoder = new Encoder(Robot.map.leftEncoder1, Robot.map.leftEncoder2);
        rightEncoder = new Encoder(Robot.map.rightEncoder1, Robot.map.rightEncoder2);
        gyro = new ADXRS450_Gyro();
        accele = new BuiltInAccelerometer();

        addChild(drive); addChild(gyro);
        addChild(leftEncoder); addChild(rightEncoder);
        addChild(accele);
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

    public int getLeft() {
        return leftEncoder.get();
    }

    public int getRight() {
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

    public double accelerometer() {
        return accele.getY();
    }
}
