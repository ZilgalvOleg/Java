package com.company;

public class MyThread extends Thread {
  @Override
  public void run(){
    for (int i = 500000; i < 1000000; i++) {
      double d = Math.atan(12) * Math.sin(i * 9) * Math.exp(23 - 1) * Math.hypot(i, 100);
    }

  }
}
