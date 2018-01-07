package org.usfirst.frc.team5892.HEROcode.sensormap;

/**
 * Do... do functional interfaces even need Javadoc?
 * 
 * @author Kai Page
 */
@FunctionalInterface
public interface SensorGetter {
	/** @return a double, usually corresponding to the value of a sensor (hence, SensorGetter) */
    public double getValue();
}
