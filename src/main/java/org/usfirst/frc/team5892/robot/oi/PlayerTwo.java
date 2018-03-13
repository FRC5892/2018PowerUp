package org.usfirst.frc.team5892.robot.oi;

import edu.wpi.first.wpilibj.buttons.Trigger;

public interface PlayerTwo {
    Trigger intake();
    Trigger outtake();

    double elevator();

    Trigger leftBatwingDown();
    Trigger leftBatwingLift();
    Trigger rightBatwingDown();
    Trigger rightBatwingLift();
}
