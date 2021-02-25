package com.company;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

public class Information {


    private ArrayList<String> nickname;
    private HashSet<String> mail;
    private HashMap<String, String> ratio;


    public Information() {
        nickname = new ArrayList<>();
        mail = new HashSet<>();
        ratio = new HashMap<>();
    }

    public ArrayList<String> getNickname() {
        return nickname;
    }

    public void setNickname(ArrayList<String> nickname) {
        this.nickname = nickname;
    }

    public HashSet<String> getMail() {
        return mail;
    }

    public void setMail(HashSet<String> mail) {
        this.mail = mail;
    }

    public HashMap<String, String> getRatio() {
        return ratio;
    }

    public void setRatio(HashMap<String, String> ratio) {
        this.ratio = ratio;
    }
}
