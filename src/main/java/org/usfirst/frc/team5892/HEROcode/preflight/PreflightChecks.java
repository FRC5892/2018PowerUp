package org.usfirst.frc.team5892.HEROcode.preflight;

import edu.wpi.first.networktables.NetworkTable;
import edu.wpi.first.networktables.NetworkTableInstance;
import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.Command;

import java.util.ArrayList;
import java.util.List;

public class PreflightChecks extends Command {

    private static PreflightChecks instance;
    private double m_nextMessageTime = 0;
    private NetworkTable table = NetworkTableInstance.getDefault().getTable("Preflight Checks");
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
        getInstance().table.getEntry(check).setBoolean(false);
    }

    @Override
    protected void execute() {
        if (!DriverStation.getInstance().isDisabled()) return;
        double currentTime = Timer.getFPGATimestamp();
        if (currentTime < m_nextMessageTime) return;
        for (String c : checks) {
            if (!getInstance().table.getEntry(c).getBoolean(true)) {
                DriverStation.reportWarning("Not all of the preflight checks are complete!", false);
                m_nextMessageTime = currentTime + 1;
                return;
            }
        }
    }

    @Override
    protected boolean isFinished() {
        return false;
    }
}
