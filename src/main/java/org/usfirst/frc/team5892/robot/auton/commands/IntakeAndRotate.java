package org.usfirst.frc.team5892.robot.auton.commands;

import edu.wpi.first.wpilibj.command.CommandGroup;
import org.usfirst.frc.team5892.robot.subsystems.intake.RunIntake;

public class IntakeAndRotate extends CommandGroup {
    public IntakeAndRotate(double targetAngle) {
        addParallel(new RunIntake(-0.8));
        addSequential(new WaitCommand(0.125));
        addSequential(new AutoGyroRotate(targetAngle));
        addSequential(new RunIntake(0), 0);
    }

    public IntakeAndRotate(double targetAngle, double turnMult) {
        addParallel(new RunIntake(-0.8));
        addSequential(new WaitCommand(0.125));
        addSequential(new AutoGyroRotate(targetAngle, turnMult));
        addSequential(new RunIntake(0), 0);
    }
}
