package com.tudor.TudorLog;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

@Dao
public interface ShiftsDao {
    @Query("SELECT * FROM Shifts")
    LiveData<List<Shifts>> getAllShifts();

    @Insert
    void insert(Shifts shift);

    @Update
    void update(Shifts shift);

    @Delete
    void delete(Shifts shift);

    @Query("DELETE FROM Shifts")
    void deleteAll();
}
