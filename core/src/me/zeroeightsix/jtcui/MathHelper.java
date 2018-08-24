package me.zeroeightsix.jtcui;

/**
 * @author 086
 */
class MathHelper {

    public static int clampInt(int low, int value, int high) {
        return value < low ? low : (value > high ? high : value);
    }

    public static double clamp(double low, double value, double high) {
        return value < low ? low : (value > high ? high : value);
    }

}
