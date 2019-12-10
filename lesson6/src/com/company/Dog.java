package com.company;

public class Dog extends Animal {
    public String name;
    // Статические свойства распологаются в памяти в единственном экземпляре
    public static int footCount;


    public Dog (){
        super("green",5 );
        name = "sad";
        Cat cat = new Cat();
        }
     public Dog (String color, int age, String name){
        super(color, age);
        this.name = name;
     }
     //say определение родительского абстрактного метода say
     public void say (String sound) {
      System.out.println("haw-haw" + sound);
     }
     //Внутренний класс
     public static class Cat {
        public String name;
        Cat(){
            this.name = "I am a Cat";
            name = "I am a Dog";
        }
     }
     private class Mouse {
        Mouse() {
            name = "I am mouse";
        }
     }
     public static void barc (){
        // this.name = "asd"; - ошибка
        // для статических методов нельзя использовать ссылку на экземпляр объекта
        System.out.println("barc");
     }
     public static void sleep(){
        System.out.println("z-z-z-z-z");
     }

}
