package org.usfirst.frc.team5892.robot.subsystems.elevator;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;
import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.SpeedController;
import edu.wpi.first.wpilibj.Victor;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import org.usfirst.frc.team5892.HEROcode.inline.InlineTrigger;
import org.usfirst.frc.team5892.robot.Robot;
import org.usfirst.frc.team5892.robot.subsystems.elevator.ElevatorMovement;
import org.usfirst.frc.team5892.robot.subsystems.elevator.SwitchPressHandler;

public class ElevatorSubsystem extends Subsystem {
    public static final double MOTOR_POWER = 0.3;

    private final SpeedController motor;
    private final DigitalInput[] switches;
    private int lastPressed = -1;
    private int target = 0;
    private boolean pressedSinceTargetChange = false;
    private Movement movement;

    public boolean override = false;

    public ElevatorSubsystem() {
        motor = new WPI_TalonSRX(Robot.map.elevatorMotor.port);
        motor.setInverted(Robot.map.elevatorMotor.inverted);
        switches = new DigitalInput[Robot.map.elevatorSwitches.length];
        for (int i=0; i<Robot.map.elevatorSwitches.length; i++) {
            switches[i] = new DigitalInput(Robot.map.elevatorSwitches[i]);
        }
    }

    @Override
    protected void initDefaultCommand() {
        setDefaultCommand(new ElevatorMovement());
        for (int i=0; i<switches.length; i++) {
            int idx = i;
            new InlineTrigger(() -> switches[idx].get()).whenActive(new SwitchPressHandler(idx));
        }
    }

    public int getLastPressed() {
        return lastPressed;
    }

    public void setLastPressed(int pressed) {
        lastPressed = pressed;
        pressedSinceTargetChange = true;
    }

    public int getTarget() {
        return target;
    }

    public void setTarget(int newTarget) {
        if (target == newTarget) return; // bad things might happen otherwise.
        target = newTarget;
        pressedSinceTargetChange = false;
    }

    public boolean isPressedSinceTargetChange() {
        return pressedSinceTargetChange;
    }

    public Movement getMovement() {
        return movement;
    }

    public void setMovement(Movement newMovement) {
        movement = newMovement;
        motor.set(newMovement._power);
    }

    @Override
    public void periodic() {
        SmartDashboard.putBoolean("Elevator Override", override);
        if (override) {
            motor.set(Robot.m_oi.player2.manualElevator());
        }
        SmartDashboard.putNumber("Elevator Target", target);
    }

    public enum Movement {
        UP(MOTOR_POWER),
        DOWN(-MOTOR_POWER),
        STOPPED(0);

        private final double _power;
        Movement(double power) {
            _power = power;
        }
    }
}
