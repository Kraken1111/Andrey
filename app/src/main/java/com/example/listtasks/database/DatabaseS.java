package com.example.listtasks.database;

import android.content.Context;

import androidx.room.Room;

public class DatabaseS {
    private Context mCtx;
    private static DatabaseS mInstance;

    //our app database object
    private AppDatabase appDatabase;

    private DatabaseS(Context mCtx) {
        this.mCtx = mCtx;

        //creating the app database with Room database builder
        //MyToDos is the name of the database
        appDatabase = Room.databaseBuilder(mCtx, AppDatabase.class, "MyToDos").build();
    }

    public static synchronized DatabaseS getInstance(Context mCtx) {
        if (mInstance == null) {
            mInstance = new DatabaseS(mCtx);
        }
        return mInstance;
    }

    public AppDatabase getAppDatabase() {
        return appDatabase;
    }

}
