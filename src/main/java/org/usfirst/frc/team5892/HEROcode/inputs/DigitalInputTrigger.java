package org.usfirst.frc.team5892.HEROcode.inputs;

import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.buttons.Trigger;

/**
 * A {@link Trigger} that activates based on a {@link DigitalInput}.
 *
 * @author Kai Page
 */
public class DigitalInputTrigger extends Trigger {
    private final DigitalInput _input;

    /**
     * @param input The {@link DigitalInput} to read from.
     */
    public DigitalInputTrigger(DigitalInput input) {
        _input = input;
    }

    @Override
    public boolean get() {
        return _input.get();
    }
}
