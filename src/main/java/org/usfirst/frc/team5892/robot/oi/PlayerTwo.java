package org.usfirst.frc.team5892.robot.oi;

import edu.wpi.first.wpilibj.buttons.Trigger;

public interface PlayerTwo {
    double elevator();
    Trigger elevatorBrake();

    Trigger leftBatwingDown();
    Trigger leftBatwingLift();
    Trigger rightBatwingDown();
    Trigger rightBatwingLift();

    Trigger climbArm();
    Trigger climbArmReverse();
    Trigger climbWinch();
}
