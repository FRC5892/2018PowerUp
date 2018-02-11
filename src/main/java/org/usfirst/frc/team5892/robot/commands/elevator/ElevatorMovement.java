package org.usfirst.frc.team5892.robot.commands.elevator;

import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj.command.Command;
import org.usfirst.frc.team5892.robot.Robot;
import org.usfirst.frc.team5892.robot.subsystems.ElevatorSubsystem;

public class ElevatorMovement extends Command {
    private static final ElevatorSubsystem.Movement DEFAULT = ElevatorSubsystem.Movement.DOWN;

    private final ElevatorSubsystem e;
    
    public ElevatorMovement() {
        requires(Robot.elevator);
        e = Robot.elevator;
    }

    @Override
    protected void execute() {
        e.setMovement(getNewMovement(e.getLastPressed(), e.getTarget(), e.isPressedSinceTargetChange(), e.getMovement()));
    }

    private static ElevatorSubsystem.Movement getNewMovement(int lastPressed, int target, boolean pressedSinceChange,
                                                             ElevatorSubsystem.Movement currentMovement) {
        if (lastPressed < 0) return DEFAULT; // if we don't know where we are...

        if (lastPressed < target) return ElevatorSubsystem.Movement.UP;
        if (lastPressed > target) return ElevatorSubsystem.Movement.DOWN;

        // target == lastPressed, but where are we really?
        if (pressedSinceChange) return ElevatorSubsystem.Movement.STOPPED;
        if (currentMovement == ElevatorSubsystem.Movement.UP) return ElevatorSubsystem.Movement.DOWN;
        if (currentMovement == ElevatorSubsystem.Movement.DOWN) return ElevatorSubsystem.Movement.UP;

        // we should have returned by this point.

        String errorOutput = String.format("The ElevatorSubsystem's state is SO ILLEGAL right now.%n" +
        "lastPressed is %d%n" +
        "target is %d%n" +
        "pressedSinceChange is false (always false here)%n" +
        "currentMovement is %s", lastPressed, target, /*pressedSinceChange,*/ currentMovement);

        if (DriverStation.getInstance().isFMSAttached()) { // don't crash mid-match. even for illegal elevator states.
            DriverStation.reportError(errorOutput, false);
            return DEFAULT;
        } else throw new RuntimeException(errorOutput);
    }

    @Override
    protected boolean isFinished() {
        return false;
    }
}
