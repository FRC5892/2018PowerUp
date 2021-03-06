package org.usfirst.frc.team5892.robot.auton.commands;

import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import org.usfirst.frc.team5892.robot.Robot;
import org.usfirst.frc.team5892.robot.auton.DynamicAuton;

public class AutonCompatibilityCheck extends Command {

    private double m_nextMessageTime = 0;
    private final SendableChooser<Character> posChooser;

    public AutonCompatibilityCheck(SendableChooser<Character> posChooser) {
        setRunWhenDisabled(true);
        this.posChooser = posChooser;
    }

    @Override
    protected void execute() {
        if (Robot.autonChooser.getSelected() == null) return;
        double currentTime = Timer.getFPGATimestamp();
        if (currentTime < m_nextMessageTime) return;
        DynamicAuton selected = Robot.autonChooser.getSelected();
        char pos = posChooser.getSelected();
        if (!selected.isCompatible(pos)) {
            DriverStation.reportWarning("Selected auton " + selected.getClass().getSimpleName() + " is incompatible with chosen position '" + pos + "'!", false);
            m_nextMessageTime += 2;
        }
    }

    @Override
    protected boolean isFinished() {
        return !DriverStation.getInstance().isDisabled();
    }
}
