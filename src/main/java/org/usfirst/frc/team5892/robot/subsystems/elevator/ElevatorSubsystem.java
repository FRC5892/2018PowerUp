package org.usfirst.frc.team5892.robot.subsystems.elevator;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;
import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj.SendableBase;
import edu.wpi.first.wpilibj.SpeedController;
import edu.wpi.first.wpilibj.SpeedControllerGroup;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.livewindow.LiveWindow;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import org.usfirst.frc.team5892.robot.Robot;

public class ElevatorSubsystem extends Subsystem {
    public static final double MOTOR_POWER = 0.7;

    private final SpeedController motor;

    public ElevatorSubsystem() {
        WPI_TalonSRX talon = new WPI_TalonSRX(Robot.map.elevatorTalon.port);
        talon.setInverted(Robot.map.elevatorTalon.inverted);
        motor = new SpeedControllerGroup(talon, Robot.map.elevatorOtherMotor.makeVictor());
        addChild((SendableBase) motor); // why the hell do I have to cast you to a SendableBase for addChild to figure out that you are a Sendable. this is stupid and dumb.
    }

    @Override
    protected void initDefaultCommand() {
        setDefaultCommand(new ElevatorControl());
    }

    public void setMotorPower(double power) {
        motor.set(power * MOTOR_POWER);
    }
}
