package com.company;

public class Main {

    public static void main(String[] args) {
	User u = new User();
	u.language =  Language.BY;
	switch (u.language){
        case BY:
        case RU:
        case UA:
            System.out.println("Выбран Не Иностранный язык");
            break;
        case EN:
            System.out.println("Выбран Иностранный язык");
        }
        System.out.println(u.language);
	u.color = Color.GREEN;
	System.out.println(u.color.getValue());
        Math m = Math.SUM;
        System.out.println(m.action(23,40));
        m = Math.MULTIPLY;
        System.out.println(m.action(2,4));

        //Класс String
        String s = "Hello";
        String s2 = new String("не рекомендуется");//тоже что и предыдущая строка
        //StringBuilder
        StringBuilder sb = new StringBuilder("abcdfg");
        //append добавляет значение в конец исходной строки
        sb.append("hijk");
        System.out.println(sb);
        //StringBuffer == StringBuilder
        //StringBuffer - потокобезопасный

        //String
        String str = "  Hello World  ";
        //str.contains(World) - проверяет (то что в скобках) с основным текстом
        //charAt - возвращает индекс строки по указанному индексу
        System.out.println(str.charAt(2)); // []
        System.out.println (str.codePointAt(2));//возвращает код индекса строки по указанному индексу
        //str.equals() добуквено сравнивает
        //str.compareToIgnoreCase() большие и маленькие буквы равны при сравнении
        //getBytes - преобразует строу в масив байт
         byte[] b = str.getBytes();
         for (int i = 0; i <b.length; i++){
             System.out.println(b[i]);
         }
         //обратное преобразование масива байт в строку
        String strFromBytes = new String(b);
        System.out.println(strFromBytes);
        //equalsIgnoreCase сравнивает две строки между собой без учета регистра
        System.out.println ("abCDef".equalsIgnoreCase("ABCDEf"));
        //indexOf - возвращает индекс первого символа или строки в исходной строке
        //Если совпадений не найдено возвращает -1
        System.out.println(str.indexOf("Wor"));
        System.out.println(str.indexOf('$'));
        //lastIndexOf =IndexOf, только поиск начинается с конца исходной строки
        System.out.println("Hello".indexOf('l'));//2
        System.out.println("Hello".lastIndexOf('l')); //3
        //replace - заменяет подстроку в исходной строке
        String str2 = str.replace("Hello","Hi");
        System.out.println(str2);
        //split - разделяет строку по символу либо строке
        str.split(" ");
        "Hello All Hi".split(" ");//["Hello", "All", "Hi"]
        String[] chunks = str.split(" ");
        for (int i = 0; i < chunks.length; i++) {
            System.out.println(chunks[i]);
        }
        String[] chunks1 = str.split("l");
        for (int i = 0; i < chunks.length; i++) {
            System.out.println(chunks1[i]);
        }

        //substring - выделяет подстроку в строке
        System.out.println(str.substring(7,10));
        //приведение регистров
        System.out.println(str.toLowerCase());//нижний
        System.out.println(str.toUpperCase());//верхний


	}

}
