package org.usfirst.frc.team5892.robot.oi;

import org.usfirst.frc.team5892.robot.Robot;
import org.usfirst.frc.team5892.robot.subsystems.intake.*;
import org.usfirst.frc.team5892.robot.subsystems.elevator.*;
import org.usfirst.frc.team5892.robot.subsystems.batwing.*;

public class OI {
    public final PlayerOne player1;
    public final PlayerTwo player2;

    public OI(PlayerOne player_1, PlayerTwo player_2) {
        player1 = player_1;
        player2 = player_2;

        // Player 1 commands
        player1.intakeToggle().whenActive(new IntakeToggle());

        // Player 2 commands
        player2.intakeOverride().whenActive(new ToggleIntakeOverride());

        player2.elevatorUp().whenActive(new IncrementElevatorTarget());
        player2.elevatorDown().whenActive(new DecrementElevatorTarget());
        player2.elevatorOverride().whenActive(new ToggleElevatorOverride());

        player2.batwingLeft().whenActive(new BatwingActivate(Robot.batwings.left));
        player2.batwingRight().whenActive(new BatwingActivate(Robot.batwings.right));
    }
}
