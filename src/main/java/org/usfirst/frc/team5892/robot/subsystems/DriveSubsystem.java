package org.usfirst.frc.team5892.robot.subsystems;

import edu.wpi.first.wpilibj.Victor;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import org.usfirst.frc.team5892.robot.Robot;
import org.usfirst.frc.team5892.robot.commands.JoystickDriveCommand;

public class DriveSubsystem extends Subsystem {
    private final Victor leftMotor;
    private final Victor rightMotor;
    private final DifferentialDrive drive;

    public DriveSubsystem() {
        leftMotor = Robot.map.leftDriveMotor.makeVictor();
        rightMotor = Robot.map.rightDriveMotor.makeVictor();
        drive = new DifferentialDrive(leftMotor, rightMotor);
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
}
