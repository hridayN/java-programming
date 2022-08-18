package com.encapsulation;

import java.util.Date;

public class EncapsulationDemo {
    public static void main(String[] args) {
        Clock clock = new Clock();
        clock.getDateTime();
        clock.setAlarm(new Date());
        System.out.println(clock.isAlarmStatus());
    }
}
