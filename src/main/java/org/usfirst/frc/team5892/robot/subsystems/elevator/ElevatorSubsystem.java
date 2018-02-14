package org.usfirst.frc.team5892.robot.subsystems.elevator;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.FeedbackDevice;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import org.usfirst.frc.team5892.robot.Robot;

public class ElevatorSubsystem extends Subsystem {
    /* FIXME needs to be tuned... still waiting for the no-kay on limit switches */
    private static final double kP = 0;
    private static final double kI = 0;
    private static final double kD = 0;
    static final double[] positions = {0};

    private final WPI_TalonSRX motor;
    private static final int talonPIDid = 0;
    private static final int talonTimeout = 10;
    private static final boolean talonSPhase = false;
    private int target = 0;

    public boolean override = false;

    public ElevatorSubsystem() {
        motor = new WPI_TalonSRX(Robot.map.elevatorMotor.port);
        motor.setInverted(Robot.map.elevatorMotor.inverted);

        motor.configSelectedFeedbackSensor(FeedbackDevice.QuadEncoder, talonPIDid, talonTimeout);
        motor.setSensorPhase(talonSPhase);
        motor.configNominalOutputForward(0, talonTimeout);
        motor.configNominalOutputReverse(0, talonTimeout);
        motor.configPeakOutputForward(1, talonTimeout);
        motor.configPeakOutputReverse(-1, talonTimeout);
        motor.configAllowableClosedloopError(talonPIDid, 10, talonTimeout);

        motor.config_kP(talonPIDid, kP, talonTimeout);
        motor.config_kI(talonPIDid, kI, talonTimeout);
        motor.config_kD(talonPIDid, kD, talonTimeout);
        motor.config_kF(talonPIDid, 0, talonTimeout);

        motor.setSelectedSensorPosition(0, talonPIDid, talonTimeout);
    }

    @Override
    protected void initDefaultCommand() {

    }

    public int getTarget() {
        return target;
    }

    public void setTarget(int newTarget) {
        target = newTarget;
        motor.set(ControlMode.Position, positions[newTarget]);
    }

    @Override
    public void periodic() {
        SmartDashboard.putBoolean("Elevator Override", override);
        if (override) {
            motor.set(Robot.m_oi.player2.manualElevator());
        }
        SmartDashboard.putNumber("Elevator Target", target);
    }
}
