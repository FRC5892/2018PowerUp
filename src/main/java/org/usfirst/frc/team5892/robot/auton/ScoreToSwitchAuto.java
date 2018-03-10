package org.usfirst.frc.team5892.robot.auton;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.CommandGroup;
import edu.wpi.first.wpilibj.command.PrintCommand;
import org.usfirst.frc.team5892.robot.subsystems.elevator.RunElevator;
import org.usfirst.frc.team5892.robot.subsystems.intake.RunIntake;

import static org.usfirst.frc.team5892.robot.MathUtils.*;

public class ScoreToSwitchAuto implements AutonBuilder {
    private final char position;
    private final int turnDir;

    public ScoreToSwitchAuto(char position) {
        this.position = position;
        turnDir = position == 'L' ? 1 : -1;
    }

    @Override
    public Command buildAuto(String fieldData) {
        return new ScoreToSwitchAutoCG(fieldData);
    }

    private class ScoreToSwitchAutoCG extends CommandGroup {
        ScoreToSwitchAutoCG(String fieldData) {
            //addParallel(new RunIntake(0.2), 1);
            if (position == fieldData.charAt(0)) {

                addSequential(new AutoStraightDrive(0.8, encoderInches(148)));
                addSequential(new PrintCommand("starting rotate"));
                addSequential(new AutoGyroRotate(90 * turnDir));
                addSequential(new PrintCommand("ending rotate"));
                addSequential(new AutoStraightDrive(0.6, encoderInches(14)));
                addSequential(new PrintCommand("ending forwards"));
                //addSequential(new RunElevator(0.5), 0.5);
                //addSequential(new RunIntake(-0.6), 0.5);

            } else {

                addSequential(new AutoStraightDrive(0.6, encoderInches(217)));
                addSequential(new AutoGyroRotate(90 * turnDir));
                addSequential(new AutoStraightDrive(0.6, encoderInches(172)));
                addSequential(new AutoGyroRotate(90 * turnDir));
                //addSequential(new RunElevator(0.6), 0.75);
                //addSequential(new RunIntake(-0.8), 0.75);

            }
        }
    }
}
