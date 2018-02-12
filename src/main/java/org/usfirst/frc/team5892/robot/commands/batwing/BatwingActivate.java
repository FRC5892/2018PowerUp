package org.usfirst.frc.team5892.robot.commands.batwing;

import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj.command.InstantCommand;
import org.usfirst.frc.team5892.robot.Robot;

public class BatwingActivate extends InstantCommand {
    private final boolean _timeSafety;

    public BatwingActivate(boolean timeSafety) {
        requires(Robot.batwings);
        _timeSafety = timeSafety;
    }

    @Override
    protected void execute() {
        if (_timeSafety && DriverStation.getInstance().getMatchTime() > 30) return;
        if (Robot.batwings.isRunning()) return;
        switch (Robot.batwings.state) {
            case 0: // retracted -> ramp
                Robot.batwings.lowerRetainers();
                Robot.batwings.state++;
                break;
            case 1: // ramp -> platform
                Robot.batwings.raiseWinches();
                Robot.batwings.state++;
                break;
            default:
                DriverStation.reportWarning("BatwingActivate called when BatwingSubsystem at state " +
                        Robot.batwings.state + "!",  false);
        }
    }
}
