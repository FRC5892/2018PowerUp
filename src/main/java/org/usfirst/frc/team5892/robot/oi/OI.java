package org.usfirst.frc.team5892.robot.oi;

import org.usfirst.frc.team5892.robot.Robot;
import org.usfirst.frc.team5892.robot.subsystems.intake.*;
import org.usfirst.frc.team5892.robot.subsystems.elevator.*;
import org.usfirst.frc.team5892.robot.subsystems.batwing.*;

public class OI {
    public final PlayerOne player1;
    public final PlayerTwo player2;

    // if you get *rly* mad, move trigger inits into subsystems' initDefaultCommand()s.
    public OI(PlayerOne player_1, PlayerTwo player_2) {
        player1 = player_1;
        player2 = player_2;

        player2.batwingLeft().whenActive(new BatwingActivate(Robot.batwings.left));
        player2.batwingRight().whenActive(new BatwingActivate(Robot.batwings.right));
    }
}
