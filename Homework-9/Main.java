package com.company;


import java.util.ArrayList;
import java.util.Iterator;

public class Main {
    public static void main(String[] args) {
        Information info = new Information();
        InitializationData init = new InitializationData();
        init.addingValues(info);
        System.out.println(info.getNickname().size() + "/" + info.getMail().size() + "/" + info.getRatio().size());
        ArrayList<Number> list = new ArrayList<>();
        list.add(55);
        list.add(35);
        list.add(45);
        processingArrayLists(list, info);
        for (int i = 0; i <= info.getNickname().size() - 1; i++) {
            System.out.println(info.getNickname().get(i));
        }
        for (Iterator iter = info.getMail().iterator(); iter.hasNext(); ) {
            System.out.print(iter.next() + "\n");
        }
    }

    private static ArrayList processingArrayLists(ArrayList<? extends Number> list, Information info) {
        for (int i = 0; i <= list.size() - 1; i++) {
            if (!info.getRatio().containsKey(list.get(i).toString() + "Alex@mail.com")) {
                info.getRatio().put(list.get(i).toString() + "Alex@mail.com", list.get(i).toString());
            }
            info.getNickname().add(list.get(i).toString() + "Alex");
            info.getMail().add(list.get(i).toString() + "Alex@mail.com");
        }
        return list;
    }
}


