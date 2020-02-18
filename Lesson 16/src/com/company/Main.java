package com.company;

import java.io.*;
import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {
      //////////////////Серилизация\\\\\\\\\\\\\\\\\\\\\\\\
      User user = new User("Vasya", 20);
      user.height = 120.0f;
      try {
        FileOutputStream fos = new FileOutputStream("user.bir");
        ObjectOutputStream oos = new ObjectOutputStream(fos);
        oos.writeObject(user);
        oos.close();
        fos.close();
      } catch (Exception e) {
        e.printStackTrace();
      }
     ///////////ДЕСерилизация\\\\\\\\\\\\
      try {
        FileInputStream fis = new FileInputStream("user.bir");
        ObjectInputStream ois = new ObjectInputStream(fis);
        User user1 = (User)ois.readObject();
        ois.close();
        fis.close();
        System.out.println(user1.name);
        System.out.println(user1.age);
        System.out.println(user1.height);
      } catch (Exception e) {
        e.printStackTrace();
      }
      //////////Серилизация коллекции\\\\\\\\\\\\\\\
      ArrayList<User> users = new ArrayList<>();
      users.add(new User("Misha",12));
      users.add(new User("Masha",13));
      users.add(new User("Grisha",25));
      try {
      FileOutputStream fos = new FileOutputStream("users.bir");
      ObjectOutputStream oos = new ObjectOutputStream(fos);
      oos.writeObject(users);
      oos.close();
      fos.close();
    } catch (Exception e) {
    e.printStackTrace();
    }
      //////////ДЕСерилизация коллекции\\\\\\\\\\\\\\\
      try {
        FileInputStream fis = new FileInputStream("users.bir");
        ObjectInputStream ois = new ObjectInputStream(fis);
        ArrayList<User> people = (ArrayList<User>)ois.readObject();
        ois.close();
        fis.close();
        for (User u : people){
          System.out.println(u.name);
          System.out.println(u.age);
        }
      } catch (Exception e) {
        e.printStackTrace();
      }
    }
}
