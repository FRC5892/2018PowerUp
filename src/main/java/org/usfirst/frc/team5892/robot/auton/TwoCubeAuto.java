package org.usfirst.frc.team5892.robot.auton;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.CommandGroup;
import org.usfirst.frc.team5892.robot.subsystems.elevator.RunElevator;
import org.usfirst.frc.team5892.robot.subsystems.intake.OuttakeCommand;
import org.usfirst.frc.team5892.robot.subsystems.intake.StartIntaking;

import static org.usfirst.frc.team5892.robot.MathUtils.encoderInches;

public class TwoCubeAuto implements AutonBuilder {
    private final char position;
    private final int turnDir;

    public TwoCubeAuto(char position) {
        this.position = position;
        turnDir = position == 'L' ? 1 : -1;
    }

    @Override
    public Command buildAuto(String fieldData) {
        return new TwoCubeAutoCG(fieldData);
    }

    private class TwoCubeAutoCG extends CommandGroup {
        TwoCubeAutoCG(String fieldData) {
            int mode = (fieldData.charAt(0) == position ? 1 : 0) + (fieldData.charAt(1) == position ? 2 : 0);
            addSequential(new StartIntaking());
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
                    addSequential(new OuttakeCommand(), 0.5);
                    addSequential(new RunElevator(-0.1), 1);
                    addSequential(new AutoGyroRotate(159 * turnDir));
                    addSequential(new StartIntaking());
                    addSequential(new AutoStraightDrive(0.7, 159 * turnDir, encoderInches(101)));
                    addSequential(new RunElevator(0.5), 2);
                    addSequential(new OuttakeCommand(), 0.5);
                    break;

            }
        }
    }
}
