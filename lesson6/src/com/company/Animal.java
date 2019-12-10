package com.company;

// в java невозможно создать экземпляр объекта абстрактного класса
public abstract class Animal {
    public String color;
    public int age;
    /*
    public Animal() { // конструктор без с параметров
        color = "Black";
        age = 1;
        System.out.println("Animal was created");
    }

     */

    public Animal (String color, int age) { // конструктор с параметрами
        //this - указатель на тикущий экземпляр объекта
        this.color = color;
        this.age = age;
    }
    public abstract void say (String sound);
}
