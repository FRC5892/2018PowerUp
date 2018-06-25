package org.usfirst.frc.team5892.robot.auton;

import edu.wpi.first.wpilibj.command.Command;
import org.usfirst.frc.team5892.HEROcode.inline.ICGEntry;
import org.usfirst.frc.team5892.HEROcode.inline.InlineCommandGroup;

// special one-off request from 624
public class CryptonitePassthruAuto extends DynamicAuton {

    private DynamicAuton stsa = new EmergencyLineAuto();

    @Override
    protected Command buildCommand(char pos, String gameData) {
        return new InlineCommandGroup(
                new ICGEntry(new WaitCommand(11), false),
                new ICGEntry(stsa.buildCommand(pos, gameData), false)
        );
    }
}
