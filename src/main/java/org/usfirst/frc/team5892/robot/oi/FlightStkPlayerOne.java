package org.usfirst.frc.team5892.robot.oi;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.JoystickButton;
import edu.wpi.first.wpilibj.buttons.Trigger;

public class FlightStkPlayerOne /*implements PlayerOne*/ {
    private final Joystick stick;
    public FlightStkPlayerOne(int port) {
        stick = new Joystick(port);
    }

    //@Override
    public double moveAxis() {
        return stick.getRawAxis(1);
    }

    //@Override
    public double turnAxis() {
        if (stick.getName().equals("Logitech Extreme 3D"))
            return stick.getRawAxis(2);
        else
            return stick.getRawAxis(0);
    }

    //@Override
    public Trigger slowMode() {
        return new JoystickButton(stick, 1);
    }
}
