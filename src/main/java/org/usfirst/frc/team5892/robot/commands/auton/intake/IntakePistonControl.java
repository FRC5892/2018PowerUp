package org.usfirst.frc.team5892.robot.commands.auton.intake;

import edu.wpi.first.wpilibj.command.InstantCommand;
import org.usfirst.frc.team5892.robot.Robot;

public class IntakePistonControl extends InstantCommand {
    private final boolean setTo;

    public IntakePistonControl(boolean on) {
        requires(Robot.intake);
        setTo = on;
    }

    @Override
    protected void execute() {
        Robot.intake.setPistons(setTo);
    }
}
