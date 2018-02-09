package org.usfirst.frc.team5892.robot.commands.auton.intake;

import edu.wpi.first.wpilibj.command.InstantCommand;
import org.usfirst.frc.team5892.robot.Robot;
import org.usfirst.frc.team5892.robot.subsystems.IntakeSubsystem;

public class IntakeToggle extends InstantCommand {

    public IntakeToggle() {
        requires(Robot.intake);
    }

    @Override
    protected void execute() {
        Robot.intake.intaking = !Robot.intake.intaking;
        if (Robot.intake.intaking) {
            Robot.intake.setLeft(IntakeSubsystem.MOTOR_POWER);
            Robot.intake.setRight(IntakeSubsystem.MOTOR_POWER);
        }
    }
}
