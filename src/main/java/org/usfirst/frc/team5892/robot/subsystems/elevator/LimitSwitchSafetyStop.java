package org.usfirst.frc.team5892.robot.subsystems.elevator;

import edu.wpi.first.wpilibj.command.Command;
import org.usfirst.frc.team5892.robot.Robot;

class LimitSwitchSafetyStop extends Command {

    LimitSwitchSafetyStop(double timeout) {
        requires(Robot.elevator);
        setTimeout(timeout);
        setInterruptible(false);
    }

    @Override
    protected boolean isFinished() {
        return isTimedOut();
    }
}
