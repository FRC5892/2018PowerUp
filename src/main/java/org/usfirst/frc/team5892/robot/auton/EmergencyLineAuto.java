package org.usfirst.frc.team5892.robot.auton;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.CommandGroup;

import static org.usfirst.frc.team5892.robot.MathUtils.encoderInches;

public class EmergencyLineAuto extends DynamicAuton {

    @Override
    protected Command buildCommand(char pos, String gameData) {
        return new AutoStraightDrive(0.6, 0, encoderInches(124), 3);
    }
}
