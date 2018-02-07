package org.usfirst.frc.team5892.robot.oi;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.JoystickButton;
import edu.wpi.first.wpilibj.buttons.Trigger;

public class JoystickPlayerOne implements PlayerOne, PlayerTwo {
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

    // -----

    @Override
    public double intakeMotors() {
        return stick.getRawAxis(2) - stick.getRawAxis(3);
    }

    @Override
    public Trigger togglePiston1() {
        return new JoystickButton(stick, 1);
    }

    @Override
    public Trigger togglePiston2() {
        return new JoystickButton(stick, 2);
    }

    @Override
    public Trigger togglePiston3() {
        return new JoystickButton(stick, 3);
    }
}
