package org.usfirst.frc.team5892.robot.auton;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.CommandGroup;
import org.usfirst.frc.team5892.robot.MathUtils;

public class TestEverythingAuto implements AutonBuilder {

    @Override
    public Command buildAuto(String fieldData) {
        return new TestEverythingAutoCG(fieldData);
    }

    private class TestEverythingAutoCG extends CommandGroup {
        TestEverythingAutoCG(String fieldData) {
            int turnDir = fieldData.charAt(0) == 'L' ? -1 : 1;
            addSequential(new AutoStraightDrive(0.6, MathUtils.encoderInches(120)));
        }
    }
}
