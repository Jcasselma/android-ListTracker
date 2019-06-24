package com.example.jcasselm.listtracker;

import android.arch.persistence.db.SupportSQLiteDatabase;
import android.arch.persistence.room.Database;
import android.arch.persistence.room.Room;
import android.arch.persistence.room.RoomDatabase;
import android.content.Context;
import android.support.annotation.NonNull;

@Database(entities = {ListObject.class}, version = 1)
public abstract class ListObjectDB extends RoomDatabase
{
    public abstract ListObjectDao getListObjectDao();
    private static ListObjectDB instance = null;
    public static synchronized ListObjectDB
    getInstance(Context context)
    {
        if (instance == null)
        {
            instance = Room.databaseBuilder(context,
                    ListObjectDB.class,
                    "list.db")
                    .build();
        }
        return instance;
    }

    private static ListObject[] initialLists =
            {
                    new ListObject(0, "Groceries", "Eggs", "milk", "Bread", "Green Beans", "Chicken"),
                    new ListObject(0, "Chores", "Sweep", "mop", "dust", "organize", "cook"),
                    new ListObject(0, "Homework", "PA0", "PA1", "PA2", "PA3", "PA4"),

    };

    private static class InitDbCallback extends RoomDatabase.Callback
    {
        private Context context;
        InitDbCallback(Context context)
        {
            this.context = context;
        }

        @Override
        public void onCreate(@NonNull SupportSQLiteDatabase db)
        {
            super.onCreate(db);
            Thread backgroundThread = new Thread(() ->
                    getInstance(context).getListObjectDao()
                            .insertAll(initialLists));
            backgroundThread.start();

        }

    }



}

