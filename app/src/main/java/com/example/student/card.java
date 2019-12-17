package com.example.student;

public class card {
    private String studname,roll,bod;

    public void change(String text)
    {
        studname = text;

    }

    public card(String studdata,String roll,String bod) {
        this.studname = studdata;
        this.roll = roll;
        this.bod = bod;


    }
    public String getStuddata()
    {
        return studname;
    }

    public String getRoll() {
        return roll;
    }

    public String getBod() {
        return bod;
    }
}
