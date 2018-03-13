package org.usfirst.frc.team5892.robot.oi;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.JoystickButton;
import edu.wpi.first.wpilibj.buttons.Trigger;
import org.usfirst.frc.team5892.robot.subsystems.elevator.ElevatorSubsystem;

public class GuitarHeroPlayerTwo {
    private final Joystick guitar;
    public GuitarHeroPlayerTwo(int port) {
        guitar = new Joystick(port);
    }

    //@Override
    public Trigger intake() {
        return new JoystickButton(guitar, 1);
    }

    //@Override
    public Trigger outtake() {
        return new JoystickButton(guitar, 2);
    }

    //@Override
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

    //@Override
    public Trigger batwingLeft() {
        return new JoystickButton(guitar, 7);
    }

    //@Override
    public Trigger batwingRight() {
        return new JoystickButton(guitar, 8);
    }
}
