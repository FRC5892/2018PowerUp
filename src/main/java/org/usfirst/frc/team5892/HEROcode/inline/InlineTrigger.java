package org.usfirst.frc.team5892.HEROcode.inline;

import edu.wpi.first.wpilibj.buttons.Trigger;

import java.util.function.BooleanSupplier;

/**
 * A {@link Trigger} that can be written in place, instead of needing its own class. Can also be the result of a bunch of existing triggers being ANDed or ORed together. Convenient for quick additions.
 * 
 * @author Kai Page
 */
public class InlineTrigger extends Trigger {
    
	private final BooleanSupplier getter;
	
	/**
	 * Define a trigger based on a Boolean expression.
	 * @param getter Said Boolean expression.
	 */
	public InlineTrigger(BooleanSupplier getter) {
		this.getter = getter;
	}
	
	/**
	 * Define a trigger based on one or more existing triggers.
	 * @param requireAllTrue If true, all of the triggers will be ANDed together; otherwise, they will be ORed together.
	 * @param triggers The triggers being combined.
	 */
	public InlineTrigger(boolean requireAllTrue, Trigger... triggers) {
		if (requireAllTrue) {
			getter = () -> {
				for (Trigger t : triggers)
					if (!t.get()) return false;
				return true;
			};
		} else {
			getter = () -> {
				for (Trigger t : triggers)
					if (t.get()) return true;
				return false;
			};
		}
	}
	
	@Override
	public boolean get() {
		return getter.getAsBoolean();
	}

}
