package org.usfirst.frc.team5892.HEROcode.inline;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 * A {@link CommandGroup} that can be written in place, instead of needing its own class. Convenient for one-off tests.
 * 
 * @author Kai Page
 * @see {@link ICGEntry}
 */
public class InlineCommandGroup extends CommandGroup {
	/**
	 * @param entries The list of commands to be run and how to schedule them.
	 */
    public InlineCommandGroup(ICGEntry... entries) {
    	for (ICGEntry e : entries) {
    		if (e.parallel) addParallel(e.command);
    		else addSequential(e.command);
    	}
    }
}
