package org.usfirst.frc.team5892.robot.auton;

import edu.wpi.first.wpilibj.command.Command;

import static org.usfirst.frc.team5892.robot.MathUtils.encoderInches;

public class EmergencyLineAuto extends DynamicAuton {

    @Override
    public boolean isCompatible(char pos) {
        return true;
    }

    @Override
    protected Command buildCommand(char pos, String gameData) {
        return new AutoTankDrive(0.8, 0.8, Integer.MAX_VALUE, 2);
    }
}
