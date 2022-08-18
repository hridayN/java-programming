package com.encapsulation;

import java.util.Date;

//@Data
public class Clock {
    //These properties will be fetched/set only from getter/setter methods respectively
    private Date dateTime;
    private Date alarm;

    public Date getAlarm() {
        return alarm;
    }

    public void setAlarm(Date alarm) {
        this.alarm = alarm;
        this.alarmStatus = true;
    }

    public boolean isAlarmStatus() {
        return alarmStatus;
    }

    public void setAlarmStatus(boolean alarmStatus) {
        this.alarmStatus = alarmStatus;
    }

    private boolean alarmStatus;

    public Date getDateTime() {
        return dateTime;
    }

    public void setDateTime(Date dateTime) {
        this.dateTime = dateTime;
    }
}
