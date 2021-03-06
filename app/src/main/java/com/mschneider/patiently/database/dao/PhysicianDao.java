package com.mschneider.patiently.database.dao;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;
import androidx.room.Update;

import com.mschneider.patiently.models.Physician;

import java.util.List;

@Dao
public interface PhysicianDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insertPhysician(Physician physician);

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insertPhysicians(List<Physician> physicians);


    @Update
    void updatePhysician(Physician physician);


    @Delete
    void deletePhysicians(Physician physician);

    @Query("DELETE FROM physicians WHERE physicianId = :id")
    void deleteById(int id);

    @Query("SELECT * FROM physicians WHERE physicianId = :physicianId")
    Physician getPhysicianById(int physicianId);

    @Query("SELECT * FROM physicians ORDER BY physicianId ASC")
    List<Physician> getAllPhysicians();

    @Query("DELETE FROM physicians")
    int deleteAllPhysicians();

    @Query("SELECT COUNT(*) FROM physicians")
    int getPhysicianCount();
}
