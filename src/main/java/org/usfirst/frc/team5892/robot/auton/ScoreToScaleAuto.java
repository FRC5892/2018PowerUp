package org.usfirst.frc.team5892.robot.auton;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.CommandGroup;
import org.usfirst.frc.team5892.robot.Robot;
import org.usfirst.frc.team5892.robot.subsystems.elevator.RunElevator;
import org.usfirst.frc.team5892.robot.subsystems.intake.OuttakeCommand;
import org.usfirst.frc.team5892.robot.subsystems.intake.StartIntaking;

import static org.usfirst.frc.team5892.robot.MathUtils.encoderInches;

public class ScoreToScaleAuto extends DynamicAuton {

    @Override
    protected Command buildCommand(char pos, String gameData) {
        return new ScoreToScaleAutoCG(pos, gameData);
    }

    private class ScoreToScaleAutoCG extends CommandGroup {
        ScoreToScaleAutoCG(char pos, String gameData) {
            int turnDir = pos == 'L' ? 1 : -1;
            //addSequential(new IntakeShakedown());
            if (pos == gameData.charAt(0)) {

                addSequential(new AutoStraightDrive(0.9, 0, encoderInches(220)));
                addSequential(new AutoGyroRotate(45 * turnDir));
                //addSequential(new RunElevator(0.8), 2);
                //addSequential(new OuttakeCommand(), 0.5);
                //addParallel(new RunElevator(-0.8), 1);
                addSequential(new AutoGyroRotate(145 * turnDir));
                addSequential(new StartIntaking());
                addSequential(new AutoStraightDrive(0.8, 145 * turnDir, encoderInches(24)));
                addSequential(new WaitCommand(), 0.5);
                addSequential(new WaitCommand(Robot.intake::isButtonPressed), 0.5);
                addSequential(new AutoGyroRotate(10 * turnDir));
                addSequential(new AutoStraightDrive(0.8, 10 * turnDir, encoderInches(12)));
                //addSequential(new RunElevator(0.8), 2);
                addSequential(new OuttakeCommand(), 0.5);

            } else {

                addSequential(new AutoStraightDrive(0.8, 0, encoderInches(190)));
                addSequential(new AutoGyroRotate(90 * turnDir));
                addSequential(new AutoStraightDrive(0.8, 90 * turnDir, encoderInches(171)));
                addSequential(new AutoGyroRotate(0));
                addSequential(new AutoStraightDrive(0.6, 0, encoderInches(10)));
                //addSequential(new RunElevator(0.5), 4);
                //addSequential(new OuttakeCommand(), 1);

            }
        }
    }
}
