package org.usfirst.frc.team5892.robot.auton;

import edu.wpi.first.wpilibj.command.CommandGroup;
import org.usfirst.frc.team5892.robot.subsystems.elevator.RunElevator;
import org.usfirst.frc.team5892.robot.subsystems.intake.StartIntaking;

public class IntakeShakedown extends CommandGroup {
    public IntakeShakedown() {
        addParallel(new StartIntaking());
        addSequential(new RunElevator(1), 0.25);
    }
}
