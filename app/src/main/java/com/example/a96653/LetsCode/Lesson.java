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
        Lesson l8 = new Lesson(8, "firstlevel_resultsheet");
        Lesson l9 = new Lesson(9, "secondlevel_1");
        Lesson l10= new Lesson(10, "secondlevel_2");
        Lesson l11 = new Lesson(11, "secondlevel_3");
        Lesson l12 = new Lesson(12, "secondlevel_4");
        Lesson l13 = new Lesson(13, "secondlevel_5");
        Lesson l14 = new Lesson(14, "secondlevel_6");
        Lesson l15 = new Lesson(15, "seconlevel_8");
        Lesson l16 = new Lesson(16, "secondlevel_9");
        Lesson l17 = new Lesson(17, "secondlevel_11");
        Lesson l18 = new Lesson(18, "secondlevel_12");

      l=new  ArrayList<Lesson>();
      l.add(l0);
        l.add(l1);
        l.add(l2);
        l.add(l3);
        l.add(l4);
        l.add(l5);
        l.add(l6);
        l.add(l7);
        l.add(l8);
        l.add(l9);
        l.add(l10);
        l.add(l11);
        l.add(l12);
        l.add(l13);
        l.add(l14);
        l.add(l15);
        l.add(l16);
        l.add(l17);
        l.add(l18);
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
