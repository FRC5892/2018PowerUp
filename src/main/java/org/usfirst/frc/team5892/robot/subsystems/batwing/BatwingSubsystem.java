package org.usfirst.frc.team5892.robot.subsystems.batwing;

import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj.Victor;
import edu.wpi.first.wpilibj.command.Subsystem;
import org.usfirst.frc.team5892.HEROcode.inputs.DigitalInputTrigger;
import org.usfirst.frc.team5892.robot.Robot;
import org.usfirst.frc.team5892.robot.subsystems.batwing.BatwingMotorStop;

public class BatwingSubsystem extends Subsystem {
    private static final double RETAINER_POWER = 0.3;
    private static final double WINCH_POWER = 0.3;

    public class Batwing {
        private final Victor retainer, winch;
        private final DigitalInput retainerSwitch, winchSwitch;
        private int state = 0; // 0=up, 1=ramp, 2=platform

        private Batwing(Victor _retainer, Victor _winch, DigitalInput _retainerSwitch, DigitalInput _winchSwitch) {
            retainer = _retainer;
            winch = _winch;
            retainerSwitch = _retainerSwitch;
            winchSwitch = _winchSwitch;

            addChild(retainer); addChild(winch);
            addChild(retainerSwitch); addChild(winchSwitch);
        }

        private void initCommands() {
            new DigitalInputTrigger(retainerSwitch).whenActive(new BatwingMotorStop(retainer));
            new DigitalInputTrigger(winchSwitch).whenActive(new BatwingMotorStop(winch));
        }

        void advance() {
            //if (running()) return;
            System.out.print("Batwing.advance: ");
            switch (state++) {
                case 0:
                    System.out.println("state is 0");
                    //retainer.set(RETAINER_POWER);
                    break;
                case 1:
                    System.out.println("state is 1");
                    retainer.set(-RETAINER_POWER);
                    winch.set(WINCH_POWER);
                    break;
                default:
                    System.out.println("state is weird");
                    DriverStation.reportWarning("Batwing.advance() called with state " + state, false);
            }
        }

        boolean running() {
            return retainer.get() != 0 || winch.get() != 0;
        }
    }

    public final Batwing left;
    public final Batwing right;

    public BatwingSubsystem() {
        left = new Batwing(
                Robot.map.leftBatwingRetainer.makeVictor(),
                Robot.map.leftBatwingWinch.makeVictor(),
                new DigitalInput(Robot.map.leftBatwingRetainerSensor),
                new DigitalInput(Robot.map.leftBatwingWinchSensor)
        );
        right = new Batwing(
                Robot.map.rightBatwingRetainer.makeVictor(),
                Robot.map.rightBatwingWinch.makeVictor(),
                new DigitalInput(Robot.map.rightBatwingRetainerSensor),
                new DigitalInput(Robot.map.rightBatwingWinchSensor)
        );
    }

    @Override
    protected void initDefaultCommand() {
        left.initCommands();
        right.initCommands();
    }

    public void resetBatwings() {
        left.state = 0;
        right.state = 0;
    }
}
