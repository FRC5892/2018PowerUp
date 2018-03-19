package org.usfirst.frc.team5892.robot.auton;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.CommandGroup;
import org.usfirst.frc.team5892.robot.subsystems.elevator.RunElevator;
import org.usfirst.frc.team5892.robot.subsystems.intake.RunIntake;

import static org.usfirst.frc.team5892.robot.MathUtils.encoderInches;

public class LoneStarCentralAuto extends DynamicAuton {

    @Override
    protected Command buildCommand(char pos, String gameData) {
        return new LoneStarCentralAutoCG(pos, gameData);
    }

    private class LoneStarCentralAutoCG extends CommandGroup {
        LoneStarCentralAutoCG(char pos, String gameData) {
            if (pos == gameData.charAt(0)) {
                addSequential(new AutoStraightDrive(0.6, 0, encoderInches(100)), 5);
                addSequential(new RunIntake(1), 1);
            } else {
                addSequential(new AutoStraightDrive(0.6, 0, encoderInches(100)), 5);
            }
        }
    }
}
