package com.company;

public class User {
    private String name;
    private int age;

    @Override
    public boolean equals(Object obj) {
        //явно преобразуем obj к типу User
        //если явное преобразовани невозможно,
        //то в результате преобразования мы получим
        //значение null
        User user = (User) obj;
        //поскольку свойство name вляется объектом типа String, то его сравнение должно
        //производиться через метод equals
        return this.age == user.age && this.name.equals(user.name);
    }

    @Override
        public int hashCode(){
        //обязательно должно соблюдаться правило,
        //если y.equals() == true,  то и x.hashCode()== y.hashCode() == true,
        //то и x.equals(y) должно возвращать true
        if (this.age > 18) {
            return 1;
        }
            return 2;

    }
    @Override
        public String toString() {
        return this.name;
    }
    // геттер свойства name
    public String getName(){
        return this.name;
    }
    //сеттер свойства name
    public void setName (String name) {
        this.name = name;
    }
    public int getAge(){
        return this.age;
    }
    public void setAge(int age){
        if (age < 0 || age >120){
            System.out.println("Недопустимое значение");
        }else {
            this.age = age;

        }

    }
}



