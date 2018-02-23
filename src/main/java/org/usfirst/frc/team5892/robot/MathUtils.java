package org.usfirst.frc.team5892.robot;

public class MathUtils {
    private MathUtils() {}

    private static final int ENCODER_RESOLUTION = 2048;
    private static final int WHEEL_DIAMETER = 6;

    public static int encoderInches(double inches) {
        return (int) Math.round(inches / (WHEEL_DIAMETER * Math.PI) * ENCODER_RESOLUTION);
    }

    public static double scalePlusMinus(double input, double posFactor, double negFactor) {
        if (input > 0) {
            return input * posFactor;
        } else {
            return input * negFactor;
        }
    }
}
