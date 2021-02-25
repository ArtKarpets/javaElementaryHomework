package com.company;

public class Admin extends Human {

    private String role;

    public Admin(String firstName, String secondName, int age, String mail, String password, String role) {
        super(firstName, secondName, age, mail, password, role);
    }
}
