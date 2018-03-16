package org.usfirst.frc.team5892.robot.auton;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.CommandGroup;
import org.usfirst.frc.team5892.robot.subsystems.elevator.RunElevator;
import org.usfirst.frc.team5892.robot.subsystems.intake.RunIntake;

import static org.usfirst.frc.team5892.robot.MathUtils.encoderInches;

public class TwoCubeAuto extends DynamicAuton {

    @Override
    protected Command buildCommand(char pos, String gameData) {
        return new TwoCubeAutoCG(pos, gameData);
    }

    private class TwoCubeAutoCG extends CommandGroup {
        TwoCubeAutoCG(char pos, String gameData) {
            int turnDir = pos == 'L' ? 1 : -1;
            int mode = (gameData.charAt(0) == pos ? 1 : 0) + (gameData.charAt(1) == pos ? 2 : 0);
            switch (mode) {

                case 0: // both far
                    break;

                case 1: // switch near
                    break;

                case 2: // scale near
                    break;

                case 3: // both near
                    addSequential(new AutoStraightDrive(0.7, 0, encoderInches(304)));
                    addSequential(new AutoGyroRotate(90 * turnDir));
                    addSequential(new RunElevator(0.5), 4);
                    addSequential(new RunIntake(0.8), 0.5);
                    addSequential(new RunElevator(-0.1), 1);
                    addSequential(new AutoGyroRotate(159 * turnDir));
                    addParallel(new RunIntake(-1, true), 2);
                    addSequential(new AutoStraightDrive(0.7, 159 * turnDir, encoderInches(101)));
                    addSequential(new RunElevator(0.5), 2);
                    addSequential(new RunIntake(0.8), 0.5);
                    break;

            }
        }
    }
}
