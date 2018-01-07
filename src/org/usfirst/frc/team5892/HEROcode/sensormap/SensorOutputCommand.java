package org.usfirst.frc.team5892.HEROcode.sensormap;

import java.util.Vector;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 * The command used to automatically put sensors on the SmartDashboard.
 * 
 * @author Kai Page
 */
class SensorOutputCommand extends Command {
    static Vector<Sensor> sensors = new Vector<>();
    static {
    	new SensorOutputCommand().start();
    }
	
	SensorOutputCommand() {
		setRunWhenDisabled(true);
		setInterruptible(false);
	}
	
	@Override
	protected void execute() {
		for (Sensor s : sensors) {
			SmartDashboard.putNumber(s.getName(), s.getValue());
		}
	}
	
	@Override
	protected boolean isFinished() {
		return false;
	}

}
