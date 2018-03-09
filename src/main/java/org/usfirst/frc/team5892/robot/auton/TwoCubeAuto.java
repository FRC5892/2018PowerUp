package org.usfirst.frc.team5892.robot.auton;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.CommandGroup;
import org.usfirst.frc.team5892.robot.subsystems.elevator.AutonElevatorRun;
import org.usfirst.frc.team5892.robot.subsystems.intake.AutonIntakeRun;

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
            switch (mode) {

                case 0: // both far
                    break;

                case 1: // switch near
                    break;

                case 2: // scale near
                    break;

                case 3: // both near
                    addSequential(new AutoStraightDrive(0.7, encoderInches(304)));
                    addSequential(new AutoGyroRotate(90 * turnDir));
                    addSequential(new AutonElevatorRun(0.5, 4));
                    addSequential(new AutonIntakeRun(-0.8, 0.5));
                    addSequential(new AutonElevatorRun(-0.1, 1));
                    addSequential(new AutoGyroRotate(69 * turnDir));
                    addParallel(new AutonIntakeRun(0.5, 15));
                    addSequential(new AutoStraightDrive(0.7, encoderInches(101)));
                    addParallel(new AutonIntakeRun(0, 0));
                    addSequential(new AutonElevatorRun(0.5, 2));
                    addSequential(new AutonIntakeRun(-0.6, 0.5));
                    break;

            }
        }
    }
}
