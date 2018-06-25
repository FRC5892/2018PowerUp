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
        CommandGroup ret = new CommandGroup();
        int turnDir = pos == 'L' ? 1 : -1;
        ret.addParallel(new RunIntake(-0.6), 3);
        if (pos == gameData.charAt(0)) {

            ret.addSequential(new AutoStraightDrive(0.7, 0, encoderInches(138)));
            ret.addSequential(new IntakeAndRotate(90 * turnDir));
            ret.addSequential(new RunElevator(1), 0.75);
            ret.addSequential(new AutoStraightDrive(0.6, 90 * turnDir, encoderInches(20)), 0.75);
            ret.addSequential(new RunIntake(0.8), 1);

        } else {

            ret.addSequential(new AutoStraightDrive(0.7, 0, encoderInches(192)));
            ret.addSequential(new IntakeAndRotate(90 * turnDir));
            ret.addSequential(new AutoStraightDrive(0.7, 90 * turnDir, encoderInches(150)));
            ret.addSequential(new RunElevator(1), 1);
            ret.addSequential(new AutoGyroRotate(180 * turnDir, 0.5));
            ret.addSequential(new RunIntake(1), 1);
            ret.addSequential(new RunElevator(0));
        }
        return ret;
    }
}
