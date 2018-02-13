package org.usfirst.frc.team5892.robot.subsystems.batwing;

import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj.command.InstantCommand;
import org.usfirst.frc.team5892.robot.Robot;

public class BatwingActivate extends InstantCommand {
    private final BatwingSubsystem.Batwing _batwing;
    private final boolean _timeSafety;

    public BatwingActivate(BatwingSubsystem.Batwing batwing, boolean timeSafety) {
        requires(Robot.batwings);
        _batwing = batwing;
        _timeSafety = timeSafety;
    }

    @Override
    protected void execute() {
        if (_timeSafety && DriverStation.getInstance().getMatchTime() > 30) return;
        _batwing.advance();
    }
}
