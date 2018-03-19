package org.usfirst.frc.team5892.robot.oi;

import edu.wpi.first.wpilibj.buttons.Trigger;

public interface PlayerTwo {
    double intake();

    double elevator();
    Trigger elevatorLimitBreak();

    Trigger leftBatwingDown();
    Trigger leftBatwingLift();
    Trigger rightBatwingDown();
    Trigger rightBatwingLift();
}
