package org.usfirst.frc.team5892.robot.subsystems.selfclimb;

import edu.wpi.first.wpilibj.Sendable;
import edu.wpi.first.wpilibj.SpeedController;
import edu.wpi.first.wpilibj.command.Subsystem;
import org.usfirst.frc.team5892.robot.Robot;
import org.usfirst.frc.team5892.robot.RobotMap;

public class SelfClimbSubsystem extends Subsystem {

    private final SpeedController arm;
    private final SpeedController winch;

    public SelfClimbSubsystem() {
        arm = Robot.map.selfClimbArm.makeVictor();
        winch = RobotMap.makeVictorGroup(Robot.map.selfClimbWinch);

        addChild("Arm", (Sendable) arm); addChild("Winch", (Sendable) winch);
    }

    @Override
    protected void initDefaultCommand() {

    }

    public void setArm(double power) {
        arm.set(power);
    }

    public void setWinch(double power) {
        winch.set(power);
    }
}
