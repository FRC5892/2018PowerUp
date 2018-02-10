package org.usfirst.frc.team5892.robot.oi;

import edu.wpi.first.wpilibj.buttons.Trigger;

public interface PlayerTwo {
    Trigger intakeToggle();

    Trigger elevatorUp();
    Trigger elevatorDown();

    Trigger tempBtn1();
    Trigger tempBtn2();
}
