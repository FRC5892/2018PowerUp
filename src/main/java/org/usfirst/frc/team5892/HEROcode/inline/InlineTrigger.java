package org.usfirst.frc.team5892.HEROcode.inline;

import edu.wpi.first.wpilibj.buttons.Trigger;

/**
 * A {@link Trigger} that can be written in place, instead of needing its own class. Can also be the result of a bunch of existing triggers being ANDed or ORed together. Convenient for quick additions.
 * 
 * @author Kai Page
 */
public class InlineTrigger extends Trigger {
    
	private final ITriggerGet getter;
	
	/**
	 * Define a trigger based on a Boolean expression.
	 * @param getter Said Boolean expression.
	 */
	public InlineTrigger(ITriggerGet getter) {
		this.getter = getter;
	}
	
	/**
	 * Define a trigger based on one or more (or none, I guess) existing triggers.
	 * @param trueIfAnd_falseIfOr If true, all of the triggers will be ANDed together; otherwise, they will be ORed together.
	 * @param triggers The triggers being combined.
	 */
	public InlineTrigger(boolean trueIfAnd_falseIfOr, Trigger... triggers) {
		if (trueIfAnd_falseIfOr) {
			getter = new ITriggerGet() {
				Trigger[] trigs = triggers;

				@Override
				public boolean get() {
					for (Trigger t : trigs) {
						if (!t.get()) return false;
					} return true;
				}
			};
		} else {
			getter = new ITriggerGet() {
				Trigger[] trigs = triggers;
				
				@Override
				public boolean get() {
					for (Trigger t : trigs) {
						if (t.get()) return true;
					} return false;
				}
			};
		}
	}
	
	@Override
	public boolean get() {
		return getter.get();
	}

}
