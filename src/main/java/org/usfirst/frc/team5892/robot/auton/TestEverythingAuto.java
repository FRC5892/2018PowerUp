package org.usfirst.frc.team5892.robot.auton;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.CommandGroup;
import org.usfirst.frc.team5892.robot.MathUtils;

public class TestEverythingAuto extends DynamicAuton {

    @Override
    protected Command buildCommand(char pos, String gameData) {
        return new TestEverythingAutoCG(gameData);
    }

    private class TestEverythingAutoCG extends CommandGroup {
        TestEverythingAutoCG(String gameData) {
            int turnDir = gameData.charAt(0) == 'L' ? -1 : 1;
            addSequential(new AutoGyroRotate(90));
        }
    }
}
