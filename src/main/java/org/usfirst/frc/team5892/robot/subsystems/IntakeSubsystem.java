package org.usfirst.frc.team5892.robot.subsystems;

import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj.SpeedControllerGroup;
import edu.wpi.first.wpilibj.command.Subsystem;
import org.usfirst.frc.team5892.robot.Robot;
import org.usfirst.frc.team5892.robot.commands.IntakeMotorControl;

public class IntakeSubsystem extends Subsystem {
    private final SpeedControllerGroup motors;
    private final Solenoid[] pistons;
    private final boolean[] extended;
    
    public IntakeSubsystem() {
        motors = new SpeedControllerGroup(Robot.map.intakeMotor1.makeVictor(), Robot.map.intakeMotor2.makeVictor());
        pistons = new Solenoid[] {new Solenoid(Robot.map.piston1), new Solenoid(Robot.map.piston2), new Solenoid(Robot.map.piston3)};
        extended = new boolean[] {false, false, false};
        addChild(motors);
        addChild(pistons[0]);
        addChild(pistons[1]);
        addChild(pistons[2]);
    }
    
    @Override
    protected void initDefaultCommand() {
        setDefaultCommand(new IntakeMotorControl());
    }

    public void setMotors(double power) {
        motors.set(power);
    }
    
    public void toggle(int index) {
        extended[index] = !extended[index];
        pistons[index].set(extended[index]);
    }
}
