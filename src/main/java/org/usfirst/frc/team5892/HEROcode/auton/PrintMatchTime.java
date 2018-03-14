package org.usfirst.frc.team5892.HEROcode.auton;

import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj.command.InstantCommand;

public class PrintMatchTime extends InstantCommand {
    @Override
    protected void execute() {
        System.out.println(DriverStation.getInstance().getMatchTime());
    }
}
