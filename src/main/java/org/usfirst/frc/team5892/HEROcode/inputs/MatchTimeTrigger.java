package org.usfirst.frc.team5892.HEROcode.inputs;

import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj.buttons.Trigger;

public class MatchTimeTrigger extends Trigger {
    private static final DriverStation ds = DriverStation.getInstance();

    private final double time;

    public MatchTimeTrigger(double time) {
        this.time = time;
    }

    @Override
    public boolean get() {
        double matchTime = ds.getMatchTime();
        return ds.isOperatorControl() && matchTime > 0 && matchTime < time;
    }
}
