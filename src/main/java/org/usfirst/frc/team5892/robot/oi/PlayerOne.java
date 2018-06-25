package org.usfirst.frc.team5892.robot.oi;

import edu.wpi.first.wpilibj.buttons.Trigger;

public interface PlayerOne {
    double moveAxis();
    double turnAxis();

    double intake();
    Trigger slowOuttake();
}
