package org.usfirst.frc.team5892.HEROcode.pid;

import java.util.Timer;
import java.util.TimerTask;

import edu.wpi.first.wpilibj.PIDInterface;

/**
 * A simple class for implementing PID without the apparently crap WPILib-provided methods.
 * Based on <a href="http://brettbeauregard.com/blog/2011/04/improving-the-beginners-pid-introduction/">http://brettbeauregard.com/blog/2011/04/improving-the-beginners-pid-introduction/</a>
 * 
 * @author Kai Page
 */

public abstract class HEROicPIDController implements PIDInterface {

	protected double m_setpoint;
	protected double m_iTerm, m_lastInput;
	protected double m_Kp, m_Ki, m_Kd;
	/** Sample time in ms. */
	public static final int SAMPLE_TIME = 50;
	protected double m_outMin, m_outMax;
	protected boolean m_minmaxClip = false;
	protected boolean m_enabled = false;

	private TimerTask m_timerTask;
	private Timer m_timer;

	/**
	 * @param Kp The proportional constant.
	 * @param Ki The integral constant.
	 * @param Kd The derivative constant.
	 */
	public HEROicPIDController(double Kp, double Ki, double Kd) {
		setPID(Kp, Ki, Kd);
		m_timerTask = new PIDTimerTask(this);
		m_timer = new Timer(true);
		m_timer.schedule(m_timerTask, SAMPLE_TIME, SAMPLE_TIME);
	}

	/**
	 * This method is called periodically to get the current input value.
	 * @return The current input value.
	 */
	public abstract double getPIDInput();

	/**
	 * This method is called periodically to use the current output value.
	 * @param output The current output value.
	 */
	public abstract void usePIDOutput(double output);

	/**
	 * This method is called periodically. To be more precise, about every {@link SAMPLE_TIME} ms.
	 */
	protected void loop() {
		if (m_enabled) {
			usePIDOutput(compute(getPIDInput()));
		}
	}

	/**
	 * Computes the current output value from the current input value.
	 * @param input The current input value, as returned by {@link getPIDInput}.
	 * @return The current output value, to be used by {@link usePIDOutput}.
	 */
	protected double compute(double input) {
		double error = m_setpoint - input;
		m_iTerm = minmaxClip(m_iTerm + m_Ki * error);
		double dInput = (input - m_lastInput);

		/* Compute PID Output */
		double output = minmaxClip(m_Kp * error + m_iTerm - m_Kd * dInput);

		m_lastInput = input;
		
		return output;
	}

	/**
	 * Sets the current proportional, integral, and derivative constants, respectively.
	 */
	public void setPID(double Kp, double Ki, double Kd) {
		this.m_Kp = Kp;
		this.m_Ki = Ki * SAMPLE_TIME / 1000;
		this.m_Kd = Kd / SAMPLE_TIME / 1000;
	}

	/**
	 * Sets the limits on output for the PID function.
	 */
	public void setOutputLimits(double min, double max) {
		if (min > max)
			return;
		m_minmaxClip = true;
		m_outMin = min;
		m_outMax = max;
	}

	/**
	 * Unsets the limits on output for the PID function.
	 */
	public void resetOutputLimits() {
		m_minmaxClip = false;
	}

	/**
	 * Sets the value towards which the PID function will go.
	 */
	public void setSetpoint(double setpoint) {
		this.m_setpoint = setpoint;
	}

	/**
	 * Enables the controller.
	 */
	public void enable() {
		if (!m_enabled) {
			m_lastInput = getPIDInput();
			m_enabled = true;
			m_iTerm = minmaxClip(m_Ki * compute(m_lastInput));
		}
		m_enabled = true;
	}

	/**
	 * Disables the controller and resets output to 0.
	 */
	public void disable() {
		m_enabled = false;
		usePIDOutput(0);
	}

	/**
	 * Clips value between the current minimum and maximum.
	 * @param value The value to be clipped.
	 * @return The current maximum if value was higher, minimum if lower, value otherwise.
	 */
	public double minmaxClip(double value) {
		if (m_minmaxClip) {
			if (value < m_outMin)
				return m_outMin;
			if (value > m_outMax)
				return m_outMax;
		}
		return value;
	}

	public double getLastInput() {
		return m_lastInput;
	}

	/**
	 * A {@link TimerTask} that runs the PID loop. Hence, PIDTimerTask.
	 * @author Kai Page
	 *
	 */
	protected class PIDTimerTask extends TimerTask {

		HEROicPIDController parent;

		PIDTimerTask(HEROicPIDController parent) {
			this.parent = parent;
		}

		@Override
		public void run() {
			parent.loop();
		}

	}

	@Override
	public double getP() {
		return m_Kp;
	}

	@Override
	public double getI() {
		return m_Ki;
	}

	@Override
	public double getD() {
		return m_Kd;
	}

	@Override
	public double getSetpoint() {
		return m_setpoint;
	}

	@Override
	public double getError() {
		return m_setpoint - m_lastInput;
	}

	@Override
	public boolean isEnabled() {
		return m_enabled;
	}

	@Override
	public void reset() {
		disable();
	}
}
