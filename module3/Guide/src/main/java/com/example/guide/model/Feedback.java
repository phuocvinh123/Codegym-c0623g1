package com.example.guide.model;

public class Feedback {
    private int id;
    private int Guide_id;
    private String Evaluate;

    public Feedback() {
    }

    public Feedback(int id, int guide_id, String evaluate) {
        this.id = id;
        Guide_id = guide_id;
        Evaluate = evaluate;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getGuide_id() {
        return Guide_id;
    }

    public void setGuide_id(int guide_id) {
        Guide_id = guide_id;
    }

    public String getEvaluate() {
        return Evaluate;
    }

    public void setEvaluate(String evaluate) {
        Evaluate = evaluate;
    }
}
