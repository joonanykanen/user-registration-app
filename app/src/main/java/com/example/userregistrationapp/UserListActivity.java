package com.example.userregistrationapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

public class UserListActivity extends AppCompatActivity {

    private RecyclerView userRecyclerView;
    private UserListAdapter userListAdapter;
    private SharedPreferencesManager sharedPreferencesManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_list);
        sharedPreferencesManager = new SharedPreferencesManager(this);

        userRecyclerView = findViewById(R.id.userRecyclerView);
        userListAdapter = new UserListAdapter(sharedPreferencesManager.loadUserList(), this);
        userRecyclerView.setAdapter(userListAdapter);
        userRecyclerView.setLayoutManager(new LinearLayoutManager(this));
    }

}