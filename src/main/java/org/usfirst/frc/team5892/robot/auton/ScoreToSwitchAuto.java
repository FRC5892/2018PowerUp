package org.usfirst.frc.team5892.robot.auton;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.CommandGroup;
import org.usfirst.frc.team5892.robot.MathUtils;

public class ScoreToSwitchAuto implements AutonBuilder {
    private final char position;
    private final int turnMult;

    public ScoreToSwitchAuto(char position) {
        this.position = position;
        turnMult = position == 'L' ? 1 : -1;
    }

    @Override
    public Command buildAuto(String fieldData) {
        return new ScoreToSwitchAutoCG(fieldData);
    }

    private class ScoreToSwitchAutoCG extends CommandGroup {
        ScoreToSwitchAutoCG(String fieldData) {
            if (position == fieldData.charAt(0)) {
                addSequential(new AutoStraightDrive(0.7, MathUtils.inchesToEncoderTicks(77)));
                addSequential(new AutoGyroRotate(90 * turnMult));
                addSequential(new AutoStraightDrive(0.6, MathUtils.inchesToEncoderTicks(12)));
            } else {
                addSequential(new AutoStraightDrive(0.7, MathUtils.inchesToEncoderTicks(168)));
                addSequential(new AutoGyroRotate(90 * turnMult));
            }
        }
    }
}
