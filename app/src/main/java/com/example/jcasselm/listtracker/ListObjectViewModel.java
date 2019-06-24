package com.example.jcasselm.listtracker;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.arch.lifecycle.LiveData;

import java.util.List;

public class ListObjectViewModel extends AndroidViewModel
{
    private ListObjectRepository repository;
    private LiveData<List<ListObject>> allLists;
    public ListObjectViewModel(Application application)
    {
        super(application);
        repository =
                new ListObjectRepository(application);
        allLists = repository.getAllLists();
    }
    LiveData<List<ListObject>> getAllLists()
    {
        return allLists;
    }

    public void insert(ListObject listObject)
    {
        repository.insert(listObject);
    }
    public void delete(ListObject listObject)
    {
        repository.delete(listObject);
    }
}
