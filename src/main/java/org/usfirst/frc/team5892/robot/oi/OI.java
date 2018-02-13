package org.usfirst.frc.team5892.robot.oi;

import org.usfirst.frc.team5892.robot.subsystems.elevator.DecrementElevatorTarget;
import org.usfirst.frc.team5892.robot.subsystems.elevator.IncrementElevatorTarget;
import org.usfirst.frc.team5892.robot.subsystems.intake.IntakeToggle;

public class OI {
    public PlayerOne player1;
    public PlayerTwo player2;

    public OI(PlayerOne player_1, PlayerTwo player_2) {
        player1 = player_1;
        player2 = player_2;

        // Player 1 commands

        // Player 2 commands
        player2.intakeToggle().whenActive(new IntakeToggle());
        player2.elevatorUp().whenActive(new IncrementElevatorTarget());
        player2.elevatorDown().whenActive(new DecrementElevatorTarget());
    }
}
