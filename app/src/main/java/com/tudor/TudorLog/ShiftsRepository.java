package com.tudor.TudorLog;

import android.app.Application;
import android.os.AsyncTask;

import androidx.lifecycle.LiveData;

import java.util.List;

public class ShiftsRepository {
    private ShiftsDao shiftsDao;
    private LiveData<List<Shifts>> allShifts;

    public ShiftsRepository(Application application){
        AppDatabase database = AppDatabase.getInstance(application);
        shiftsDao = database.shiftsDao();
        allShifts = shiftsDao.getAllShifts();
    }

    //function to insert shifts
    public void insert(Shifts shift){
        new insertShiftAsyncTask(shiftsDao).execute(shift);
    }
    //function to update shifts
    public void update(Shifts shift){
        new updateShiftAsyncTask(shiftsDao).execute(shift);
    }
    //function to delete one shift
    public void delete(Shifts shift){
        new deleteShiftAsyncTask(shiftsDao).execute(shift);
    }
    //function to delete all shifts
    public void deleteAll(){
        new deleteAllShiftAsyncTask(shiftsDao).execute();
    }
    //function to retrieve the shifts from the database
    public LiveData<List<Shifts>> getAllShifts(){
        return allShifts;
    }

    private static class insertShiftAsyncTask extends AsyncTask<Shifts, Void, Void>{
        private ShiftsDao shiftsDao;
        private insertShiftAsyncTask(ShiftsDao shiftsDao){
            this.shiftsDao = shiftsDao;
        }
        @Override
        protected Void doInBackground(Shifts... shifts) {
            shiftsDao.insert(shifts[0]);
            return null;
        }
    }

    private static class updateShiftAsyncTask extends AsyncTask<Shifts, Void, Void>{
        private ShiftsDao shiftsDao;
        private updateShiftAsyncTask(ShiftsDao shiftsDao){
            this.shiftsDao = shiftsDao;
        }
        @Override
        protected Void doInBackground(Shifts... shifts) {
            shiftsDao.update(shifts[0]);
            return null;
        }
    }

    private static class deleteShiftAsyncTask extends AsyncTask<Shifts, Void, Void>{
        private ShiftsDao shiftsDao;
        private deleteShiftAsyncTask(ShiftsDao shiftsDao){
            this.shiftsDao = shiftsDao;
        }
        @Override
        protected Void doInBackground(Shifts... shifts) {
            shiftsDao.delete(shifts[0]);
            return null;
        }
    }

    private static class deleteAllShiftAsyncTask extends AsyncTask<Void, Void, Void>{
        private ShiftsDao shiftsDao;
        private deleteAllShiftAsyncTask(ShiftsDao shiftsDao){
            this.shiftsDao = shiftsDao;
        }
        @Override
        protected Void doInBackground(Void... voids) {
            shiftsDao.deleteAll();
            return null;
        }
    }
}
