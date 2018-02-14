package org.usfirst.frc.team5892.robot.subsystems.batwing;

import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj.Victor;
import edu.wpi.first.wpilibj.command.Subsystem;
import org.usfirst.frc.team5892.HEROcode.inputs.DigitalInputTrigger;
import org.usfirst.frc.team5892.robot.Robot;

public class BatwingSubsystem extends Subsystem {
    private static final double RETAINER_POWER = 0.4;
    private static final double WINCH_POWER = 1;

    public class Batwing {
        private final Victor retainer, winch;
        private final DigitalInput platformSwitch;
        private boolean nextIsWinch = false;

        private Batwing(Victor _retainer, Victor _winch, DigitalInput _platformSwitch) {
            retainer = _retainer;
            winch = _winch;
            platformSwitch = _platformSwitch;

            addChild(retainer); addChild(winch);
            addChild(platformSwitch);
        }

        private void initCommands() {
            new DigitalInputTrigger(platformSwitch).whenActive(new BatwingMotorStop(winch));
        }

        void advance() {
            if (nextIsWinch = !nextIsWinch) { // because of inversion, THIS IS THE RETAINER CASE.
                winch.stopMotor();
                retainer.set(RETAINER_POWER);
            } else { // because of inversion, THIS IS THE WINCH CASE.
                retainer.stopMotor();
                winch.set(WINCH_POWER);
            }
        }
    }

    public final Batwing left;
    public final Batwing right;

    public BatwingSubsystem() {
        left = new Batwing(
                Robot.map.leftBatwingRetainer.makeVictor(),
                Robot.map.leftBatwingWinch.makeVictor(),
                new DigitalInput(Robot.map.leftBatwingSensor)
        );
        right = new Batwing(
                Robot.map.rightBatwingRetainer.makeVictor(),
                Robot.map.rightBatwingWinch.makeVictor(),
                new DigitalInput(Robot.map.rightBatwingSensor)
        );
    }

    @Override
    protected void initDefaultCommand() {
        left.initCommands();
        right.initCommands();
    }
}
