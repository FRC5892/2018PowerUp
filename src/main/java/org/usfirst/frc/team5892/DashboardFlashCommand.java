package org.usfirst.frc.team5892;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

// also called FlashboardCommand
public class DashboardFlashCommand extends Command {
    private static final double PERIOD = .5;

    @Override
    protected void initialize() {
        SmartDashboard.putBoolean(getName(), true);
    }

    @Override
    protected void execute() {
        SmartDashboard.putBoolean(getName(), timeSinceInitialized() % PERIOD < PERIOD / 2);
    }

    @Override
    protected boolean isFinished() {
        return false;
    }

    @Override
    protected void end() {
        SmartDashboard.putBoolean(getName(), false);
    }
}
