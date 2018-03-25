package org.usfirst.frc.team5892.robot.oi;

import org.usfirst.frc.team5892.robot.Robot;
import org.usfirst.frc.team5892.robot.subsystems.batwing.LowerBatwingArm;
import org.usfirst.frc.team5892.robot.subsystems.batwing.RaiseBatwingWinch;
import org.usfirst.frc.team5892.robot.subsystems.elevator.ElevatorBrake;
import org.usfirst.frc.team5892.robot.subsystems.selfclimb.ClimbArmControl;
import org.usfirst.frc.team5892.robot.subsystems.selfclimb.RunClimbArm;
import org.usfirst.frc.team5892.robot.subsystems.selfclimb.RunClimbWinch;

public class OI {
    public final PlayerOne player1;
    public final PlayerTwo player2;

    public OI(PlayerOne player_1, PlayerTwo player_2) {
        player1 = player_1;
        player2 = player_2;

        player2.elevatorBrake().whileActive(new ElevatorBrake());

        if (Robot.batwings) {
            player2.leftBatwingDown().whileActive(new LowerBatwingArm(Robot.leftBatwing));
            player2.leftBatwingLift().whileActive(new RaiseBatwingWinch(Robot.leftBatwing));
            player2.rightBatwingDown().whileActive(new LowerBatwingArm(Robot.rightBatwing));
            player2.rightBatwingLift().whileActive(new RaiseBatwingWinch(Robot.rightBatwing));
        } else {
            player2.armYank().whileActive(new RunClimbArm(1));
            player2.climbWinch().whileActive(new RunClimbWinch(-1));
            player2.reverseWinch().whileActive(new RunClimbWinch(1));
        }
    }
}
