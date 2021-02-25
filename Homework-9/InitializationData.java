package com.company;

import java.util.*;

public class InitializationData {

    public Information addingValues(Information info) {
        info.setNickname(new ArrayList<>());
        info.setMail(new HashSet<>());
        info.setRatio(new HashMap<>());
        for (int i = 1; i <= 30; i++) {
            info.getNickname().add(i + "Alex");
            info.getMail().add(i + "Alex@mail.com");
            info.getRatio().put(i + "Alex@mail.com", i + "Alex");
        }
        for (int i = 31; i <= 40; i++) {
            int alex31 = 31;
            if (!info.getNickname().contains(alex31 + "Alex")) {
                info.getNickname().add(alex31 + "Alex");
            }
            info.getMail().add(alex31 + "Alex@mail.com");
            info.getRatio().put(alex31 + "Alex@mail.com", i + "Alex");
        }
        return checkSizeMethod(info);
    }

    private Information checkSizeMethod(Information info) {
        if (info.getRatio().size() == info.getMail().size() && info.getNickname().size() == info.getRatio().size()) {
            return info;
        } else {
            System.out.println("Error");
            return null;
        }
    }
}
