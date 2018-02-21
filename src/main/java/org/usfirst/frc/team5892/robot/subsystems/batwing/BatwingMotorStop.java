package org.usfirst.frc.team5892.robot.subsystems.batwing;

import edu.wpi.first.wpilibj.SpeedController;
import edu.wpi.first.wpilibj.command.InstantCommand;
import org.usfirst.frc.team5892.robot.Robot;

class BatwingMotorStop extends InstantCommand {
    private final SpeedController[] _toStop;

    BatwingMotorStop(SpeedController... toStop) {
        requires(Robot.batwings);
        _toStop = toStop;
    }

    @Override
    protected void execute() {
        for (SpeedController m : _toStop) {
            m.stopMotor();
        }
    }
}
