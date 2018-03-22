package org.usfirst.frc.team5892.robot.oi;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.JoystickButton;
import edu.wpi.first.wpilibj.buttons.Trigger;
import org.usfirst.frc.team5892.HEROcode.inline.InlineTrigger;

public class DualFlightPlayerOne /*implements PlayerOne*/ {
    private final Joystick left, right;
    public DualFlightPlayerOne(int leftPort, int rightPort) {
        left = new Joystick(leftPort);
        right = new Joystick(rightPort);
    }

    //@Override
    public double moveAxis() {
        return left.getRawAxis(1);
    }

    //@Override
    public double turnAxis() {
        return right.getRawAxis(2); // extreme 3D p much has to be on right, and the x axis on it feels really weird.
    }

    //@Override
    public Trigger slowMode() {
        return new InlineTrigger(false, new JoystickButton(left, 1), new JoystickButton(right, 1));
    }
}
