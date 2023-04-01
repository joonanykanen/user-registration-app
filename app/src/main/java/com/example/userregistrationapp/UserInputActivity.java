package com.example.userregistrationapp;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class UserInputActivity extends AppCompatActivity {

    private SharedPreferencesManager sharedPreferencesManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_input);
        sharedPreferencesManager = new SharedPreferencesManager(this);

        Button addUserButton = findViewById(R.id.addUserButton);
        addUserButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                addUser();
            }
        });
    }

    @SuppressLint("NonConstantResourceId")
    private void addUser() {
        EditText firstNameEditText = findViewById(R.id.firstNameInput);
        EditText lastNameEditText = findViewById(R.id.lastNameInput);
        EditText emailEditText = findViewById(R.id.emailInput);
        RadioGroup degreeProgramRadioGroup = findViewById(R.id.degreeProgramRadioGroup);
        RadioGroup imageRadioGroup = findViewById(R.id.imageRadioGroup);
        CheckBox degreeBachelorCheckBox = findViewById(R.id.degreeBachelorCheckBox);
        CheckBox degreeMasterCheckBox = findViewById(R.id.degreeMasterCheckBox);
        CheckBox degreeDoctorCheckBox = findViewById(R.id.degreeDoctorCheckBox);

        String firstName = firstNameEditText.getText().toString();
        String lastName = lastNameEditText.getText().toString();
        String email = emailEditText.getText().toString();

        int selectedRadioButtonId = degreeProgramRadioGroup.getCheckedRadioButtonId();
        RadioButton selectedRadioButton = findViewById(selectedRadioButtonId);
        String degreeProgram = selectedRadioButton.getText().toString();

        Set<String> completedDegrees = new HashSet<>();

        if (degreeBachelorCheckBox.isChecked()) {
            completedDegrees.add(getString(R.string.degree_bachelor));
        }
        if (degreeMasterCheckBox.isChecked()) {
            completedDegrees.add(getString(R.string.degree_master));
        }
        if (degreeDoctorCheckBox.isChecked()) {
            completedDegrees.add(getString(R.string.degree_doctor));
        }

        String imagePath = "";
        int selectedImageId = imageRadioGroup.getCheckedRadioButtonId();
        switch (selectedImageId) {
            case R.id.imageRadioButton1:
                imagePath = "image_1";
                break;
            case R.id.imageRadioButton2:
                imagePath = "image_2";
                break;
        }

        ArrayList<User> userList = sharedPreferencesManager.loadUserList();
        User newUser = new User(firstName, lastName, email, degreeProgram, completedDegrees, imagePath);
        userList.add(newUser);
        sharedPreferencesManager.saveUserList(userList);

        finish();
    }

}