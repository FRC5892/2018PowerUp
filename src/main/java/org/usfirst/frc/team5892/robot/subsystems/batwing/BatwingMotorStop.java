package org.usfirst.frc.team5892.robot.subsystems.batwing;

import edu.wpi.first.wpilibj.command.InstantCommand;
import org.usfirst.frc.team5892.robot.Robot;

class BatwingMotorStop extends InstantCommand {
    private final BatwingSubsystem.Batwing _toStop;

    BatwingMotorStop(BatwingSubsystem.Batwing toStop) {
        requires(Robot.batwings);
        _toStop = toStop;
    }

    @Override
    protected void execute() {
        _toStop.retainer.stopMotor();
        _toStop.winch.stopMotor();
    }
}
