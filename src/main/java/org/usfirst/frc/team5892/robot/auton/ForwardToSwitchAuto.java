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
        CommandGroup ret = new CommandGroup();
        char switchPos = gameData.charAt(0);
        if (pos == 'C') {
            if (switchPos == 'L') {
                ret.addSequential(new AutoStraightDrive(0.6, 0, encoderInches(15)));
                ret.addSequential(new IntakeAndRotate(-45));
                ret.addSequential(new AutoStraightDrive(0.6, -45, encoderInches(75)));
                ret.addSequential(new IntakeAndRotate(0));
                ret.addSequential(new RunElevator(1), 0.75);
                ret.addSequential(new AutoStraightDrive(0.6, 0, encoderInches(30)), 1);
                ret.addSequential(new RunIntake(0.8), 1);
            } else {
                ret.addSequential(new AutoStraightDrive(0.6, 0, encoderInches(15)));
                ret.addSequential(new IntakeAndRotate(25));
                ret.addSequential(new AutoStraightDrive(0.6, 25, encoderInches(75)));
                ret.addSequential(new IntakeAndRotate(10), 0.25);
                ret.addSequential(new RunElevator(1), 0.75);
                ret.addSequential(new AutoStraightDrive(0.6, 10, encoderInches(30)), 1);
                ret.addSequential(new RunIntake(0.8), 1);
            }
        } else if (pos == switchPos) {
            ret.addSequential(new AutoStraightDrive(0.6, 0, encoderInches(100)), 5);
            ret.addSequential(new RunIntake(0.8), 1);
        } else {
            ret.addSequential(new AutoStraightDrive(0.6, 0, encoderInches(100)), 5);
        }
        return ret;
    }
}
