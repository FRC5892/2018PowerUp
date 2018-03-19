package org.usfirst.frc.team5892.robot.auton;

import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import org.usfirst.frc.team5892.robot.Robot;

class AutonCompatibilityCheck extends Command {

    private double m_nextMessageTime = 0;
    private final SendableChooser<Character> posChooser;

    public AutonCompatibilityCheck(SendableChooser<Character> posChooser) {
        setRunWhenDisabled(true);
        this.posChooser = posChooser;
    }

    @Override
    protected void execute() {
        double currentTime = Timer.getFPGATimestamp();
        if (currentTime < m_nextMessageTime) return;
        DynamicAuton selected = Robot.autonChooser.getSelected();
        char pos = posChooser.getSelected();
        if (!selected.isCompatible(pos)) {
            DriverStation.reportWarning("Selected auton " + selected + " is incompatible with chosen position '" + pos + "'!", false);
            m_nextMessageTime += 5;
        }
    }

    @Override
    protected boolean isFinished() {
        return !DriverStation.getInstance().isDisabled();
    }
}
