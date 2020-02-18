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
        Thread ct = Thread.currentThread();
        synchronized (ct) {
          try {
            ct.wait();
          } catch (InterruptedException e) {
            e.printStackTrace();
          }
          for (int i = 0; i < 100000; i++) {
            m.calc(1);
            m.calc2(1, "A");
          }
        }
      }
    });
    Thread tt2 = new Thread(new Runnable() {
      @Override
      public void run() {
        Thread ct = Thread.currentThread();
        System.out.println(ct.getName());
        try {
          Thread.sleep(1000);
        } catch (InterruptedException e) {
          e.printStackTrace();

        }
        System.out.println("\n" + ct.getName() + "wake up\n");

        for (int i = 0; i < 100000; i++) {
          if (i == 1000) {
            synchronized (tt1) {
              System.out.println("\n" +tt1.getState());
              tt1.notifyAll();
            }
          }
            m.calc(-1);
            m.calc2(-1, "B");
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

    //currentThread - Возвращает объект текущего потока
    Thread ct = Thread.currentThread();
    System.out.println(ct.getName());
    //sleep - останавливает работу потока на заданное время
    try {
      Thread.sleep(100);
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
    // wait - приостанавливает работу потока до наступления события о пробуждении
    try {
      //ct.wait() - ! не вызывать в основном потоке
    } catch (Exception e) {
      e.printStackTrace();
    }
    //notify, notifyAll - создают для потока событие, чтобы тот пробудился
    //ct.notify();
    //getState - Возвращает текущее состояние потока
    System.out.println(ct.getState());
    //interrupt - прерывает выполнение потока
    ct.interrupt();
    //yield - Завершает квант времени работы текущего потока и переключается на следующий
    Thread.yield();
    //setPriority - задает приоритет потока (чем выше, тем больше квант потока)
    ct.setPriority();
  }
}
