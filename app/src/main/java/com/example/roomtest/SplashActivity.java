package com.example.roomtest;

import androidx.appcompat.app.AppCompatActivity;
import androidx.room.Room;

import android.content.Intent;
import android.os.Bundle;

import com.example.roomtest.database.AppDatabase;
import com.example.roomtest.database.UserModelDB;

import java.util.ArrayList;
import java.util.List;

public class SplashActivity extends AppCompatActivity {

    AppDatabase db;

    List<UserModelDB> userModelDB = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);


        db = Room.databaseBuilder(getApplicationContext(), AppDatabase.class, "users")
                .allowMainThreadQueries()
                .build();

        userModelDB = db.userDao().getAllUsers();



        if(userModelDB == null || userModelDB.size() == 0) {


            List<UserModel> userModels = new ArrayList<>();
            userModels.add(new UserModel("reza", "rezai", false));
            userModels.add(new UserModel("ali", "hassani", false));
            userModels.add(new UserModel("naghi", "moradi", false));





            for (int i = 0; i < userModels.size(); i++) {
                userModelDB.add(new UserModelDB(userModels.get(i).getName(), userModels.get(i).getFamily(), userModels.get(i).getRun()));
//            db.userDao().insertAll(userModelDB);
            }

            db.userDao().insertAll(userModelDB);

        }

        startActivity(new Intent(SplashActivity.this,MainActivity.class));

    }
}