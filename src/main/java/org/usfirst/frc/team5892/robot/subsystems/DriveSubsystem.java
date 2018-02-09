package org.usfirst.frc.team5892.robot.subsystems;

import com.kauailabs.navx.frc.AHRS;
import edu.wpi.first.wpilibj.SPI;
import edu.wpi.first.wpilibj.SpeedControllerGroup;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import org.usfirst.frc.team5892.robot.Robot;
import org.usfirst.frc.team5892.robot.RobotMap;
import org.usfirst.frc.team5892.robot.commands.JoystickDriveCommand;

public class DriveSubsystem extends Subsystem {
    private final DifferentialDrive drive;
    private final AHRS navx;

    public DriveSubsystem() {
        SpeedControllerGroup leftDrive = RobotMap.makeVictorGroup(Robot.map.leftDrive);
        SpeedControllerGroup rightDrive = RobotMap.makeVictorGroup(Robot.map.rightDrive);
        drive = new DifferentialDrive(leftDrive, rightDrive);
        navx = new AHRS(SPI.Port.kMXP);
        addChild(drive);
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

    public void reset() {
        drive.stopMotor();
    }

    public void resetGyro() {
        navx.reset();
    }

    public double gyroAngle() {
        return navx.getYaw();
    }

    @Override
    public void periodic() {
        SmartDashboard.putNumber("Gyro Angle", gyroAngle());
    }
}
