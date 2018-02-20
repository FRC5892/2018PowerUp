package org.usfirst.frc.team5892.robot.subsystems.elevator;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;
import edu.wpi.first.wpilibj.SpeedController;
import edu.wpi.first.wpilibj.command.Subsystem;
import org.usfirst.frc.team5892.robot.Robot;

public class ElevatorSubsystem extends Subsystem {
    public static final double MOTOR_POWER = 0.3;

    private final SpeedController motor;

    public ElevatorSubsystem() {
        motor = new WPI_TalonSRX(Robot.map.elevatorMotor.port);
        motor.setInverted(Robot.map.elevatorMotor.inverted);
        addChild(motor);
    }

    @Override
    protected void initDefaultCommand() {
        setDefaultCommand(new ElevatorControl());
    }

    public void setMotorPower(double power) {
        motor.set(power);
    }
}
