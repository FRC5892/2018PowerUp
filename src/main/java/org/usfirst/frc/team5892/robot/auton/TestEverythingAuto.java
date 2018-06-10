package org.usfirst.frc.team5892.robot.auton;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.CommandGroup;

public class TestEverythingAuto extends DynamicAuton {

    @Override
    public boolean isCompatible(char pos) {
        return true;
    }

    @Override
    protected Command buildCommand(char pos, String gameData) {
        return new AutoGyroRotate(90 * (gameData.charAt(0) == 'L' ? -1 : 1));
    }
}
