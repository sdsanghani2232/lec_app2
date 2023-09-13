package com.databasedemo2.roomdatabase;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

@Database(entities = Expense.class,exportSchema = false,version = 1)
public abstract class DataBAseHelper extends RoomDatabase {

    private static  final String DB_name = "expnseDB";
    private static DataBAseHelper instance;

    public static synchronized DataBAseHelper getdata(Context context)
    {
        if(instance == null)
        {
            instance = Room.databaseBuilder(context,DataBAseHelper.class,DB_name)
                    .fallbackToDestructiveMigration()
                    .allowMainThreadQueries()
                    .build();

        }
        return instance;
    }

    public abstract ExpenceDemo expenceDemo();

}
