package com.tudor.TudorLog;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;

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
