package org.usfirst.frc.team5892.robot.oi;

import edu.wpi.first.wpilibj.buttons.Trigger;

public interface PlayerTwo {
    double intake();

    double elevator();

    Trigger batwingLeft();
    Trigger batwingRight();
}
