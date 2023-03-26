package com.example.userregistrationapp;

public class User {
    private final String firstName;
    private final String lastName;
    private final String email;
    private final String degreeProgram;
    private final String imagePath;

    public User(String firstName, String lastName, String email, String degreeProgram, String imagePath) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.degreeProgram = degreeProgram;
        this.imagePath = imagePath;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getEmail() {
        return email;
    }

    public String getDegreeProgram() {
        return degreeProgram;
    }

    public String getImagePath() {
        return imagePath;
    }
}
