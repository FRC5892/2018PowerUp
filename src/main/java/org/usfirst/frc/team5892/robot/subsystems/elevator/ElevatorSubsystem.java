package org.usfirst.frc.team5892.robot.subsystems.elevator;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;
import edu.wpi.first.wpilibj.*;
import edu.wpi.first.wpilibj.command.Subsystem;
import org.usfirst.frc.team5892.robot.MathUtils;
import org.usfirst.frc.team5892.robot.Robot;

public class ElevatorSubsystem extends Subsystem {
    public static final double UP_POWER = 0.85;
    public static final double DOWN_POWER = 0.4;

    private final SpeedController motor;
    private final DigitalInput highSwitch, lowSwitch;
    private final Solenoid brake;

    public ElevatorSubsystem() {
        WPI_TalonSRX talon = new WPI_TalonSRX(Robot.map.elevatorTalon.port);
        talon.setInverted(Robot.map.elevatorTalon.inverted);
        motor = new SpeedControllerGroup(talon, Robot.map.elevatorOtherMotor.makeVictor());
        highSwitch = new DigitalInput(Robot.map.elevatorHighSwitch);
        lowSwitch = new DigitalInput(Robot.map.elevatorLowSwitch);
        brake = new Solenoid(Robot.map.elevatorBrake);
        addChild("Winch", (Sendable) motor);
        addChild("High Limit Switch", highSwitch); addChild("Low Limit Switch", lowSwitch);
        addChild("Brake", brake);
    }

    @Override
    protected void initDefaultCommand() {
        setDefaultCommand(new ElevatorControl());
        //new InlineTrigger(highSwitch::get).whenInactive(new LimitSwitchSafetyStop(1));
        //new InlineTrigger(lowSwitch::get).whenInactive(new LimitSwitchSafetyStop(1));
    }

    public void setMotorPower(double power) {
        if (Math.abs(power) > 0.05) {
            motor.set(-MathUtils.scalePlusMinus(power, DOWN_POWER, UP_POWER));
            brake.set(false);
        } else {
            motor.set(0);
            brake.set(true);
        }
    }
}
