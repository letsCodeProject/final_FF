package com.example.a96653.practice;

public class child {
    int id;
    String name;
    int score;



    public child (int id, String name, int score) {
        this.id=id;
        this.name=name;
        this.score=score;
    }
    //setters and getters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }
}
