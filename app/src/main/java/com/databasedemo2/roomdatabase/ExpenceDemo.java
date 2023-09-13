package com.databasedemo2.roomdatabase;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

@Dao
public interface ExpenceDemo {

    @Query("select * from expenseTable")
    List<Expense> getAllData();

    @Insert
    void addData(Expense expense);

    @Update
    void updateData(Expense expense);

    @Delete
    void deleteData(Expense expense);
}
