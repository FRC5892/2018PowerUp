package org.usfirst.frc.team5892.robot.auton;

import edu.wpi.first.wpilibj.command.CommandGroup;
import org.usfirst.frc.team5892.robot.subsystems.elevator.RunElevator;

public class IntakeShakedown extends CommandGroup {
    public IntakeShakedown() {
        //addParallel(new RunIntake(-1, true), 0.25);
        addSequential(new RunElevator(1), 0.25);
    }
}
