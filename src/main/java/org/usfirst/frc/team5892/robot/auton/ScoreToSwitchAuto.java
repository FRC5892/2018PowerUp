package org.usfirst.frc.team5892.robot.auton;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.CommandGroup;
import org.usfirst.frc.team5892.robot.subsystems.elevator.RunElevator;
import org.usfirst.frc.team5892.robot.subsystems.intake.OuttakeCommand;

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
            addSequential(new IntakeShakedown());
            if (position == fieldData.charAt(0)) {

                addSequential(new AutoStraightDrive(0.8, 0, encoderInches(148)));
                addSequential(new AutoGyroRotate(90 * turnDir));
                addSequential(new AutoStraightDrive(0.6, 90 * turnDir, encoderInches(20)));
                addSequential(new RunElevator(0.5), 1);
                addSequential(new OuttakeCommand(), 1);

            } else {

                addSequential(new AutoStraightDrive(0.8, 0, encoderInches(190)));
                addSequential(new AutoGyroRotate(90 * turnDir));
                addSequential(new AutoStraightDrive(0.8, 90 * turnDir, encoderInches(150)));
                addSequential(new RunElevator(0.6), 1);
                addParallel(new RunElevator(0.25));
                addSequential(new AutoGyroRotate(180 * turnDir));
                addSequential(new OuttakeCommand(), 1);
                addSequential(new RunElevator(0));

            }
        }
    }
}
