package Puzzles;

import java.time.Clock;

public class Puzzles {
    public static void main(String[] args) {
        getClockAngle("00:30");
    }

    /*Clock Angle Problem: Given time in hh:mm format in 24-hour notation, calculate the shorter angle between
    the hour and minute hand in an analog clock.
    For example,
    Input:  5:30
    Output: 15°*/
    public static void getClockAngle(String time) {
        int hh = Integer.parseInt(time.split(":")[0]);
        int mm = Integer.parseInt(time.split(":")[1]);
        int angle = mm * 6 - (hh * 30 + (mm / 2));
        System.out.print(String.format("Angle b/w hour and minute hand at %d:%d, is: %d degree(s)", hh, mm, angle));
    }
}
