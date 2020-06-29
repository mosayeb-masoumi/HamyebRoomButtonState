package com.example.roomtest.database;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

@Dao
public interface UserDao {

    //get all list
    @Query("SELECT * FROM UserModelDB")
    List<UserModelDB> getAllUsers();


    //add
    @Insert
    void insertAll(List<UserModelDB> userModelDB);


    //search
    @Query("SELECT * FROM UserModelDB WHERE name = :name")
    List<UserModelDB> findUser(String name);


    // delete each item (use in adapter)
    @Delete
    void deleteUser(UserModelDB userModelDB);

    //delete all
    @Delete
    void deleteAll(List<UserModelDB> userModelDB);


    @Update
    void updatePerson(List<UserModelDB> userModelDB);

    //update  each user
    @Update
    void updatePerson(UserModelDB userModelDB);


}
