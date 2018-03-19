package org.usfirst.frc.team5892.robot.subsystems.elevator;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;
import edu.wpi.first.wpilibj.*;
import edu.wpi.first.wpilibj.buttons.Trigger;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.livewindow.LiveWindow;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import org.usfirst.frc.team5892.HEROcode.inline.InlineTrigger;
import org.usfirst.frc.team5892.robot.MathUtils;
import org.usfirst.frc.team5892.robot.Robot;

public class ElevatorSubsystem extends Subsystem {
    public static final double UP_POWER = 0.85;
    public static final double DOWN_POWER = 0.4;

    private final SpeedController motor;
    private final DigitalInput highSwitch, lowSwitch;

    public ElevatorSubsystem() {
        WPI_TalonSRX talon = new WPI_TalonSRX(Robot.map.elevatorTalon.port);
        talon.setInverted(Robot.map.elevatorTalon.inverted);
        motor = new SpeedControllerGroup(talon, Robot.map.elevatorOtherMotor.makeVictor());
        highSwitch = new DigitalInput(Robot.map.elevatorHighSwitch);
        lowSwitch = new DigitalInput(Robot.map.elevatorLowSwitch);
        addChild("Winch", (Sendable) motor);
        addChild("High Limit Switch", highSwitch); addChild("Low Limit Switch", lowSwitch);
    }

    @Override
    protected void initDefaultCommand() {
        setDefaultCommand(new ElevatorControl());
        //new InlineTrigger(highSwitch::get).whenInactive(new LimitSwitchSafetyStop(1));
        //new InlineTrigger(lowSwitch::get).whenInactive(new LimitSwitchSafetyStop(1));
    }

    public void setMotorPower(double power) {
        motor.set(-MathUtils.scalePlusMinus(power, DOWN_POWER, UP_POWER));
    }
}
