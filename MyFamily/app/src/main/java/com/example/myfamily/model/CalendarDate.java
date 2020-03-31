package com.example.myfamily.model;

public class CalendarDate {
    public int year;
    public int month;
    public int day;

    public boolean isEmpty(){
        return this.year == 0 && this.month == 0 && this.day == 0;
    }

}
