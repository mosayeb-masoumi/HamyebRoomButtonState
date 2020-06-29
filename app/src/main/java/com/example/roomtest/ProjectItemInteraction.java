package com.example.roomtest;

import android.widget.Button;
import android.widget.RelativeLayout;

import com.example.roomtest.database.UserModelDB;

public interface ProjectItemInteraction {

    void projectListItemOnClick(UserModelDB model, int position , String state);
}
