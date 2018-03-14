package org.usfirst.frc.team5892.robot.auton;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.CommandGroup;
import org.usfirst.frc.team5892.robot.subsystems.elevator.RunElevator;
import org.usfirst.frc.team5892.robot.subsystems.intake.OuttakeCommand;
import org.usfirst.frc.team5892.robot.subsystems.intake.StartIntaking;

import static org.usfirst.frc.team5892.robot.MathUtils.encoderInches;

public class TwoCubeScaleAuto extends DynamicAuton {
    @Override
    protected Command buildCommand(char pos, String gameData) {
        return new TwoCubeScaleAutoCG(pos, gameData);
    }

    private class TwoCubeScaleAutoCG extends CommandGroup {
        private TwoCubeScaleAutoCG(char pos, String gameData) {
            int turnDir = pos == 'L' ? 1 : -1;

            addSequential(new StartIntaking());

            if (pos == gameData.charAt(0)) {
                // first cube
                addSequential(new AutoStraightDrive(0.7, 0, encoderInches(304)));
                addSequential(new AutoGyroRotate(90 * turnDir));
                addSequential(new RunElevator(0.5), 4);
                addSequential(new OuttakeCommand(), 1);

                // turn around
                addSequential(new AutoGyroRotate(180 * turnDir));

                // get cube
                addSequential(new AutoStraightDrive(0.7, 180, encoderInches(107)));
                addSequential(new AutoGyroRotate(90 * turnDir));
                addSequential(new StartIntaking());

                // turn around & go back to scale
                addSequential(new AutoGyroRotate(0));
                addSequential(new AutoStraightDrive(0.7, 0, encoderInches(107)));
                addSequential(new AutoGyroRotate(90 * turnDir));
                addSequential(new RunElevator(0.5), 4);
                addSequential(new OuttakeCommand(), 1);
            } else {
                // first cube
                addSequential(new AutoStraightDrive(0.8, 0, encoderInches(190)));
                addSequential(new AutoGyroRotate(90 * turnDir));
                addSequential(new AutoStraightDrive(0.8, 90 * turnDir, encoderInches(150)));
                addSequential(new AutoGyroRotate(0));
                addSequential(new AutoStraightDrive(0.6, 0, encoderInches(10)));
                addSequential(new RunElevator(0.5), 4);
                addSequential(new OuttakeCommand(), 1);

                // turn around
                addSequential(new AutoGyroRotate(180 * turnDir));

                // get cube
                addSequential(new AutoStraightDrive(0.7, 180, encoderInches(107)));
                addSequential(new AutoGyroRotate(90 * turnDir));
                addSequential(new StartIntaking());

                // turn around & go back to scale
                addSequential(new AutoGyroRotate(0));
                addSequential(new AutoStraightDrive(0.7, 0, encoderInches(107)));
                addSequential(new AutoGyroRotate(90 * turnDir));
                addSequential(new RunElevator(0.5), 4);
                addSequential(new OuttakeCommand(), 1);
            }
        }
    }
}
