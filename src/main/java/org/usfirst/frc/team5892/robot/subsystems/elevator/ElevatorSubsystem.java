package org.usfirst.frc.team5892.robot.subsystems.elevator;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;
import edu.wpi.first.wpilibj.*;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.livewindow.LiveWindow;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import org.usfirst.frc.team5892.HEROcode.inline.InlineTrigger;
import org.usfirst.frc.team5892.robot.MathUtils;
import org.usfirst.frc.team5892.robot.Robot;

public class ElevatorSubsystem extends Subsystem {
    public static final double UP_POWER = 0.75;
    public static final double DOWN_POWER = -0.2;

    private final SpeedController motor;
    private final DigitalInput limitSwitch;

    public ElevatorSubsystem() {
        WPI_TalonSRX talon = new WPI_TalonSRX(Robot.map.elevatorTalon.port);
        talon.setInverted(Robot.map.elevatorTalon.inverted);
        motor = new SpeedControllerGroup(talon, Robot.map.elevatorOtherMotor.makeVictor());
        limitSwitch = new DigitalInput(Robot.map.elevatorLimitSwitch);
        addChild("Motor", (Sendable) motor); // why do i have to use a cast. just why.
        addChild("Limit Switch", limitSwitch);
    }

    @Override
    protected void initDefaultCommand() {
        setDefaultCommand(new ElevatorControl());
        new InlineTrigger(limitSwitch::get).whenInactive(new LimitSwitchSafetyStop(3));
    }

    public void setMotorPower(double power) {
        motor.set(power);
    }
}
