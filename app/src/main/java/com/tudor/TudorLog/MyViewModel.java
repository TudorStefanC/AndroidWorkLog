package com.tudor.TudorLog;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import java.util.List;

public class MyViewModel extends AndroidViewModel {

    private ShiftsRepository repository;
    private LiveData<List<Shifts>> allShifts;

    public MyViewModel(@NonNull Application application) {
        super(application);
        repository = new ShiftsRepository(application);
        allShifts = repository.getAllShifts();
    }

    public void insert(Shifts shift){
        repository.insert(shift);
    }

    public void update(Shifts shift){
        repository.update(shift);
    }

    public void delete(Shifts shift){
        repository.delete(shift);
    }

    public void deleteAll(){
        repository.deleteAll();
    }

    public LiveData<List<Shifts>> getAllShifts(){
        return allShifts;
    }
}
