package org.usfirst.frc.team5892.robot.oi;

import org.usfirst.frc.team5892.robot.commands.IntakePneumaticsToggle;

public class OI {
    public PlayerOne player1;
    public PlayerTwo player2;

    public OI(PlayerOne player_1, PlayerTwo player_2) {
        player1 = player_1;
        player2 = player_2;

        // Player 1 commands

        // Player 2 commands
        //player2.togglePiston1().whenActive(new IntakePneumaticsToggle(0));
        //player2.togglePiston2().whenActive(new IntakePneumaticsToggle(1));
        //player2.togglePiston3().whenActive(new IntakePneumaticsToggle(2));
    }
}
