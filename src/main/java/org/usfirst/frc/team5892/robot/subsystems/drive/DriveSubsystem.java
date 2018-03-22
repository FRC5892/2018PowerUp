package org.usfirst.frc.team5892.robot.subsystems.drive;

import com.kauailabs.navx.frc.AHRS;
import edu.wpi.first.wpilibj.*;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj.interfaces.Accelerometer;
import org.usfirst.frc.team5892.robot.Robot;
import org.usfirst.frc.team5892.robot.RobotMap;

public class DriveSubsystem extends Subsystem {
    private final SpeedControllerGroup leftDrive;
    private final SpeedControllerGroup rightDrive;
    private final DifferentialDrive drive;
    private final Encoder leftEncoder;
    private final Encoder rightEncoder;
    private final AHRS gyro;
    private final Accelerometer accele;

    public static final double FLAT_REDUCE = Robot.batwings ? 0.8 : 0.95;

    public DriveSubsystem() {
        leftDrive = RobotMap.makeVictorGroup(Robot.map.leftDrive);
        rightDrive = RobotMap.makeVictorGroup(Robot.map.rightDrive);
        drive = new DifferentialDrive(leftDrive, rightDrive);
        leftEncoder = new Encoder(Robot.map.leftEncoder1, Robot.map.leftEncoder2);
        rightEncoder = new Encoder(Robot.map.rightEncoder1, Robot.map.rightEncoder2);
        gyro = new AHRS(SPI.Port.kMXP);
        accele = new BuiltInAccelerometer();

        addChild("Drive Train", drive); addChild("Gyro", (Sendable) gyro);
        addChild("Left Encoder", leftEncoder); addChild("Right Encoder", rightEncoder);
        addChild("Accelerometer", (Sendable) accele);
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
