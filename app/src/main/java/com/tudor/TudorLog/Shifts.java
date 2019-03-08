package com.tudor.TudorLog;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class Shifts {

    @PrimaryKey(autoGenerate = true)
    public int id;

    @ColumnInfo(name = "date")
    private String date;

    @ColumnInfo(name = "clock_in")
    private String clockIn;

    @ColumnInfo(name = "clock_out")
    private String clockOut;

    @ColumnInfo(name = "shift_hours")
    private String hours;

    //Constructor
    public Shifts(String date, String clockIn, String clockOut, String hours) {
        this.date = date;
        this.clockIn = clockIn;
        this.clockOut = clockOut;
        this.hours = hours;
    }

    //Setter and getter
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

    public String getHours() {
        return hours;
    }

    public void setHours(String hours) {
        this.hours = hours;
    }
}

