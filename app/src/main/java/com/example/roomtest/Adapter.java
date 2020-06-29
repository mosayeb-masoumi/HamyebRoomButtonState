package com.example.roomtest;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.roomtest.database.AppDatabase;
import com.example.roomtest.database.UserModelDB;

import java.util.List;

public class Adapter extends RecyclerView.Adapter<ViewHolderDB> {


    AppDatabase db;
    List<UserModelDB> userModelDB;
    Context context;


    public Adapter(AppDatabase db, List<UserModelDB> userModelDB, Context context) {
        this.db = db;
        this.userModelDB = userModelDB;
        this.context = context;
    }

//
//    @Override
//    public ViewHolderDB onCreateViewHolder(@NonNull ViewGroup parent, int i) {
//        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.row, parent, false);
//        return new ViewHolderDB(view);
//    }
//
//    @Override
//    public void onBindViewHolder(@NonNull ViewHolderDB holder, int position) {
//        final UserModelDB model = userModelDB.get(position);
//        holder.bindData(model);
//        holder.setOnProjectHolderListener(listener, model);
//    }



    @NonNull
    @Override
    public ViewHolderDB onCreateViewHolder(@NonNull ViewGroup parent, int i) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.row, parent, false);
        return new ViewHolderDB(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolderDB holder, int position) {
        UserModelDB model = userModelDB.get(position);
        holder.bindData(model);
        holder.setOnProjectHolderListener(listener, model , position);
    }

    private ProjectItemInteraction listener = null;

    public void setListener(ProjectItemInteraction listener) {
        this.listener = listener;
    }

    @Override
    public int getItemCount() {
        return userModelDB.size();
    }


}
