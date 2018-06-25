package org.usfirst.frc.team5892.robot.auton;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.CommandGroup;
import org.usfirst.frc.team5892.robot.auton.commands.AutoStraightDrive;
import org.usfirst.frc.team5892.robot.auton.commands.IntakeAndRotate;
import org.usfirst.frc.team5892.robot.auton.commands.WaitCommand;
import org.usfirst.frc.team5892.robot.subsystems.elevator.RunElevator;
import org.usfirst.frc.team5892.robot.subsystems.intake.RunIntake;

import static org.usfirst.frc.team5892.robot.MathUtils.encoderInches;

public class ScoreToScaleAuto extends DynamicAuton {

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

            ret.addSequential(new AutoStraightDrive(1, 0, encoderInches(120)));
            ret.addSequential(new AutoStraightDrive(0.8, 0, encoderInches(100)));
            ret.addSequential(new IntakeAndRotate(45 * turnDir));
            ret.addSequential(new RunElevator(1), 5);
            ret.addSequential(new RunIntake(0.8), 0.5);
            ret.addParallel(new RunElevator(-1), 4);

        } else {

            ret.addSequential(new AutoStraightDrive(0.7749, 0, encoderInches(180)));
            ret.addSequential(new WaitCommand(0.5));
            ret.addSequential(new IntakeAndRotate(90 * turnDir));
            ret.addSequential(new AutoStraightDrive(0.7749, 90 * turnDir, encoderInches(177)));
            ret.addSequential(new WaitCommand(0.5));
            ret.addSequential(new IntakeAndRotate(-15 * turnDir));
            ret.addSequential(new AutoStraightDrive(0.6, -15 * turnDir, encoderInches(6)));
            ret.addSequential(new RunElevator(1), 5);
            ret.addSequential(new RunIntake(0.8), 0.5);
            ret.addSequential(new RunElevator(-1), 4);

        }
        return ret;
    }
}
