package org.usfirst.frc.team5892.robot.oi;

import edu.wpi.first.wpilibj.buttons.Trigger;

public interface PlayerTwo {
    Trigger intakeOverride();
    Trigger manualIntakeLeftP();
    Trigger manualIntakeRightP();
    double manualIntakeWheels();

    Trigger elevatorUp();
    Trigger elevatorDown();
    Trigger elevatorOverride();
    double manualElevator();

    Trigger batwingLeft();
    Trigger batwingRight();
}
