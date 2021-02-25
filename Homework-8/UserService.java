package com.company;

import java.io.*;

public class UserService implements Service {

    @Override
    public boolean checkUser(Human human) {

        try (BufferedReader reader = new BufferedReader(new FileReader("D://Homework8.txt"))) {
            String value = reader.readLine();
            while (value != null) {
                if (human.getMail().equals(value)) {
                    return true;
                }
                value = reader.readLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public void dataRecording(Human human) {
        System.out.println("Get your dirty hands off the keyboard, plebeian");
    }
}



