package org.usfirst.frc.team5892.robot.auton;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.CommandGroup;
import org.usfirst.frc.team5892.robot.subsystems.elevator.AutonElevatorRun;
import org.usfirst.frc.team5892.robot.subsystems.intake.AutonIntakeRun;

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
            if (position == fieldData.charAt(0)) {

                addSequential(new AutoStraightDrive(0.6, encoderInches(148)));
                addSequential(new AutoGyroRotate(90 * turnDir));
                addSequential(new AutoStraightDrive(0.3, encoderInches(14)));
                addSequential(new AutonElevatorRun(0.5, 0.5));
                addSequential(new AutonIntakeRun(0.6, 0.5));

            } else {

                addSequential(new AutoStraightDrive(0.6, encoderInches(217)));
                addSequential(new AutoGyroRotate(90 * turnDir));
                addSequential(new AutoStraightDrive(0.6, encoderInches(172)));
                addSequential(new AutoGyroRotate(90 * turnDir));
                addSequential(new AutonElevatorRun(0.6, 0.75));
                addSequential(new AutonIntakeRun(0.8, 0.75));

            }
        }
    }
}
