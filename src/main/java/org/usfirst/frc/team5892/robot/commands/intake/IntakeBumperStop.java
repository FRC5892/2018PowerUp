package org.usfirst.frc.team5892.robot.commands.intake;

import edu.wpi.first.wpilibj.SpeedController;
import edu.wpi.first.wpilibj.command.InstantCommand;
import org.usfirst.frc.team5892.robot.Robot;

public class IntakeBumperStop extends InstantCommand {
    private final SpeedController stop;

    public IntakeBumperStop(SpeedController charge) {
        requires(Robot.intake);
        stop = charge;
    }

    @Override
    protected void execute() {
        stop.stopMotor();
    }
}
