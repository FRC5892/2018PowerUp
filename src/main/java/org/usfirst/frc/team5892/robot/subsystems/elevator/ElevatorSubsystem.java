package org.usfirst.frc.team5892.robot.subsystems.elevator;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;
import edu.wpi.first.wpilibj.*;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.livewindow.LiveWindow;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import org.usfirst.frc.team5892.robot.MathUtils;
import org.usfirst.frc.team5892.robot.Robot;

public class ElevatorSubsystem extends Subsystem {
    public static final double UP_POWER = 0.75
            ;
    public static final double DOWN_POWER = 0.01;

    private final SpeedController motor;

    public ElevatorSubsystem() {
        WPI_TalonSRX talon = new WPI_TalonSRX(Robot.map.elevatorTalon.port);
        talon.setInverted(Robot.map.elevatorTalon.inverted);
        motor = new SpeedControllerGroup(talon, Robot.map.elevatorOtherMotor.makeVictor());
        addChild((Sendable) motor); // why do i have to use a cast. just why.
    }

    @Override
    protected void initDefaultCommand() {
        setDefaultCommand(new ElevatorControl());
    }

    public void setMotorPower(double power) {
        motor.set(power * UP_POWER);
    }
}
