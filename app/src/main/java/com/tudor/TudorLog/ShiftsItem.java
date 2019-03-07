package com.tudor.TudorLog;

public class ShiftsItem {
    private String mDate;
    private String mStart;
    private String mEnd;
    private String mHours;

    public ShiftsItem(String mDate, String mStart, String mEnd, String mHours) {
        this.mDate = mDate;
        this.mStart = mStart;
        this.mEnd = mEnd;
        this.mHours = mHours;
    }

    public String getmDate() {
        return mDate;
    }

    public void setmDate(String mDate) {
        this.mDate = mDate;
    }

    public String getmStart() {
        return mStart;
    }

    public void setmStart(String mStart) {
        this.mStart = mStart;
    }

    public String getmEnd() {
        return mEnd;
    }

    public void setmEnd(String mEnd) {
        this.mEnd = mEnd;
    }

    public String getmHours() {
        return mHours;
    }

    public void setmHours(String mHours) {
        this.mHours = mHours;
    }
}
