package com.example.userregistrationapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class UserListActivity extends AppCompatActivity {

    private RecyclerView userRecyclerView;
    private UserListAdapter userListAdapter;
    private SharedPreferencesManager sharedPreferencesManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_list);
        sharedPreferencesManager = new SharedPreferencesManager(this);
        ArrayList<User> userList = sharedPreferencesManager.loadUserList();

        Collections.sort(userList, new Comparator<User>() {
            @Override
            public int compare(User user1, User user2) {
                return user1.getLastName().compareToIgnoreCase(user2.getLastName());
            }
        });

        userRecyclerView = findViewById(R.id.userRecyclerView);
        userListAdapter = new UserListAdapter(userList, this);
        userRecyclerView.setAdapter(userListAdapter);
        userRecyclerView.setLayoutManager(new LinearLayoutManager(this));
    }

}