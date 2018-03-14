package org.usfirst.frc.team5892.robot.subsystems.batwing;

import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.DriverStation;
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
        double pwr = on ? WINCH_POWER : 0;
        retainer.set(pwr);
        winch.set(pwr);
    }

    boolean isSensorTriggered() {
        return !sensor.get();
    }
}
