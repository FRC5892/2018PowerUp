package org.usfirst.frc.team5892.robot.commands.intake;

import edu.wpi.first.wpilibj.command.InstantCommand;
import org.usfirst.frc.team5892.robot.Robot;
import org.usfirst.frc.team5892.robot.subsystems.IntakeSubsystem;

public class IntakeToggle extends InstantCommand {
    private final IntakeExtrude extrudeCmd;

    public IntakeToggle() {
        requires(Robot.intake);
        extrudeCmd = new IntakeExtrude();
    }

    @Override
    protected void execute() {
        switch (Robot.intake.state) {
            case IDLE:
                Robot.intake.state = IntakeSubsystem.State.RUNNING;
                Robot.intake.setMotorPower(IntakeSubsystem.RUNNING_POWER);
                break;
            case RUNNING:
                Robot.intake.state = IntakeSubsystem.State.IDLE;
                Robot.intake.setMotorPower(0);
                break;
            case HOLDING:
                extrudeCmd.start();
                break;
        }
    }
}
