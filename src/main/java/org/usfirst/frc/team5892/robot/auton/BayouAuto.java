package org.usfirst.frc.team5892.robot.auton;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.CommandGroup;
import org.usfirst.frc.team5892.robot.subsystems.intake.RunIntake;

import static org.usfirst.frc.team5892.robot.MathUtils.encoderInches;

public class BayouAuto extends DynamicAuton {

    @Override
    public boolean isCompatible(char pos) {
        return true;
    }

    @Override
    protected Command buildCommand(char pos, String gameData) {
        return new BayouAutoCG(pos, gameData);
    }

    private class BayouAutoCG extends CommandGroup {
        BayouAutoCG(char pos, String gameData) {
            addSequential(new AutoTankDrive(0.6, 0.6, encoderInches(100), 3));
            if (pos == gameData.charAt(0)) addSequential(new RunIntake(1), 2);
        }
    }
}
