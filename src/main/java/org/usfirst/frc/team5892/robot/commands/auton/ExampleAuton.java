package org.usfirst.frc.team5892.robot.commands.auton;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.CommandGroup;
import org.usfirst.frc.team5892.robot.commands.ExampleCommand;

public class ExampleAuton implements AutonBuilder {

    @Override
    public Command buildAuto(String fieldData) {
        return new ExampleAutonCG(fieldData);
    }

    private class ExampleAutonCG extends CommandGroup {
        private ExampleAutonCG(String fieldData) {
            addSequential(new ExampleCommand()); // this command will finish running before the one below it
            addSequential(new ExampleCommand());
            addParallel(new ExampleCommand()); // this command will run at the same time as any that come afterwards
            addSequential(new ExampleCommand());
            if (fieldData.charAt(0) == 'L') {
                addSequential(new ExampleCommand());
            } else {
                addParallel(new ExampleCommand());
                addSequential(new ExampleCommand());
            }
        }
    }
}
