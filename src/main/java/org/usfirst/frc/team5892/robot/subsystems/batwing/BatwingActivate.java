package org.usfirst.frc.team5892.robot.subsystems.batwing;

import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj.command.InstantCommand;
import org.usfirst.frc.team5892.robot.Robot;

public class BatwingActivate extends InstantCommand {
    private final BatwingSubsystem.Batwing _batwing;

    public BatwingActivate(BatwingSubsystem.Batwing batwing) {
        requires(Robot.batwings);
        _batwing = batwing;
    }

    @Override
    protected void execute() {
        if (DriverStation.getInstance().getMatchTime() > 30) return;
        _batwing.advance();
    }
}
