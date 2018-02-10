package org.usfirst.frc.team5892.robot.subsystems;

import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.Victor;
import edu.wpi.first.wpilibj.command.InstantCommand;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import org.usfirst.frc.team5892.HEROcode.inline.InlineTrigger;
import org.usfirst.frc.team5892.robot.Robot;
import org.usfirst.frc.team5892.robot.commands.elevator.ElevatorMovement;
import org.usfirst.frc.team5892.robot.commands.elevator.SwitchPressHandler;

public class ElevatorSubsystem extends Subsystem {
    public static final double MOTOR_POWER = 0.8;

    private final Victor motor;
    private final DigitalInput[] switches;
    public int lastPressed = -1;
    public int target = 0;

    public ElevatorSubsystem() {
        motor = Robot.map.elevatorMotor.makeVictor();
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

    public void setMotor(double power) {
        motor.set(power);
    }

    @Override
    public void periodic() {
        SmartDashboard.putNumber("Elevator Target", target);
    }
}
