package org.usfirst.frc.team5892.robot.auton;

import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public abstract class DynamicAuton {
    private static SendableChooser<Character> posChooser;
    private static AutonCompatibilityCheck checkCommand;

    protected DynamicAuton() {
        if (posChooser == null) {
            posChooser = new SendableChooser<>();
            posChooser.addObject("Left", 'L');
            posChooser.addObject("Center", 'C');
            posChooser.addDefault("Right", 'R');
            SmartDashboard.putData("Starting Position", posChooser);
            checkCommand = new AutonCompatibilityCheck(posChooser);
        }
    }

    public static void startCheckCommand() {
        if (!checkCommand.isRunning()) checkCommand.start();
    }

    public boolean isCompatible(char pos) {
        return true;
    }

    public final Command build() {
        Command ret = buildCommand(posChooser.getSelected(), DriverStation.getInstance().getGameSpecificMessage());
        ret.setName(getClass().getName());
        return ret;
    }

    protected abstract Command buildCommand(char pos, String gameData);
}
