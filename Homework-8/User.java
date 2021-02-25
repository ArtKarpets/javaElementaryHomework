package com.company;

public class User extends Human {

    private String role;

    public User(String firstName, String secondName, int age, String mail, String password, String role) {
        super(firstName, secondName, age, mail, password, role);
    }
}
