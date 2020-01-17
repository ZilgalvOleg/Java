package com.company;

import java.util.*;

public class Main {

  public static void main(String[] args) {
    ////////////FILO - First in, last out
    //коллекция Stack
    Stack<String> stack = new Stack<>();

    //add - добавляет элемент в стек
    stack.add("element 1");
    stack.add("element 2");
    stack.add("element 3");
    System.out.println(stack);
    System.out.println();

    //pop - достает "верхний" элемент стека.
    System.out.println(stack.pop());
    System.out.println("Стек после вызова метода pop");
    System.out.println(stack);
    System.out.println();

    stack.push("element 4");
    System.out.println("Стек после вызова метода push");
    System.out.println(stack);
    System.out.println();

    //peek - возвращает "верхний "элемент стека без его удаления
    System.out.println(stack.peek());
    System.out.println("Стек после вызова метода peek");
    System.out.println(stack);
    System.out.println();

    System.out.print("Элемент \"element 2\" находиться по №:");
    System.out.println(stack.search("element 2"));
    //clear - удаляем все элементы стека
    stack.clear();
    try {
      System.out.println(stack.pop()); // при пустом методе будет ошибка
    } catch (EmptyStackException e) {
      System.out.println("Ошибка! стек пустой");
    }
    System.out.println();

    ///////////////Очередь Queue
    //FIFO - First in, First out
    Queue<String> queue = new PriorityQueue<>(3);
    queue.add("q 1");
    queue.add("q 2");
    queue.add("q 3");
    System.out.println(queue);

    //poll, remove - достает первый элемент очереди
    System.out.println(queue.poll());
    System.out.println(queue);
    System.out.println();

    //peek - Возвращает первый элемент очереди без удаления
    System.out.println(queue.peek());
    System.out.println(queue);
    System.out.println();

    //offer - Добавляет определенное колличество элементов "initialCapacety"
    if (queue.offer("q 4")) {
      System.out.println("элемент добавлен");
    } else {
      System.out.println("элемент добавить нельзя");
    }
    System.out.println(queue);
    System.out.println();

    UserComparator comparator = new UserComparator();
    Queue<User> users = new PriorityQueue<>(comparator);
    Random rand = new Random();
    for (int i = 0; i < 10; i++) {
      User u = new User();
      u.setMoney(rand.nextInt(1000));
      users.add(u);
    }
    while (true) {
      User u = users.poll();
      if (u == null)
        break;
      else
        System.out.println(u);

    }
    System.out.println();

    System.out.println(fact1(5));
    System.out.println();
    System.out.println(fact2(6));
    System.out.println();
  }
      /////////////рекурсия///////////
    //5! 1*2*3*4*5 = 120
    //0!=1
    //нахождение факториала
    public static int fact1 ( int n){
      int f = 1;
      for (; n != 1; n--) {
        f *= n; // f= f*n
      }
      return f;
    }
    public static int fact2 (int n){
    if (n == 0){
      return 1;
    }
    return n * fact2(n - 1);
    }
  }









