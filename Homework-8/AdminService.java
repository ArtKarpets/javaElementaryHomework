package com.company;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class AdminService implements Service {

    @Override
    public boolean checkUser(Human human) {

        try (BufferedReader reader = new BufferedReader(new FileReader("D://Homework8.txt"))) {
            String value = reader.readLine();
            while (reader.readLine() != null) {
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
        try (FileWriter writer = new FileWriter("D://Homework8.txt", true)) {
            writer.write("\r\n" + human.getFirstName());
            writer.write("\r\n" + human.getSecondName());
            writer.write("\r\n" + human.getAge());
            writer.write("\r\n" + human.getMail());
            writer.write("\r\n" + human.getPassword());
            writer.write("\r\n" + human.getRole());
            writer.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
