package com.company;

import java.io.*;

public class Main {

    public static void main(String[] args) {
	// файл File с точки зрения java
        //Абсолютный путь к файлу
        File f = new File("C\\Programs\\1.txt");
        if (f.exists()) {
            System.out.println("Файл существует");
        }else {
            System.out.println("Файл не существует");
        }

        // относительный путь к файлу
        File ff = new File("1.txt");
        if (!ff.exists()){
            try {
                ff.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        //Проверяем файл на доступностьзаписи
        //(выставлен ли знак "только для чтения"
        System.out.println(ff.canRead());
        //Delete удаляет файл сразу после вывода метода
        //ff.delete()
        //deleteOnExit удаляет файл после завершения программы
        //ff.deleteOnExit();
        //работа с папкой
        File dir = new File("D:\\Eclipse Portable");
               String []files = dir.list();
               for (int i = 0; i <files.length; i++){
                  System.out.println(files[i]);
               }
        File dir2 = new File("D:\\Test\\Hello");
               if (!dir2.exists()){
                   //mkdir создает только послднюю папку по указанному пути
                   //dir2.mkdir();
                   //mkdirs создает все папки по указанному пути
                   dir2.mkdirs();

               }
        //Чтение текстового файла
        try {
            FileReader fr = new FileReader(ff);
            int c = fr.read();
            while (c != - 1){
                System.out.print((char)c); //преобразование int в char
                c = fr.read();
            }
            fr.close();//Закрывает файл
        } catch (IOException e) {
            e.printStackTrace();
        }
        //Запись в Файл
        try {
            FileWriter fw = new FileWriter("2.txt");//перад записью информация удаляется
            fw.write("Hello World\nПривет Мир\n");
            fw.close();//Закрывает файл
        } catch (IOException e) {
            e.printStackTrace();
        }
        //преобразование строки в число
        try {
            FileReader fr2 = new FileReader("input.txt");
            int[]numbers = new int[6];
            int c =fr2.read();
            String number = "";
            while (c != -1){
                if ((char)c == ' '){
                    int v = Integer.parseInt(number);
                    System.out.println(v * v);
                    number = "";
                }else {
                    number += (char) c;
                }
                c = fr2.read();

            }

            } catch (IOException e) {
            e.printStackTrace();
        }


    }
}
