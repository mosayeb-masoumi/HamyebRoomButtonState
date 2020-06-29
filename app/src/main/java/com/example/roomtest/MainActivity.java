package com.example.roomtest;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.room.Room;

import android.os.Bundle;

import com.example.roomtest.database.AppDatabase;
import com.example.roomtest.database.UserModelDB;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements ProjectItemInteraction{

    AppDatabase db;
    RecyclerView recyclerview;
    Adapter adapter;
    List<UserModelDB> userModelDB = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerview = findViewById(R.id.recyclerview);


        db = Room.databaseBuilder(getApplicationContext(), AppDatabase.class, "users")
                .allowMainThreadQueries()
                .build();





        userModelDB = db.userDao().getAllUsers();


        setRecyclereView(userModelDB);


    }

    private void setRecyclereView(List<UserModelDB> userModelDB) {

        recyclerview.setLayoutManager(new LinearLayoutManager(this));
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerview.setLayoutManager(layoutManager);
        adapter = new Adapter(db, this.userModelDB, this);
        adapter.setListener(this);
        recyclerview.setAdapter(adapter);
    }

    @Override
    public void projectListItemOnClick(UserModelDB model, int position , String state) {

        if(state.equals("run")){
            for (int i = 0; i <userModelDB.size() ; i++) {
                if(i == position){

                    userModelDB.get(i).setName("jjjjjjjjjj");
                    userModelDB.get(i).setFamily(model.getFamily());
                    userModelDB.get(i).setRun(true);

                }
            }
        }else if(state.equals("stop")){
            for (int i = 0; i <userModelDB.size() ; i++) {
                if(i == position){

                    userModelDB.get(i).setName("kkkkk");
                    userModelDB.get(i).setFamily(model.getFamily());
                    userModelDB.get(i).setRun(false);

                }
            }
        }



//        db.userDao().insertAll(userModelDB);
        db.userDao().updatePerson(userModelDB);

//        userModelDB = db.userDao().getAllUsers();
        setRecyclereView(userModelDB);

    }
}