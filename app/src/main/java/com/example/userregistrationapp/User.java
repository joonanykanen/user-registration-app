package com.example.userregistrationapp;

import java.util.Set;

public class User {
    private final String firstName;
    private final String lastName;
    private final String email;
    private final String degreeProgram;
    private Set<String> completedDegrees;
    private final String imagePath;

    public User(String firstName, String lastName, String email, String degreeProgram, Set<String> completedDegrees, String imagePath) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.degreeProgram = degreeProgram;
        this.completedDegrees = completedDegrees;
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

    public Set<String> getCompletedDegrees() { return completedDegrees; }

    public String getImagePath() {
        return imagePath;
    }

    public void setCompletedDegrees(Set<String> completedDegrees) {
        this.completedDegrees = completedDegrees;
    }
}
