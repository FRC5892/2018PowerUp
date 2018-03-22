package org.usfirst.frc.team5892.robot.subsystems.batwing;

import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.Victor;
import edu.wpi.first.wpilibj.command.Subsystem;

public class BatwingSubsystem extends Subsystem {
    private static final double RETAINER_POWER = -0.5;
    private static final double WINCH_POWER = 1;

    private final Victor retainer, winch;
    private final DigitalInput sensor;

    public BatwingSubsystem(String side, Victor retainer, Victor winch, DigitalInput sensor) {
        this.retainer = retainer; this.winch = winch;
        this.sensor = sensor;
        setName(side + " Batwing");
        addChild(side + " Batwing Arm", retainer);
        addChild(side + " Batwing Winch", winch);
        addChild(side + " Batwing Sensor", sensor);
    }

    @Override
    protected void initDefaultCommand() {

    }

    void lowerArm(boolean on) {
        retainer.set(on ? RETAINER_POWER : 0);
    }

    void raiseWinch(boolean on) {
        retainer.set(on ? -0.25 * RETAINER_POWER : 0);
        winch.set(on ? WINCH_POWER : 0);
    }

    boolean isSensorTriggered() {
        return !sensor.get();
    }
}
