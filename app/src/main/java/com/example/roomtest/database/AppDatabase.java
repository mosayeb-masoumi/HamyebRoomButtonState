package com.example.roomtest.database;

import androidx.room.Database;
import androidx.room.RoomDatabase;

@Database(entities = {UserModelDB.class} , version = 1 , exportSchema = false)
public abstract class AppDatabase extends RoomDatabase {
    public abstract UserDao userDao();
}
