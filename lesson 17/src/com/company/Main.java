package com.company;

import java.util.Map;

public class Main {

    public static void main(String[] args) {

//////////////////Аргументы командной строки\\\\\\\\\\\\\\\\\\\\\\
      int sun = 0;
      for (String are : args) {
        int d = Integer.parseInt(are);
        sun += d;
      }
      System.out.println("Сумма чисел = " + sun);

      ///////////////Системные переменные\\\\\\\\\\\\\\\\\\\
      //getenv - возвращает список системных переменных
      //(переменных среды)
      Map<String,String> envs = System.getenv();
      System.out.println("JAVA_HOME = " + envs.get("JAVA_HOME"));
      System.out.println(System.getenv("TEMP"));

    }
}
