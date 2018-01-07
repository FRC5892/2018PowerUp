package org.usfirst.frc.team5892.HEROcode.pid;

import java.io.IOException;
import java.util.logging.Level;

import org.usfirst.frc.team5892.HEROcode.logging.RIOLogger;

/**
 * Like {@link HEROicPIDController}... but it logs input/output. What a stunningly unexpected realization.
 * 
 * @author Kai Page
 * @see {@link RIOLogger}
 */
public abstract class LoggingHEROicPIDController extends HEROicPIDController {
    
	private RIOLogger logger;
	
	/**
	 * @param Kp Proportional
	 * @param Ki Integral
	 * @param Kd Derivative
	 * @param name Logging is output to name.txt on the RoboRIO. (Is output the past tense of output? I guess it sounds better than outputted...) (Also is that past tense or like future perfect or something.)
	 */
	public LoggingHEROicPIDController(double Kp, double Ki, double Kd, String name) {
		super(Kp, Ki, Kd);
		logger = new RIOLogger(name, Level.INFO);
		try {
			logger.setup();
		} catch (IOException e) {
			System.out.println("LoggingHEROicPIDController " + name + " has failed to setup!");
		}
		logger.log(Level.WARNING, "New controller initialized");
	}
	
	@Override
	protected void loop() {
		if (m_enabled) {
			double input = getPIDInput();
			double output = compute(input);
			logger.log(Level.INFO, "Input: " + input + "  Output: " + output);
			usePIDOutput(output);
		}
	}
	
	@Override
	public void enable() {
		logger.log(Level.INFO, "Enabled PID controller");
		super.enable();
	}
	
	@Override
	public void disable() {
		logger.log(Level.INFO, "Disabled PID Controller");
		super.disable();
	}

}
