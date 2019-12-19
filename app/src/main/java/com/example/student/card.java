package com.example.student;

public class card {
    private String studname,roll,bod,fpath;

    public void change(String text)
    {
        studname = text;

    }

    public card(String studdata,String roll,String bod,String filepath) {
        this.studname = studdata;
        this.roll = roll;
        this.bod = bod;
        this.fpath =filepath;


    }
    public String getFpath()
    {
        return fpath ;
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
