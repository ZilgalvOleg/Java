package com.company;

public class Main {

    public static void main(String[] args) {
        /*Animal animai = new Animal("white", 10);
        System.out.println(animai.color);
        System.out.println(animai.age);
        Animal animal2 = new Animal("red", 15);
        System.out.println(animal2.color);
        System.out.println(animal2.age);

         */
        Dog dog =new Dog();
        // обращение к статичесским полям класса осуществляется через название класа
        dog.footCount = 4;
        System.out.println(dog.footCount);

        System.out.println(dog.age);

        Dog dog2 = new Dog("blue",6,"rex");
        System.out.println(dog2.footCount);
        System.out.println(dog2.color);
        System.out.println(dog2.age);
        System.out.println(dog2.name);
        dog2.say(" aw-aw");

        Dog.Cat cat = new Dog.Cat();
        cat.name = "Rainbow";

        dog.barc();
        Dog.barc();
    }
}
