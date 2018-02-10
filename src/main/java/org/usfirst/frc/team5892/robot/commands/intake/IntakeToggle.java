package org.usfirst.frc.team5892.robot.commands.intake;

import edu.wpi.first.wpilibj.command.InstantCommand;
import org.usfirst.frc.team5892.robot.Robot;
import org.usfirst.frc.team5892.robot.subsystems.IntakeSubsystem;

public class IntakeToggle extends InstantCommand {

    public IntakeToggle() {
        requires(Robot.intake);
    }

    @Override
    protected void execute() {
        switch (Robot.intake.getState()) {
            case IDLE:
                Robot.intake.setState(IntakeSubsystem.State.RUNNING);
                break;
            case RUNNING:
                Robot.intake.setState(IntakeSubsystem.State.IDLE);
                break;
            case INTAKING:
                Robot.intake.setState(IntakeSubsystem.State.EXTRUDING);
                break;
        }
    }
}
