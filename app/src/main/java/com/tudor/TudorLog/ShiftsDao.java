package com.tudor.TudorLog;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import java.util.List;

@Dao
public interface ShiftsDao {
    @Query("SELECT * FROM Shifts")
    List<Shifts> getShifts();

    @Insert
    void insertShifts(Shifts shifts);

    @Query("DELETE FROM Shifts")
    void deleteAll();
}
