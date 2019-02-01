package com.example.a96653.LetsCode;

import java.util.ArrayList;
import java.util.List;
public class Lesson {
    private int num;
    private String name;
    ArrayList<Lesson> l=new  ArrayList<Lesson>();

    public Lesson() {
    Lesson l0 = new Lesson(0, "firstlevel_1");
    Lesson l1 = new Lesson(1, "firstlevel_1");
    Lesson l2 = new Lesson(2, "firstlevel_2");
    Lesson l3 = new Lesson(3, "firstlevel_3");
        Lesson l4 = new Lesson(4, "firstlevel_4");
        Lesson l5 = new Lesson(5, "firstlevel_5");
        Lesson l6 = new Lesson(6, "firstlevel_6");
        Lesson l7 = new Lesson(7, "firstlevel_7");
      l=new  ArrayList<Lesson>();
      l.add(l0);
        l.add(l1);
        l.add(l2);
        l.add(l3);
        l.add(l4);
        l.add(l5);
        l.add(l6);
        l.add(l7);

    }



    public Lesson(int num,String name) {
        this.num = num;
        this.name=name;

    }

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
public String getName(int lnumber) {
        Lesson n=(Lesson)l.get(lnumber);
        return n.getName();

}
}
