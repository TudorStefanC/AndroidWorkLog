package com.tudor.TudorLog;

import android.content.Context;
import android.os.AsyncTask;

import androidx.annotation.NonNull;
import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.sqlite.db.SupportSQLiteDatabase;

@Database(entities = {Shifts.class}, version = 1)
public abstract class AppDatabase extends RoomDatabase {
    private static AppDatabase instance;
    public abstract ShiftsDao shiftsDao();

    public static synchronized AppDatabase getInstance(Context context){
        if (instance == null){
            instance = Room.databaseBuilder(context.getApplicationContext(),
                    AppDatabase.class, "Shifts_database")
                    .fallbackToDestructiveMigration()
                    .addCallback(roomCallBack)
                    .build();
        }
        return instance;
    }

    private static RoomDatabase.Callback roomCallBack = new RoomDatabase.Callback(){
        @Override
        public void onCreate(@NonNull SupportSQLiteDatabase db) {
            super.onCreate(db);
            new PopulateDbAsyncTask(instance).execute();
        }
    };

    private static class PopulateDbAsyncTask extends AsyncTask<Void, Void, Void>{
        private ShiftsDao shiftsDao;
        private PopulateDbAsyncTask(AppDatabase db){
            shiftsDao = db.shiftsDao();
        }
        @Override
        protected Void doInBackground(Void... voids) {
            shiftsDao.insert(new Shifts("Mar 2019", "07:00", "16:00", "09:00"));
            shiftsDao.insert(new Shifts("Mar 2019", "16:00", "23:30", "08:30"));
            shiftsDao.insert(new Shifts("Mar 2019", "07:00", "16:00", "09:00"));
            return null;
        }
    }
}