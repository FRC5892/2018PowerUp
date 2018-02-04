package org.usfirst.frc.team5892.robot.commands; 
 
import edu.wpi.first.wpilibj.command.Command;
import org.usfirst.frc.team5892.robot.Robot;

public class ParanoiaFreeze extends Command {

    public ParanoiaFreeze() {
        requires(Robot.driveSubsystem);
    }
 
    @Override 
    protected void execute() {
        Robot.driveSubsystem.reset();
    } 
 
    @Override 
    protected boolean isFinished() { 
        return false;
    } 
} 
