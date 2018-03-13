package org.usfirst.frc.team5892.robot.subsystems.batwing;

import edu.wpi.first.wpilibj.Victor;
import edu.wpi.first.wpilibj.command.Subsystem;

public class BatwingSubsystem extends Subsystem {
    private static final double RETAINER_POWER = -0.5;
    private static final double WINCH_POWER = 1;

    private final Victor retainer, winch;

    public BatwingSubsystem(String side, Victor retainer, Victor winch) {
        this.retainer = retainer; this.winch = winch;
        setName(side + " Batwing");
        addChild(side + " Arm", retainer);
        addChild(side + " Winch", winch);
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
}
