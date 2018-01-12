package org.usfirst.frc.team5892.robot.commands.auton;

import edu.wpi.first.wpilibj.command.Command;

public interface AutonBuilder {
    Command buildAuto(String fieldData);
}
