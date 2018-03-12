package org.usfirst.frc.team5892.robot.subsystems.intake;

import edu.wpi.first.wpilibj.command.Command;
import org.usfirst.frc.team5892.robot.Robot;

class IntakeRegulate extends Command {

    IntakeRegulate() {
        requires(Robot.intake);
    }

    @Override
    protected void execute() {
        if (Robot.intake.intaking && !Robot.intake.isButtonPressed()) Robot.intake.setMotorPower(1);
        else if (Robot.intake.intaking) Robot.intake.setMotorPower(0.3);
        else Robot.intake.setMotorPower(0);
    }

    @Override
    protected boolean isFinished() {
        return false;
    }
}
