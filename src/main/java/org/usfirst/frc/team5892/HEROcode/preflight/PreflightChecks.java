package org.usfirst.frc.team5892.HEROcode.preflight;

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

    static void addCheck(String check) {
        getInstance().checks.add(check);
        SmartDashboard.putBoolean(check, false);
    }

    @Override
    protected void execute() {
        if (!DriverStation.getInstance().isDisabled()) return;
        for (String c : checks) {
            System.out.println(c);
        }
    }

    @Override
    protected boolean isFinished() {
        return false;
    }
}
