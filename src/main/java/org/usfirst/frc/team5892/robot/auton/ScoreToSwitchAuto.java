package org.usfirst.frc.team5892.robot.auton;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.CommandGroup;
import org.usfirst.frc.team5892.robot.subsystems.elevator.RunElevator;
import org.usfirst.frc.team5892.robot.subsystems.intake.RunIntake;

import static org.usfirst.frc.team5892.robot.MathUtils.encoderInches;

public class ScoreToSwitchAuto extends DynamicAuton {

    @Override
    protected Command buildCommand(char pos, String gameData) {
        return new ScoreToSwitchAutoCG(pos, gameData);
    }

    private class ScoreToSwitchAutoCG extends CommandGroup {
        ScoreToSwitchAutoCG(char pos, String gameData) {
            int turnDir = pos == 'L' ? 1 : -1;
            //addSequential(new IntakeShakedown());
            if (pos == gameData.charAt(0)) {

                addSequential(new AutoStraightDrive(0.8, 0, encoderInches(148)));
                addSequential(new AutoGyroRotate(90 * turnDir));
                addSequential(new AutoStraightDrive(0.6, 90 * turnDir, encoderInches(20)));
                addSequential(new RunElevator(0.5), 1);
                addSequential(new RunIntake(0.8), 1);

            } else {

                addSequential(new AutoStraightDrive(0.8, 0, encoderInches(190)));
                addSequential(new AutoGyroRotate(90 * turnDir));
                addSequential(new AutoStraightDrive(0.8, 90 * turnDir, encoderInches(150)));
                addSequential(new RunElevator(0.7), 1.5);
                addSequential(new AutoGyroRotate(180 * turnDir));
                addSequential(new RunIntake(0.8), 1);
                addSequential(new RunElevator(0));

            }
        }
    }
}
