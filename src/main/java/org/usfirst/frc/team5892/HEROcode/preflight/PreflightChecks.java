package org.usfirst.frc.team5892.HEROcode.preflight;

import edu.wpi.first.networktables.NetworkTable;
import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

import java.util.ArrayList;
import java.util.List;

public class PreflightChecks extends Command {

    private static PreflightChecks instance;
    private List<String> checks = new ArrayList<>();

    private PreflightChecks() {
        setInterruptible(false);
        setRunWhenDisabled(true);
    }

    private static PreflightChecks getInstance() {
        if (instance == null) {
            instance = new PreflightChecks();
            instance.start();
        }
        return instance;
    }

    public static void addCheck(String check) {
        getInstance().checks.add(check);
        SmartDashboard.putBoolean(check, false);
    }

    @Override
    protected void execute() {
        if (!DriverStation.getInstance().isDisabled()) return;
        for (String c : checks) {
            if (!SmartDashboard.getBoolean(c, true)) {
                DriverStation.reportWarning("Not all of the preflight checks are complete", false);
            }
        }
    }

    @Override
    protected boolean isFinished() {
        return false;
    }
}
