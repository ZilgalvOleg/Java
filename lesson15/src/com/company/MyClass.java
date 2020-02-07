package com.company;

public class MyClass {
  public int value;
  public int value2;

  //synchronized  - любой поток, который будет обращаться к методу
  //caic, будет становиться в очередь и дожидаться окончания работы
  //потока, который в данный момент вызывает этот метод

  public synchronized void calc (int d){
    this.value += d;
  }

  /*
  тоже самое что
  public void calc (int d){
  synchronized (this){
    this.value += d;
    }
   */
  public void calc2(int d, String c){
    System.out.print(c);
    synchronized (this){
      this.value2 +=d;
    }
  }
}
