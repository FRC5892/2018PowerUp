package org.usfirst.frc.team5892.robot.auton;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.CommandGroup;
import org.usfirst.frc.team5892.robot.subsystems.elevator.RunElevator;
import org.usfirst.frc.team5892.robot.subsystems.intake.RunIntake;

import static org.usfirst.frc.team5892.robot.MathUtils.encoderInches;

public class ScoreToSwitchAuto extends DynamicAuton {

    @Override
    public boolean isCompatible(char pos) {
        return pos != 'C';
    }

    @Override
    protected Command buildCommand(char pos, String gameData) {
        return new ScoreToSwitchAutoCG(pos, gameData);
    }

    private class ScoreToSwitchAutoCG extends CommandGroup {
        ScoreToSwitchAutoCG(char pos, String gameData) {
            int turnDir = pos == 'L' ? 1 : -1;
            addParallel(new RunIntake(-0.6), 3);
            if (pos == gameData.charAt(0)) {

                addSequential(new AutoStraightDrive(0.7, 0, encoderInches(138)));
                addSequential(new IntakeAndRotate(90 * turnDir));
                addSequential(new RunElevator(1), 0.75);
                addSequential(new AutoStraightDrive(0.6, 90 * turnDir, encoderInches(20)), 0.75);
                addSequential(new RunIntake(0.8), 1);

            } else {

                addSequential(new AutoStraightDrive(0.7, 0, encoderInches(192)));
                addSequential(new IntakeAndRotate(90 * turnDir));
                addSequential(new AutoStraightDrive(0.7, 90 * turnDir, encoderInches(150)));
                addSequential(new RunElevator(1), 1.25);
                addSequential(new AutoGyroRotate(180 * turnDir));
                addSequential(new RunIntake(0.8), 1);
                addSequential(new RunElevator(0));

            }
        }
    }
}
