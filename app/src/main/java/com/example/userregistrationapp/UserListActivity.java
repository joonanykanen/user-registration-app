package com.example.userregistrationapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

public class UserListActivity extends AppCompatActivity {

    private RecyclerView userRecyclerView;
    private UserListAdapter userListAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_list);

        userRecyclerView = findViewById(R.id.userRecyclerView);
        userListAdapter = new UserListAdapter(UserStorage.getInstance().getUsers());
        userRecyclerView.setAdapter(userListAdapter);
        userRecyclerView.setLayoutManager(new LinearLayoutManager(this));
    }

}