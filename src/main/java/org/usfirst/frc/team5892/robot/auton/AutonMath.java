package org.usfirst.frc.team5892.robot.auton;

public class AutonMath {
    private AutonMath() {}

    private static final int ENCODER_RESOLUTION = 2048;
    private static final int WHEEL_DIAMETER = 6;

    public static int inchesToEncoderTicks(double inches) {
        return (int) Math.round(inches / (WHEEL_DIAMETER * Math.PI) * ENCODER_RESOLUTION);
    }
}
