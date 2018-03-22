package org.usfirst.frc.team5892.robot.subsystems.selfclimb;

import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj.command.Command;
import org.usfirst.frc.team5892.robot.Robot;

public class RunClimbWinch extends Command {
    private static final DriverStation ds = DriverStation.getInstance();
    private final double power;

    public RunClimbWinch(double power) {
        this.power = power;
    }

    @Override
    protected void execute() {
        Robot.selfClimb.setWinch(power);
    }

    @Override
    protected boolean isFinished() {
        return ds.isFMSAttached() && ds.getMatchTime() > 30;
    }

    @Override
    protected void end() {
        Robot.selfClimb.setWinch(0);
    }
}
