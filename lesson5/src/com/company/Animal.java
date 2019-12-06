package com.company;

public class Animal {
    // Свойство объекта
    public float weight;
    public String color;
    private float height;
    protected int age;

    //Методы
    public void  eat() {
        System.out.println("Animal eat");
    }

    void  sleep() {
        System.out.println("Animal sleep");
    }
        // перегрузка метода sleep
    void sleep(int h) {
        System.out.println("Animal sleep");
        System.out.println(h);
        System.out.println(" hours");
    }
    void sleep(int h, int m) {
        System.out.println("Animal sleep");
        System.out.println(h);
        System.out.println(" hours and");
        System.out.println(m);
        System.out.println(" minutes");
    }

}
