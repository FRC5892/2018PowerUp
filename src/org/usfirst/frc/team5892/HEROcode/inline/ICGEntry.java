package org.usfirst.frc.team5892.HEROcode.inline;

import edu.wpi.first.wpilibj.command.Command;

/**
 * An entry in an {@link InlineCommandGroup}.
 * 
 * @author Kai Page
 */
public class ICGEntry {
	final Command command;
	final boolean parallel;
	
	/**
	 * @param command The command to be run.
	 * @param parallel If true, will be scheduled with addParallel; otherwise, will be scheduled with addSequential.
	 * @see {@link edu.wpi.first.wpilibj.commmand.CommandGroup CommandGroup}
	 */
	public ICGEntry(Command command, boolean parallel) {
		this.command = command;
		this.parallel = parallel;
	}
}