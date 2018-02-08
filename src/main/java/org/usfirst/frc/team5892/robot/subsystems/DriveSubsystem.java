package org.usfirst.frc.team5892.robot.subsystems;

import edu.wpi.first.wpilibj.SpeedControllerGroup;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import org.usfirst.frc.team5892.robot.Robot;
import org.usfirst.frc.team5892.robot.RobotMap;
import org.usfirst.frc.team5892.robot.commands.JoystickDriveCommand;

public class DriveSubsystem extends Subsystem {
    private final SpeedControllerGroup leftDrive;
    private final SpeedControllerGroup rightDrive;
    private final DifferentialDrive drive;

    public DriveSubsystem() {
        leftDrive = RobotMap.makeVictorGroup(Robot.map.leftDrive);
        rightDrive = RobotMap.makeVictorGroup(Robot.map.rightDrive);
        drive = new DifferentialDrive(leftDrive, rightDrive);
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
        leftDrive.set(0);
        rightDrive.set(0);
    }
}
