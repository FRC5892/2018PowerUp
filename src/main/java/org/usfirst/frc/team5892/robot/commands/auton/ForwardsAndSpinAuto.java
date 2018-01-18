package org.usfirst.frc.team5892.robot.commands.auton;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.CommandGroup;

public class ForwardsAndSpinAuto implements AutonBuilder {

    @Override
    public Command buildAuto(String fieldData) {
        return new ForwardsAndSpinAutoCG(fieldData);
    }

    private class ForwardsAndSpinAutoCG extends CommandGroup {
        ForwardsAndSpinAutoCG(String fieldData) {
            addSequential(new AutoTankDrive(0.5, 0.5, 2));
            addSequential(new AutoTankDrive(0.5, -0.5, 2));
        }
    }
}
