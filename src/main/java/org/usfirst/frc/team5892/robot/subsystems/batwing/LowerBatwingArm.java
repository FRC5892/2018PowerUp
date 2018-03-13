package org.usfirst.frc.team5892.robot.subsystems.batwing;

import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj.command.Command;

public class LowerBatwingArm extends Command {
    private static final DriverStation ds = DriverStation.getInstance();

    private final BatwingSubsystem batwing;

    public LowerBatwingArm(BatwingSubsystem batwing) {
        requires(batwing);
        this.batwing = batwing;
    }

    @Override
    protected void execute() {
        batwing.lowerArm(true);
    }

    @Override
    protected boolean isFinished() {
        return ds.isFMSAttached() && ds.getMatchTime() > 30;
    }

    @Override
    protected void end() {
        batwing.lowerArm(false);
    }
}
