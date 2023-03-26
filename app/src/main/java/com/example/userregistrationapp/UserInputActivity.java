package com.example.userregistrationapp;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;

public class UserInputActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_input);

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
        // Hae käyttäjän syötteet
        EditText firstNameEditText = findViewById(R.id.firstNameInput);
        EditText lastNameEditText = findViewById(R.id.lastNameInput);
        EditText emailEditText = findViewById(R.id.emailInput);
        RadioGroup degreeProgramRadioGroup = findViewById(R.id.degreeProgramRadioGroup);
        RadioGroup imageRadioGroup = findViewById(R.id.imageRadioGroup);

        String firstName = firstNameEditText.getText().toString();
        String lastName = lastNameEditText.getText().toString();
        String email = emailEditText.getText().toString();

        int selectedRadioButtonId = degreeProgramRadioGroup.getCheckedRadioButtonId();
        RadioButton selectedRadioButton = findViewById(selectedRadioButtonId);
        String degreeProgram = selectedRadioButton.getText().toString();

        String imagePath = "";
        int selectedImageId = imageRadioGroup.getCheckedRadioButtonId();
        switch (selectedImageId) {
            case R.id.imageRadioButton1:
                imagePath = "image_1";
                break;
            case R.id.imageRadioButton2:
                imagePath = "image_2";
                break;
            // Lisää case-lauseita tarpeen mukaan
        }

        // Luo User-olio ja lisää se UserStorageen
        User newUser = new User(firstName, lastName, email, degreeProgram, imagePath);
        UserStorage.getInstance().addUser(newUser);

        // Vaihda takaisin MainActivityyn
        finish();
    }

}