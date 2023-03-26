package com.example.userregistrationapp;

import java.util.ArrayList;

public class UserStorage {
    private static UserStorage instance;
    private ArrayList<User> users;

    private UserStorage() {
        users = new ArrayList<>();
    }

    public static UserStorage getInstance() {
        if (instance == null) {
            instance = new UserStorage();
        }
        return instance;
    }

    public ArrayList<User> getUsers() {
        return users;
    }

    public void addUser(User user) {
        users.add(user);
    }

    public void removeUser(int id) {
        users.remove(id);
    }
}
