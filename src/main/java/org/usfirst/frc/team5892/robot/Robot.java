/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package org.usfirst.frc.team5892.robot;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;
import edu.wpi.cscore.UsbCamera;
import edu.wpi.first.wpilibj.CameraServer;
import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.Scheduler;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import org.usfirst.frc.team5892.robot.auton.*;
import org.usfirst.frc.team5892.robot.oi.JoystickPlayerOne;
import org.usfirst.frc.team5892.robot.oi.JoystickPlayerTwo;
import org.usfirst.frc.team5892.robot.oi.OI;
import org.usfirst.frc.team5892.robot.subsystems.batwing.BatwingSubsystem;
import org.usfirst.frc.team5892.robot.subsystems.drive.DriveSubsystem;
import org.usfirst.frc.team5892.robot.subsystems.elevator.ElevatorSubsystem;
import org.usfirst.frc.team5892.robot.subsystems.intake.IntakeSubsystem;
import org.usfirst.frc.team5892.robot.subsystems.selfclimb.SelfClimbSubsystem;

/**
 * The VM is configured to automatically run this class, and to call the
 * functions corresponding to each mode, as described in the TimedRobot
 * documentation. If you change the name of this class or the package after
 * creating this project, you must also update the build.properties file in the
 * project.
 */
public class Robot extends TimedRobot {
    public static OI m_oi;

    public static final boolean batwings = false;

    private Command m_autonomousCommand;
    public static SendableChooser<DynamicAuton> autonChooser = new SendableChooser<>();

    public static DriveSubsystem drive;
    public static IntakeSubsystem intake;
    public static ElevatorSubsystem elevator;
    public static BatwingSubsystem leftBatwing;
    public static BatwingSubsystem rightBatwing;
    public static SelfClimbSubsystem selfClimb;

    public static RobotMap map = new OfficialBotMap();

    /**
     * This function is run when the robot is first started up and should be
     * used for any initialization code.
     */
    @Override
    public void robotInit() {
        // Order is important!!!
        WPI_TalonSRX talon = new WPI_TalonSRX(Robot.map.elevatorTalon.port);
        talon.setInverted(Robot.map.elevatorTalon.inverted); talon.setName("Elevator Talon");
        map.elevatorOtherMotor.makeVictor().setName("Elevator Not-the-Talon");

        // Subsystems
        drive = new DriveSubsystem();
        intake = new IntakeSubsystem();
        //elevator = new ElevatorSubsystem();
        if (batwings) {
            leftBatwing = new BatwingSubsystem("Left", map.leftBatwingRetainer.makeVictor(), map.leftBatwingWinch.makeVictor(), new DigitalInput(map.leftBatwingSensor));
            rightBatwing = new BatwingSubsystem("Right", map.rightBatwingRetainer.makeVictor(), map.rightBatwingWinch.makeVictor(), new DigitalInput(map.rightBatwingSensor));
        } else {
            selfClimb = new SelfClimbSubsystem();
        }

        // OI
        m_oi = new OI(new JoystickPlayerOne(0), new JoystickPlayerTwo(1));

        // Autonomous modes
        autonChooser.addObject("Do Nothing", null);
        autonChooser.addObject("Cross the Line", new EmergencyLineAuto());
        //autonChooser.addObject("Test Movement", new TestEverythingAuto());
        autonChooser.addDefault("Switch from Middle", new ForwardToSwitchAuto());
        autonChooser.addObject("Switch from Side", new ScoreToSwitchAuto());
        autonChooser.addObject("Score to Scale", new ScoreToScaleAuto());
        //autonChooser.addObject("Score Two Cubes", new TwoCubeAuto());
        SmartDashboard.putData("Auto mode", autonChooser);

        // CameraServer
        if (map.cameras) {
            UsbCamera cam1 = CameraServer.getInstance().startAutomaticCapture(0);
            cam1.setResolution(160, 120);

            CameraServer.getInstance().getVideo();
            CameraServer.getInstance().putVideo("RoboFeed", 160, 120);
        }

        // Preflight checks
        //PreflightChecks.addCheck("Stable Gyro Output");
    }

    /**
     * This function is called once each time the robot enters Disabled mode.
     * You can use it to reset any subsystem information you want to clear when
     * the robot is disabled.
     */
    @Override
    public void disabledInit() {
        drive.resetGyro();
        if (elevator != null) elevator.setMotorPower(0);
        DynamicAuton.startCheckCommand();
    }

    @Override
    public void disabledPeriodic() {
        Scheduler.getInstance().run();
    }

    /**
     * This autonomous (along with the chooser code above) shows how to select
     * between different autonomous modes using the dashboard. The sendable
     * chooser code works with the Java SmartDashboard. If you prefer the
     * LabVIEW Dashboard, remove all of the chooser code and uncomment the
     * getString code to get the auto name from the text box below the Gyro
     *
     * <p>You can add additional auto modes by adding additional commands to the
     * chooser code above (like the commented example) or additional comparisons
     * to the switch structure below with additional strings & commands.
     */
    @Override
    public void autonomousInit() {
        drive.resetGyro();
        DynamicAuton builder = autonChooser.getSelected();

        if (builder != null) {
            try {
                m_autonomousCommand = builder.build();
            } catch (Throwable e) {
                final String F_PAY_RESPECTS = "Press F to pay respects.";
                DriverStation.reportError("Error building autonomous: " + e.toString(), e.getStackTrace());
                if (!m_ds.isFMSAttached()) return;
                if (builder instanceof EmergencyLineAuto) {
                    DriverStation.reportWarning(F_PAY_RESPECTS, false);
                    return;
                }
                try {
                    m_autonomousCommand = new EmergencyLineAuto().build();
                    DriverStation.reportWarning("Scheduling emergency line-cross autonomous.", false);
                } catch (Throwable f) {
                    DriverStation.reportError("Error building emergency autonomous: " + f.toString(), f.getStackTrace());
                    DriverStation.reportWarning(F_PAY_RESPECTS, false);
                    return;
                }
            }
            m_autonomousCommand.start();
        }
    }

    /**
     * This function is called periodically during autonomous.
     */
    @Override
    public void autonomousPeriodic() {
        Scheduler.getInstance().run();
    }

    @Override
    public void teleopInit() {
        // This makes sure that the autonomous stops running when
        // teleop starts running. If you want the autonomous to
        // continue until interrupted by another command, remove
        // this line or comment it out.
        if (m_autonomousCommand != null) {
            m_autonomousCommand.cancel();
        }
    }

    /**
     * This function is called periodically during operator control.
     */
    @Override
    public void teleopPeriodic() {
        Scheduler.getInstance().run();
    }

    /**
     * This function is called periodically during test mode.
     */
    @Override
    public void testPeriodic() {
    }
}
