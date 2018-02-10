package org.usfirst.frc.team5892.robot.commands.elevator;

import edu.wpi.first.wpilibj.command.Command;
import org.usfirst.frc.team5892.robot.Robot;
import org.usfirst.frc.team5892.robot.subsystems.ElevatorSubsystem;

public class ElevatorMovement extends Command {
    
    public ElevatorMovement() {
        requires(Robot.elevator);
    }

    @Override
    protected void execute() {
        ElevatorSubsystem e = Robot.elevator;
        if (e.lastPressed < 0) e.setMotor(-ElevatorSubsystem.MOTOR_POWER); // if we don't know where we are, go down.
        else if (e.lastPressed > e.target) e.setMotor(-ElevatorSubsystem.MOTOR_POWER);
        else if (e.lastPressed < e.target) e.setMotor(ElevatorSubsystem.MOTOR_POWER);
        else e.setMotor(0);
    }

    @Override
    protected boolean isFinished() {
        return false;
    }
}
