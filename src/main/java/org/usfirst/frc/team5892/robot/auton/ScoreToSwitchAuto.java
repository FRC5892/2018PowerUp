package org.usfirst.frc.team5892.robot.auton;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.CommandGroup;
import org.usfirst.frc.team5892.robot.subsystems.elevator.RunElevator;
import org.usfirst.frc.team5892.robot.subsystems.intake.OuttakeCommand;
import org.usfirst.frc.team5892.robot.subsystems.intake.StartIntaking;

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
            addParallel(new StartIntaking());
            if (position == fieldData.charAt(0)) {

                addSequential(new AutoStraightDrive(0.8, encoderInches(148)));
                addSequential(new AutoGyroRotate(90 * turnDir));
                addSequential(new AutoStraightDrive(0.6, encoderInches(20)));
                addSequential(new RunElevator(0.5), 1);
                addSequential(new OuttakeCommand(), 1);

            } else {

                addSequential(new AutoStraightDrive(0.8, encoderInches(205)));
                addSequential(new AutoGyroRotate(90 * turnDir));
                addSequential(new AutoStraightDrive(0.8, encoderInches(190)));
                addParallel(new AutoGyroRotate(90 * turnDir));
                addSequential(new RunElevator(0.6), 1);
                addSequential(new OuttakeCommand(), 1);

            }
        }
    }
}
