package com.mobinius.unittestapp;

/**
 * Created by prajna on 15/11/16.
 */

public class StudentClass {
    private String name, rollno, result;

    public StudentClass(String name, String rollno, String result) {
        this.name = name;
        this.rollno = rollno;
        this.result = result;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRollno() {
        return rollno;
    }

    public void setRollno(String rollno) {
        this.rollno = rollno;
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }
}
