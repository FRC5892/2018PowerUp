package org.usfirst.frc.team5892.robot.auton;

import edu.wpi.first.wpilibj.command.Command;

import static org.usfirst.frc.team5892.robot.MathUtils.encoderInches;

public class EmergencyLineAuto extends DynamicAuton {

    @Override
    protected Command buildCommand(char pos, String gameData) {
        return new AutoTankDrive(0.8, 0.8, encoderInches(124), 2);
    }
}
