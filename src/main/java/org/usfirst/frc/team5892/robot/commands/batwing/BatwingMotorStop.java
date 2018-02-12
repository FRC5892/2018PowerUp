package org.usfirst.frc.team5892.robot.commands.batwing;

import edu.wpi.first.wpilibj.SpeedController;
import edu.wpi.first.wpilibj.command.InstantCommand;
import org.usfirst.frc.team5892.robot.Robot;

public class BatwingMotorStop extends InstantCommand {
    private final SpeedController _toStop;

    public BatwingMotorStop(SpeedController toStop) {
        requires(Robot.batwings);
        _toStop = toStop;
    }

    @Override
    protected void execute() {
        _toStop.stopMotor();
    }
}
