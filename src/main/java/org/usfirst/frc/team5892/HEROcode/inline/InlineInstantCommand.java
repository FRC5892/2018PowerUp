package org.usfirst.frc.team5892.HEROcode.inline;

import edu.wpi.first.wpilibj.command.InstantCommand;

/**
 * An {@link InstantCommand} that runs a {@link Runnable}.
 * @author Kai Page
 */
public class InlineInstantCommand extends InstantCommand {
    private final Runnable cmd;

    /**
     * @param cmd The {@link Runnable} to be run.
     */
    public InlineInstantCommand(Runnable cmd) {
        this.cmd = cmd;
    }

    @Override
    protected void execute() {
        cmd.run();
    }
}
