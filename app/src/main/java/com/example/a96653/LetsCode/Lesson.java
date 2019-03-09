package com.example.a96653.LetsCode;

import java.util.ArrayList;
import java.util.List;
public class Lesson {
    private int num;
    private String name;
    private ArrayList<Lesson> l=new  ArrayList<>();

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
        //SECOND LEVEL LESSONS
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
        Lesson l19 = new Lesson(19, "secondlevel_14");
        Lesson l20 = new Lesson(20, "secondlevel_15");
        Lesson l21 = new Lesson(21, "secondlevel_16");
        Lesson l22 = new Lesson(22, "secondlevel_17");
        Lesson l23 = new Lesson(23, "secondlevel_18_quiz");
        Lesson l24 = new Lesson(24, "secondlevel_20");
        Lesson l25 = new Lesson(25, "secondlevel_22");
        Lesson l26 = new Lesson(26, "secondlevel_24");
        Lesson l27 = new Lesson(27, "secondlevel_26");
        Lesson l28 = new Lesson(28, "secondlevel_resultsheet");
        ///THIRD LEVEL LESSSONS
        Lesson l29 = new Lesson(29, "thirdlevel_1");
        Lesson l30 = new Lesson(30, "thirdlevel_2");
        Lesson l31 = new Lesson(31, "thirdlevel_3");
        Lesson l32 = new Lesson(32, "thirdlevel_4");
        Lesson l33 = new Lesson(33, "thirdlevel_5");
        Lesson l34 = new Lesson(34, "thirdlevel_6");
        Lesson l35 = new Lesson(35, "thirdlevel_7");
        Lesson l36 = new Lesson(36, "thirdlevel_8");
        Lesson l37 = new Lesson(37, "thirdlevel_9");
        Lesson l38 = new Lesson(38, "thirdlevel_10");
        Lesson l39 = new Lesson(39, "thirdlevel_11");
        Lesson l40 = new Lesson(40, "thirdlevel_12");
        Lesson l41 = new Lesson(41, "thirdlevel_14");
        Lesson l42 = new Lesson(42, "thirdlevel_15");
        Lesson l43 = new Lesson(43, "thirdlevel_16");
        Lesson l44 = new Lesson(44, "thirdlevel_17");
        Lesson l45 = new Lesson(45, "thirdlevel_18");
        Lesson l46 = new Lesson(46, "thirdlevel_19");
        Lesson l47 = new Lesson(47, "thirdlevel_20_question1");
        Lesson l48 = new Lesson(48, "thirdlevel_21");
        Lesson l49 = new Lesson(49, "thirdlevel_22");
        Lesson l50 = new Lesson(50, "thirdlevel_23");
        Lesson l51 = new Lesson(51, "thirdlevel_24");
        Lesson l52 = new Lesson(52, "thirdlevel_resultsheet");
        ///FOURTH LEVEL LESSSONS
        Lesson l53 = new Lesson(53, "fourthlevel_1");
        Lesson l54 = new Lesson(54, "fourthlevel_2");
        Lesson l55 = new Lesson(55, "fourthlevel_video");
        Lesson l56 = new Lesson(56, "fourthlevel_3");
        Lesson l57= new Lesson(57, "fourthlevel_4");
        Lesson l58 = new Lesson(58, "fourthlevel_5");
        Lesson l59 = new Lesson(59, "fourthlevel_6_quiz");
        Lesson l60 = new Lesson(60, "Fourthlevel_resultsheet");



        l=new  ArrayList<>();
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
        l.add(l19);
        l.add(l20);
        l.add(l21);
        l.add(l22);
        l.add(l23);
        l.add(l24);
        l.add(l25);
        l.add(l26);
        l.add(l27);
        l.add(l28);
        l.add(l29);
        l.add(l30);
        l.add(l31);
        l.add(l32);
        l.add(l33);
        l.add(l34);
        l.add(l35);
        l.add(l36);
        l.add(l37);
        l.add(l38);
        l.add(l39);
        l.add(l40);
        l.add(l41);
        l.add(l42);
        l.add(l43);
        l.add(l44);
        l.add(l45);
        l.add(l46);
        l.add(l47);
        l.add(l48);
        l.add(l49);
        l.add(l50);
        l.add(l51);
        l.add(l52);
        l.add(l53);
        l.add(l54);
        l.add(l55);
        l.add(l56);
        l.add(l57);
        l.add(l58);
        l.add(l59);
        l.add(l60);
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
        Lesson n=l.get(lnumber);
        return n.getName();

    }
}
