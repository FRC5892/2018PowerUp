package org.usfirst.frc.team5892.robot.oi;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.Trigger;
import org.usfirst.frc.team5892.HEROcode.inputs.AnalogAxisTrigger;

public class JoystickPlayerOne implements PlayerOne {
    private final Joystick stick;
    public JoystickPlayerOne(int port) {
        stick = new Joystick(port);
    }

    @Override
    public double moveAxis() {
        return -stick.getRawAxis(1);
    }

    @Override
    public double turnAxis() {
        return stick.getRawAxis(4);
    }

    @Override
    public Trigger intake() {
        return new AnalogAxisTrigger(stick, 2);
    }

    @Override
    public Trigger outtake() {
        return new AnalogAxisTrigger(stick, 3);
    }
}
