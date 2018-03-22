package org.usfirst.frc.team5892.robot.subsystems.intake;

import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.Sendable;
import edu.wpi.first.wpilibj.SpeedController;
import edu.wpi.first.wpilibj.command.Subsystem;
import org.usfirst.frc.team5892.robot.MathUtils;
import org.usfirst.frc.team5892.robot.Robot;
import org.usfirst.frc.team5892.robot.RobotMap;

public class IntakeSubsystem extends Subsystem {
    public static final double INTAKE_POWER = 1;
    public static final double OUTTAKE_POWER = 1;

    private final SpeedController wheels;
    private final DigitalInput button;

    public IntakeSubsystem() {
        wheels = RobotMap.makeVictorGroup(Robot.map.intakeMotors);
        button = new DigitalInput(Robot.map.intakeButton);

        addChild("Wheels", (Sendable) wheels);
        addChild("Button", button);
    }


    @Override
    protected void initDefaultCommand() {

    }

    public void setMotorPower(double power) {
        wheels.set(MathUtils.scalePlusMinus(power, INTAKE_POWER, OUTTAKE_POWER));
    }

    public boolean isButtonPressed() {
        return !button.get();
    }
}
