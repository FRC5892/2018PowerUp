package org.usfirst.frc.team5892.robot.oi;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.JoystickButton;
import edu.wpi.first.wpilibj.buttons.Trigger;
import org.usfirst.frc.team5892.robot.subsystems.elevator.ElevatorSubsystem;

public class GuitarHeroPlayerTwo implements PlayerTwo {
    private final Joystick guitar;
    public GuitarHeroPlayerTwo(int port) {
        guitar = new Joystick(port);
    }

    @Override
    public double intake() {
        if (guitar.getRawButton(1)) return 1;
        if (guitar.getRawButton(2)) return -0.5;
        if (guitar.getRawButton(3)) return -1;
        return 0;
    }

    @Override
    public double elevator() {
        switch (guitar.getPOV()) {
            case 0:
                return ElevatorSubsystem.UP_POWER;
            case 180:
                return -ElevatorSubsystem.DOWN_POWER;
            default:
                return 0;
        }
    }

    @Override
    public Trigger batwingLeft() {
        return new JoystickButton(guitar, 7);
    }

    @Override
    public Trigger batwingRight() {
        return new JoystickButton(guitar, 8);
    }
}
