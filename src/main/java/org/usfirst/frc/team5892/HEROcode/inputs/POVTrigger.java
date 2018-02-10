package org.usfirst.frc.team5892.HEROcode.inputs;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.Trigger;

// TODO docuemtn
public class POVTrigger extends Trigger {
    private final Joystick _stick;
    private final int _pov;
    private final int _angle;

    public POVTrigger(Joystick stick, int angle) {
        this(stick, 0, angle);
    }

    public POVTrigger(Joystick stick, int pov, int angle) {
        _stick = stick;
        _pov = pov;
        _angle = angle;
    }

    @Override
    public boolean get() {
        return _stick.getPOV(_pov) == _angle;
    }
}
