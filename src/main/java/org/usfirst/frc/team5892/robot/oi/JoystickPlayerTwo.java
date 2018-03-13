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
    public Trigger intake() {
        return new AnalogAxisTrigger(stick, 1, -0.7);
    }

    @Override
    public Trigger outtake() {
        return new AnalogAxisTrigger(stick, 1);
    }

    @Override
    public double elevator() {
        return -stick.getRawAxis(5) * 0.6;
    }

    @Override
    public Trigger leftBatwingDown() {
        return new JoystickButton(stick, 3);
    }

    @Override
    public Trigger leftBatwingLift() {
        return new JoystickButton(stick, 4);
    }

    @Override
    public Trigger rightBatwingDown() {
        return new JoystickButton(stick, 1);
    }

    @Override
    public Trigger rightBatwingLift() {
        return new JoystickButton(stick, 2);
    }


}
