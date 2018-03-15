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

        player2.intake().whenActive(new StartIntaking());
        player2.outtake().whileActive(new OuttakeCommand());

        player2.leftBatwingDown().whileActive(new LowerBatwingArm(Robot.leftBatwing));
        player2.leftBatwingLift().whileActive(new RaiseBatwingWinch(Robot.leftBatwing));
        //player2.rightBatwingDown().whileActive(new LowerBatwingArm(Robot.rightBatwing));
        //player2.rightBatwingLift().whileActive(new RaiseBatwingWinch(Robot.rightBatwing));
    }
}
