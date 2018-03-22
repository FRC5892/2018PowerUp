package org.usfirst.frc.team5892.robot.auton;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.CommandGroup;
import org.usfirst.frc.team5892.robot.subsystems.elevator.RunElevator;
import org.usfirst.frc.team5892.robot.subsystems.intake.RunIntake;

import static org.usfirst.frc.team5892.robot.MathUtils.encoderInches;

public class ForwardToSwitchAuto extends DynamicAuton {

    @Override
    public boolean isCompatible(char pos) {
        return true;
    }

    @Override
    protected Command buildCommand(char pos, String gameData) {
        return new ForwardToSwitchAutoCG(pos, gameData);
    }

    private class ForwardToSwitchAutoCG extends CommandGroup {
        ForwardToSwitchAutoCG(char pos, String gameData) {
            char switchPos = gameData.charAt(0);
            if (pos == 'C') {
                if (switchPos == 'L') {
                    addSequential(new AutoStraightDrive(0.6, 0, encoderInches(15)));
                    addSequential(new AutoGyroRotate(-45));
                    addSequential(new AutoStraightDrive(0.6, -45, encoderInches(75)));
                    addSequential(new AutoGyroRotate(0));
                    addSequential(new RunElevator(1), 1.25);
                    addSequential(new AutoStraightDrive(0.6, 0, encoderInches(30)), 2);
                    addSequential(new RunIntake(0.8), 1);
                } else {
                    addSequential(new AutoStraightDrive(0.6, 0, encoderInches(15)));
                    addSequential(new AutoGyroRotate(20));
                    addSequential(new AutoStraightDrive(0.6, 20, encoderInches(75)));
                    addSequential(new AutoGyroRotate(0));
                    addSequential(new RunElevator(1), 1.25);
                    addSequential(new AutoStraightDrive(0.6, 0, encoderInches(30)), 2);
                    addSequential(new RunIntake(0.8), 1);
                }
            } else if (pos == switchPos) {
                addSequential(new AutoStraightDrive(0.6, 0, encoderInches(100)), 5);
                addSequential(new RunIntake(0.8), 1);
            } else {
                addSequential(new AutoStraightDrive(0.6, 0, encoderInches(100)), 5);
            }
        }
    }
}
