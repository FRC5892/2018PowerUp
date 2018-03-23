package org.usfirst.frc.team5892.robot.subsystems.selfclimb;

import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj.command.Command;
import org.usfirst.frc.team5892.robot.Robot;

public class ClimbArmControl extends Command {
    private static final DriverStation ds = DriverStation.getInstance();

    public ClimbArmControl() {
        requires(Robot.selfClimb);
    }

    @Override
    protected void execute() {
        if (isFinished()) return;
        Robot.selfClimb.setArm(Robot.m_oi.player2.climbArm() * 0.6);
    }

    @Override
    protected boolean isFinished() {
        return ds.isFMSAttached() && ds.getMatchTime() > 30;
    }

    @Override
    protected void end() {
        Robot.selfClimb.setArm(0);
    }
}
