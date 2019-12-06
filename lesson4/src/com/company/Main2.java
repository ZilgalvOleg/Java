package com.company;

public class Main2 {

    public static void main(String[] args) {
        // бинарные операторы
        //& - бинарное и
        System.out.println (5 & 7);
        //| - бинарное или
        System.out.println (5 | 7);
        // >> Бинарный сдвиг в право
        System.out.println (7 >> 2);
        // >> Бинарный сдвиг в лево
        System.out.println (5 << 3);
        // пример
        // 4 первых бита скорость (13)
        // 5-7 й биты напрежение (4)
        // 8-11 сила тока (9)
        // 1001 100 1101 = 1229
        int data = 1229;
        // 1 вариант
        int speed = data <<27;
        speed = speed >>27;
        System.out.println(speed);
        // 2 варинт Бинарная маска
        int maskSpeed = 15;
        speed = data & maskSpeed;
        System.out.println(speed);
        // напряжение
        int maskVoltage = 112;
        int Voltage = (data & maskVoltage) >> 4;
        System.out.println(Voltage);
        // Сила тока
        int curren = data >> 7;
        System.out.println(curren);
    }
}
