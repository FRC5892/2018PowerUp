package org.usfirst.frc.team5892.robot.oi;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.JoystickButton;
import edu.wpi.first.wpilibj.buttons.Trigger;
import org.usfirst.frc.team5892.HEROcode.inputs.AnalogAxisTrigger;
import org.usfirst.frc.team5892.HEROcode.inputs.POVTrigger;

public class JoystickPlayerTwo implements PlayerTwo {
    private final Joystick stick;
    public JoystickPlayerTwo(int port) {
        stick = new Joystick(port);
    }

    @Override
    public Trigger elevatorUp() {
        return new POVTrigger(stick, 0);
    }

    @Override
    public Trigger elevatorDown() {
        return new POVTrigger(stick, 180);
    }

    @Override
    public Trigger batwingLeft() {
        return new AnalogAxisTrigger(stick, 2);
    }

    @Override
    public Trigger batwingRight() {
        return new AnalogAxisTrigger(stick, 3);
    }
}
