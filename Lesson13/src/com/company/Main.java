package com.company;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

public class Main {

    public static void main(String[] args) {

        //HashSet - Хранит не дублирующиеся (уникальные) элементы.
        HashSet<String> set = new HashSet<>();
        set.add("String 1");
        set.add("String 2");
        set.add("String 3");
        System.out.println("Коллекция после добавления");
        System.out.println(set);
        set.add("String 2");
        System.out.println("Коллекция после добавления дублирующего элемента");
        System.out.println(set);
        set.remove("String 2");
        System.out.println("Коллекция после удаления элемента");
        System.out.println(set);
        System.out.println(set.size());

        //Map - хранит элементы по принципу ключь - значение
        HashMap<String,Integer> map = new HashMap<>();
        map.put("Иванов", 1000);
        map.put("Петров", 2000);
        map.put("Сергеев", 500);
        System.out.println("Коллекция после добавления элемента");
        System.out.println(map);
        map.put("Петров", 3000);
        System.out.println("Коллекция после добавления дублирующего элемента");
        System.out.println(map);
        int value = map.get("Петров");
        System.out.println(value);
        //keySet - Возвращает множество ключей
        Set<String> keys = map.keySet();//keySet -Список всех ключей
        //values - Возвращает список значений
        System.out.println(keys);
        System.out.println(map.values());
        //remove - удаления элемента
        map.remove("Сергеев");
        System.out.println("Коллекция после удаления элемента");
        System.out.println(map);
        System.out.println(map.entrySet());

        ////////////// DATE ///////////////////

        Date d = new Date();
        //getTime - возвращает время в миллисекундах от 01/01/1970 (момент появления ОС Unix
        System.out.println (d.getTime());
        //заданное время
        Date d2 = new Date(1579022470855l);
        if (d.after(d2)) {
            System.out.println("d > d2");
            }
        if (d.before(d2)) {
            System.out.println("d < d2");
        }
        //Форматирование даты
        //Список patternов смотри в нете
        SimpleDateFormat df = new SimpleDateFormat("G 'hello' yyyy EEEE");
        System.out.println(df.format(d2));
        SimpleDateFormat df2 = new SimpleDateFormat("d/M/yyyy");
        Scanner sc = new Scanner(System.in);
        System.out.println("Введите дату");
        String date = sc.nextLine();

        try {
            Date d3 = df2.parse(date);//парсит в тот формат который вводили в конструкторе
            System.out.println(d3.getTime());
        } catch (ParseException e) {
            e.printStackTrace();
        }
        /////////////CALENDAR
        GregorianCalendar calendar = (GregorianCalendar) GregorianCalendar.getInstance();
        System.out.println (calendar.get(Calendar.MONTH));
        System.out.println (calendar.get(Calendar.WEEK_OF_YEAR));//Ctrl + B
        //set меняет нужный нам параметр даты
        calendar.set(Calendar.MONTH, Calendar.MAY);
        calendar.set(Calendar.MINUTE, 25);
        System.out.println(calendar);
        //add - добавляет значение
        calendar.add(Calendar.DAY_OF_MONTH, 28);
        System.out.println(calendar);
        calendar.add(Calendar.HOUR, -23);
        System.out.println(calendar);
        //roll изменяет конкретный парамет без изменения других
        calendar.roll(Calendar.DAY_OF_MONTH,30);
        System.out.println(calendar);
        if (calendar.isLeapYear(calendar.get(Calendar.YEAR))){
            System.out.println("Год Висакосный");
        }else {
            System.out.println("Год Не Висакосный");
        }

        }


}

