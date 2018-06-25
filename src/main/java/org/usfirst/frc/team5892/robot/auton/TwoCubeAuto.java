package org.usfirst.frc.team5892.robot.auton;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.CommandGroup;
import org.usfirst.frc.team5892.robot.auton.commands.AutoStraightDrive;
import org.usfirst.frc.team5892.robot.auton.commands.IntakeAndRotate;
import org.usfirst.frc.team5892.robot.subsystems.elevator.RunElevator;
import org.usfirst.frc.team5892.robot.subsystems.intake.RunIntake;

import static org.usfirst.frc.team5892.robot.MathUtils.encoderInches;

public class TwoCubeAuto extends DynamicAuton {

    @Override
    public boolean isCompatible(char pos) {
        return pos != 'C';
    }

    @Override
    protected Command buildCommand(char pos, String gameData) {
        CommandGroup ret = new CommandGroup();
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
                ret.addSequential(new AutoStraightDrive(0.7, 0, encoderInches(304)));
                ret.addSequential(new IntakeAndRotate(90 * turnDir));
                ret.addSequential(new RunElevator(0.5), 4);
                ret.addSequential(new RunIntake(0.8), 0.5);
                ret.addSequential(new RunElevator(-0.1), 1);
                ret.addSequential(new IntakeAndRotate(159 * turnDir));
                ret.addParallel(new RunIntake(-0.6), 3);
                ret.addSequential(new AutoStraightDrive(0.7, 159 * turnDir, encoderInches(101)));
                ret.addSequential(new RunElevator(0.5), 2);
                ret.addSequential(new RunIntake(0.8), 0.5);
                break;

        }
        return ret;
    }
}
