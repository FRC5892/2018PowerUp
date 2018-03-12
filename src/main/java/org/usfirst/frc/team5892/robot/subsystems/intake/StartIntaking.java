package org.usfirst.frc.team5892.robot.subsystems.intake;

import edu.wpi.first.wpilibj.command.InstantCommand;
import org.usfirst.frc.team5892.robot.Robot;

public class StartIntaking extends InstantCommand {

    public StartIntaking() {
        requires(Robot.intake);
    }

    @Override
    protected void execute() {
        Robot.intake.intaking = true;
    }
}
