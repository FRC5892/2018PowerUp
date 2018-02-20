package org.usfirst.frc.team5892.robot.subsystems.elevator;

import edu.wpi.first.wpilibj.command.Command;
import org.usfirst.frc.team5892.robot.Robot;

public class ElevatorControl extends Command {

    public ElevatorControl() {
        requires(Robot.elevator);
    }

    @Override
    protected void execute() {
        Robot.elevator.setMotorPower(Robot.m_oi.player2.elevator());
    }

    @Override
    protected boolean isFinished() {
        return false;
    }
}
