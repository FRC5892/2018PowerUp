package org.usfirst.frc.team5892.robot.oi;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.JoystickButton;
import edu.wpi.first.wpilibj.buttons.Trigger;

public class JoystickPlayerTwo implements PlayerTwo {
    private final Joystick stick;
    public JoystickPlayerTwo(int port) {
        stick = new Joystick(port);
    }

    @Override
    public Trigger intakeToggle() {
        return new JoystickButton(stick, 3);
    }

    @Override
    public Trigger tempBtn1() {
        return new JoystickButton(stick, 1);
    }

    @Override
    public Trigger tempBtn2() {
        return new JoystickButton(stick, 2);
    }
}
