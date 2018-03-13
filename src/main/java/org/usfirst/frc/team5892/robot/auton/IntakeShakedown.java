package org.usfirst.frc.team5892.robot.auton;

import edu.wpi.first.wpilibj.command.CommandGroup;
import org.usfirst.frc.team5892.robot.MathUtils;
import org.usfirst.frc.team5892.robot.subsystems.intake.StartIntaking;

public class IntakeShakedown extends CommandGroup {
    public IntakeShakedown() {
        addParallel(new StartIntaking());
        addSequential(new AutoStraightDrive(1, 0, MathUtils.encoderInches(3)));
        addSequential(new AutoStraightDrive(-1, 0, MathUtils.encoderInches(3)));
    }
}
