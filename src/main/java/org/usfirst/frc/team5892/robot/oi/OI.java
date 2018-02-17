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
        if (Robot.drive != null) driveTriggers();
        if (Robot.intake != null) intakeTriggers();
        if (Robot.elevator != null) elevatorTriggers();
        if (Robot.batwings != null) batwingTriggers();
    }

    protected void driveTriggers() {

    }
    protected void intakeTriggers() {
        player1.intakeToggle().whenActive(new IntakeToggle());

        player2.intakeOverride().whenActive(new ToggleIntakeOverride());
    }

    protected void elevatorTriggers() {
        player2.elevatorUp().whenActive(new IncrementElevatorTarget());
        player2.elevatorDown().whenActive(new DecrementElevatorTarget());
        player2.elevatorOverride().whenActive(new ToggleElevatorOverride());
    }

    protected void batwingTriggers() {
        player2.batwingLeft().whenActive(new BatwingActivate(Robot.batwings.left));
        player2.batwingRight().whenActive(new BatwingActivate(Robot.batwings.right));
    }
}
