package com.example.jcasselm.listtracker;

import android.app.Application;
import android.arch.lifecycle.LiveData;

import java.util.List;
import java.util.concurrent.Executors;

public class ListObjectRepository
{
    private ListObjectDao dao;
    private LiveData<List<ListObject>> allLists;
    ListObjectRepository(Application application)
    {
        ListObjectDB db
                = ListObjectDB.getInstance(application);
        dao = db.getListObjectDao();
        allLists = dao.getAllLists();
    }
    LiveData<List<ListObject>> getAllLists()
    {
        return allLists;
    }

    public void insert(ListObject listObject)
    {
        Executors.newSingleThreadExecutor().execute(() ->
        {
            dao.insert(listObject);
        });
    }
    public void insertAll(ListObject... listObjects)
    {
        Executors.newSingleThreadExecutor().execute(() ->
        {
            dao.insertAll(listObjects);
        });
    }

    public void update (ListObject listObject)
    {
        Executors.newSingleThreadExecutor().execute(() ->
        {
            dao.update(listObject);
        });
    }
    public void delete(ListObject listObject)
    {
        Executors.newSingleThreadExecutor().execute(() ->
        {
            dao.delete(listObject);
        });
    }

    public void deleteSeveral(ListObject... listObjects)
    {
        Executors.newSingleThreadExecutor().execute(() ->
        {
            dao.deleteSeveral(listObjects);
        });
    }
    public void deleteAll()
    {
        Executors.newSingleThreadExecutor().execute(() ->
        {
            dao.deleteAll();
        });
    }
}

