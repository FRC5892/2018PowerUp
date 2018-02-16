package org.usfirst.frc.team5892.robot.subsystems.spartantest;

import edu.wpi.first.wpilibj.ADXRS450_Gyro;
import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.DigitalOutput;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import org.usfirst.frc.team5892.robot.oi.JoystickPlayerOne;
import org.usfirst.frc.team5892.robot.oi.PlayerOne;

public class SpartanBoardTestSubsystem extends Subsystem {

    private final DigitalInput regularInput;
    private final DigitalInput extendedInput;
    private final DigitalOutput regularOutput;
    private final DigitalOutput extendedOutput;
    private final ADXRS450_Gyro gyro;

    public SpartanBoardTestSubsystem() {
        regularInput = new DigitalInput(2);
        extendedInput = new DigitalInput(22);
        regularOutput = new DigitalOutput(3);
        extendedOutput = new DigitalOutput(23);
        SmartDashboard.putNumber("I Exist", 5892);
        gyro = new ADXRS450_Gyro();

        addChild(regularInput); addChild(extendedInput);
        addChild(regularOutput); addChild(extendedOutput);
        addChild(gyro);
    }

    @Override
    protected void initDefaultCommand() {
        PlayerOne controller = new JoystickPlayerOne(0);
        controller.intakeToggle().toggleWhenActive(new HoldMyDrink(regularOutput));
        controller.slowMode().toggleWhenActive(new HoldMyDrink(extendedOutput));
    }

    @Override
    public void periodic() {
        /*SmartDashboard.putBoolean("Regular Input", regularInput.get());
        SmartDashboard.putBoolean("Extended Input", extendedInput.get());
        SmartDashboard.putNumber("Gyro Input", gyro.getAngle());*/
    }

    private class HoldMyDrink extends Command {
        DigitalOutput _output;

        HoldMyDrink(DigitalOutput output) {
            _output = output;
        }

        @Override
        protected void initialize() {
            _output.set(true);
        }

        @Override
        protected boolean isFinished() {
            return false;
        }

        @Override
        protected void end() {
            _output.set(false);
        }
    }
}
