package com.tudor.TudorLog;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

@Database(entities = {Shifts.class}, version = 1)
public abstract class AppDatabase extends RoomDatabase {
    private static AppDatabase instance;
    public ShiftsDao shiftsDao;

    public static synchronized AppDatabase getInstance(Context context){
        if (instance == null){
            instance = Room.databaseBuilder(context.getApplicationContext(),
                    AppDatabase.class, "Shifts_database")
                    .fallbackToDestructiveMigration()
                    .build();
        }
        return instance;
    }
}