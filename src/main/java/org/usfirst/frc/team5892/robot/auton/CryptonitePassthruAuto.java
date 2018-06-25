package org.usfirst.frc.team5892.robot.auton;

import edu.wpi.first.wpilibj.command.Command;
import org.usfirst.frc.team5892.HEROcode.inline.CommandGroupBuilder;
import org.usfirst.frc.team5892.robot.auton.commands.WaitCommand;

// special one-off request from 624
public class CryptonitePassthruAuto extends DynamicAuton {

    private DynamicAuton stsa = new EmergencyLineAuto();

    @Override
    protected Command buildCommand(char pos, String gameData) {
        return new CommandGroupBuilder()
                .addSequential(new WaitCommand(11))
                .addSequential(stsa.buildCommand(pos, gameData))
                .getOutput();
    }
}
