package org.usfirst.frc.team5892.robot.subsystems.batwing;

import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.Victor;
import edu.wpi.first.wpilibj.command.Subsystem;
import org.usfirst.frc.team5892.HEROcode.inputs.DigitalInputTrigger;
import org.usfirst.frc.team5892.robot.Robot;
import org.usfirst.frc.team5892.robot.subsystems.batwing.BatwingMotorStop;

public class BatwingSubsystem extends Subsystem {
    private static final double RETAINER_POWER = 0.4;
    private static final double WINCH_POWER = 1;

    private final Victor leftRetainer, leftWinch, rightRetainer, rightWinch;
    private final DigitalInput leftRetainerSwitch, leftWinchSwitch;
    private final DigitalInput rightRetainerSwitch, rightWinchSwitch;
    public int state = 0;

    public BatwingSubsystem() {
        leftRetainer = Robot.map.leftBatwingRetainer.makeVictor();
        leftWinch = Robot.map.leftBatwingWinch.makeVictor();
        rightRetainer = Robot.map.rightBatwingRetainer.makeVictor();
        rightWinch = Robot.map.rightBatwingWinch.makeVictor();
        leftRetainerSwitch = new DigitalInput(Robot.map.leftBatwingRetainerSensor);
        leftWinchSwitch = new DigitalInput(Robot.map.leftBatwingWinchSensor);
        rightRetainerSwitch = new DigitalInput(Robot.map.rightBatwingRetainerSensor);
        rightWinchSwitch = new DigitalInput(Robot.map.rightBatwingWinchSensor);

        addChild(leftRetainer); addChild(leftWinch); addChild(rightRetainer); addChild(rightWinch);
        addChild(leftRetainerSwitch); addChild(leftWinchSwitch);
        addChild(rightRetainerSwitch); addChild(rightWinchSwitch);
    }

    @Override
    protected void initDefaultCommand() {
        new DigitalInputTrigger(leftRetainerSwitch).whenActive(new BatwingMotorStop(leftRetainer));
        new DigitalInputTrigger(leftWinchSwitch).whenActive(new BatwingMotorStop(leftWinch));
        new DigitalInputTrigger(rightRetainerSwitch).whenActive(new BatwingMotorStop(rightRetainer));
        new DigitalInputTrigger(rightWinchSwitch).whenActive(new BatwingMotorStop(rightWinch));
    }

    public void lowerRetainers() {
        leftRetainer.set(RETAINER_POWER);
        rightRetainer.set(RETAINER_POWER);
    }

    public void raiseWinches() {
        leftWinch.set(WINCH_POWER);
        rightWinch.set(WINCH_POWER);
    }

    public boolean isRunning() {
        return leftRetainer.get() != 0 || leftWinch.get() != 0 ||
                rightRetainer.get() != 0 || rightWinch.get() != 0;
    }
}
