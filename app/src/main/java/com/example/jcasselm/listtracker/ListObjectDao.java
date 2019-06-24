package com.example.jcasselm.listtracker;

import android.arch.lifecycle.LiveData;
import android.arch.persistence.room.*;

import java.util.List;

import static android.arch.persistence.room.OnConflictStrategy.REPLACE;


@Dao
public interface ListObjectDao
{
    @Query("select * from ListObject")
    LiveData<List<ListObject>> getAllLists();
    @Query("select * from ListObject where id = :id")
    ListObject findById(int id);

    @Insert
    void insert(ListObject listObject);
    @Insert
    void insertAll(ListObject... listObjects);
    @Update(onConflict = REPLACE)
    void update(ListObject listObject);
    @Delete
    void delete(ListObject listObject);
    @Delete
    void deleteSeveral(ListObject... listObjects);

    @Query("delete from ListObject")
    public void deleteAll();
}