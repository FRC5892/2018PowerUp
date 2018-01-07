package org.usfirst.frc.team5892.HEROcode.auton;

import java.util.function.Predicate;

import edu.wpi.first.wpilibj.command.Command;

/**
 * A {@link Command} that schedules another Command based on a {@link Predicate}. Useful for autonomous, to schedule another {@link edu.wpi.first.wpilibj.command.CommandGroup CommandGroup} at the end of yours.
 * 
 * @author Kai Page
 *
 */
public class BranchCommand extends Command {
	private final Predicate<Void> _condition;
	private final Command _ifTrue;
	private final Command _ifFalse;
	
	public BranchCommand(Predicate<Void> condition, Command ifTrue, Command ifFalse) {
		_condition = condition;
		_ifTrue = ifTrue;
		_ifFalse = ifFalse;
	}
	
	@Override
	public void execute() {
		if (_condition.test(null))  _ifTrue.start();
		else _ifFalse.start();
	}

	@Override
	protected boolean isFinished() {
		return true;
	}

}
