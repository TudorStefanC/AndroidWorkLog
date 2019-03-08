package com.tudor.TudorLog;

import androidx.room.Database;
import androidx.room.RoomDatabase;

@Database(entities = {Shifts.class}, version = 1)
public abstract class AppDatabase extends RoomDatabase {
    public abstract ShiftsDao shiftsDao();
}