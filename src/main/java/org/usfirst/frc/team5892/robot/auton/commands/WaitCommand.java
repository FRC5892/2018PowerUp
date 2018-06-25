package org.usfirst.frc.team5892.robot.auton.commands;

import edu.wpi.first.wpilibj.command.Command;

import java.util.function.BooleanSupplier;

public class WaitCommand extends Command {
    private final BooleanSupplier _predicate;

    public WaitCommand() {
        _predicate = () -> false;
    }

    public WaitCommand(double timeout){
        setTimeout(timeout);
        _predicate = this::isTimedOut;
    }

    public WaitCommand(BooleanSupplier predicate) {
        _predicate = predicate;
    }

    @Override
    protected boolean isFinished() {
        return _predicate.getAsBoolean();
    }
}
