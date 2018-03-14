package org.usfirst.frc.team5892.robot.auton;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.CommandGroup;
import org.usfirst.frc.team5892.HEROcode.auton.PrintMatchTime;
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

                addSequential(new AutoStraightDrive(1, 0, encoderInches(120)));
                addSequential(new AutoStraightDrive(0.8, 0, encoderInches(100)));
                addSequential(new AutoGyroRotate(45 * turnDir));
                //addSequential(new RunElevator(0.8), 2);
                addSequential(new OuttakeCommand(), 0.5);
                //addParallel(new RunElevator(-0.8), 1);
                addSequential(new AutoGyroRotate(145 * turnDir));
                addSequential(new StartIntaking());
                addParallel(new AutoStraightDrive(0.6, 145 * turnDir, encoderInches(40)));
                addSequential(new WaitCommand(Robot.intake::isButtonPressed), 2);
                addSequential(new AutoStraightDrive(-0.7, 145 * turnDir, encoderInches(6)));
                addSequential(new AutoGyroRotate(15 * turnDir));
                addSequential(new AutoStraightDrive(0.8, 15 * turnDir, encoderInches(4)));
                //addSequential(new RunElevator(0.8), 2);
                addSequential(new OuttakeCommand(), 0.5);

            } else {

                addSequential(new AutoStraightDrive(0.7749, 0, encoderInches(180)));
                addSequential(new WaitCommand(0.5));
                addSequential(new AutoGyroRotate(90 * turnDir));
                addSequential(new AutoStraightDrive(0.7749, 90 * turnDir, encoderInches(177)));
                addSequential(new WaitCommand(0.5));
                addSequential(new AutoGyroRotate(-15 * turnDir));
                addSequential(new AutoStraightDrive(0.6, -15 * turnDir, encoderInches(6)));
                //addSequential(new RunElevator(0.8), 2);
                addSequential(new OuttakeCommand(), 1);
                //addSequential(new PrintMatchTime());
                //addSequential(new RunElevator(-0.8, 1);
                addSequential(new AutoGyroRotate(195 * turnDir, 0.5));
                addSequential(new WaitCommand(0.5));
                addSequential(new StartIntaking());
                addParallel(new AutoStraightDrive(0.6, 195 * turnDir, encoderInches(36)));

            }
        }
    }
}
