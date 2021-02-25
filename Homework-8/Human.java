package com.company;

public class Human {
    private String firstName;
    private String secondName;
    private int age;
    private String mail;
    private String password;
    private String role;


    public Human(String firstName, String secondName, int age, String mail, String password, String role) {
        this.firstName = firstName;
        this.secondName = secondName;
        this.age = age;
        this.mail = mail;
        this.password = password;
        this.role = role;
    }

    public String getMail() {
        return mail;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getSecondName() {
        return secondName;
    }

    public int getAge() {
        return age;
    }

    public String getPassword() {
        return password;
    }

    public String getRole() {
        return role;
    }
}
