package com.example.userregistrationapp;

import android.content.Context;
import android.content.SharedPreferences;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import java.lang.reflect.Type;
import java.util.ArrayList;

public class SharedPreferencesManager {
    private static final String PREF_NAME = "user_registration_app";
    private static final String USER_LIST_KEY = "user_list_key";

    private SharedPreferences sharedPreferences;
    private Gson gson;

    public SharedPreferencesManager(Context context) {
        sharedPreferences = context.getSharedPreferences(PREF_NAME, Context.MODE_PRIVATE);
        gson = new Gson();
    }

    public void saveUserList(ArrayList<User> userList) {
        SharedPreferences.Editor editor = sharedPreferences.edit();
        String json = gson.toJson(userList);
        editor.putString(USER_LIST_KEY, json);
        editor.apply();
    }

    public ArrayList<User> loadUserList() {
        String json = sharedPreferences.getString(USER_LIST_KEY, "");
        Type type = new TypeToken<ArrayList<User>>() {}.getType();
        ArrayList<User> userList = gson.fromJson(json, type);
        if (userList == null) {
            userList = new ArrayList<>();
        }
        return userList;
    }
}
