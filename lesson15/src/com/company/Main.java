package com.company;

public class Main {

  public static void main(String[] args) {
    //////////Многопоточность///////////
    long t = System.currentTimeMillis();
    for (int i = 0; i < 1000000; i++) {
      double d = Math.atan(12) * Math.sin(i * 9) * Math.exp(23 - 1) * Math.hypot(i, 100);
    }
    System.out.println(System.currentTimeMillis() - t);


    //
    Thread t1 = new  Thread(new Runnable() {
      @Override
      public void run() {
        for (int i = 0; i < 500000; i++) {
          double d = Math.atan(12) * Math.sin(i * 9) * Math.exp(23 - 1) * Math.hypot(i, 100);
        }

      }
    });
    MyThread t2 = new MyThread();
    t = System.currentTimeMillis();
    t1.start();
    t2.start();

    try {
      t1.join();
      t2.join();
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
    MyClass m = new MyClass();
    System.out.println(System.currentTimeMillis() - t);
    Thread tt1 = new Thread(new Runnable() {
      @Override
      public void run() {
        for (int i = 0; i<100000; i++){
          m.calc(1);
          m.calc2(1,"A");
        }
      }
    });
    Thread tt2 = new Thread(new Runnable() {
      @Override
      public void run() {
        for (int i = 0; i<100000; i++){
          m.calc(-1);
          m.calc2(-1,"B");
        }
      }
    });
    tt1.start();
    tt2.start();

    try {
      tt1.join();
      tt2.join();
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
    System.out.println(m.value);
    System.out.println(m.value2);
  }
}
