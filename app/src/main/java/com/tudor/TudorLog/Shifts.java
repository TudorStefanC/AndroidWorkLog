package com.tudor.TudorLog;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;

@Entity
public class Shifts {

    @PrimaryKey(autoGenerate = true)
    public int id;

    @ColumnInfo(name = "date")
    public String date;

    @ColumnInfo(name = "clock_in")
    public String clockIn;

    @ColumnInfo(name = "clock_out")
    public String clockOut;

    @ColumnInfo(name = "shift_hours")
    public String string_shift_hours;


    //Constructor for setter and getter
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getClockIn() {
        return clockIn;
    }

    public void setClockIn(String clockIn) {
        this.clockIn = clockIn;
    }

    public String getClockOut() {
        return clockOut;
    }

    public void setClockOut(String clockOut) {
        this.clockOut = clockOut;
    }

    public String getString_shift_hours() {
        return string_shift_hours;
    }

    public void setString_shift_hours(String string_shift_hours) {
        this.string_shift_hours = string_shift_hours;
    }
}

