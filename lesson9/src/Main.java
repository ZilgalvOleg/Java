public class Main {

    public static void main(String[] args) {
        //Исключения
        //Системные исключения

        /*int a = 10;
        a = a / 0; */

        int index = 8;
        int []a = new int[3];
        try {
            // помещаем код, который потенцеально может вызвать исключения
            a[index] = 17;
            index = index / 0;
            System.out.println("Эта надпись не должна отобразиться");
        }
        catch (ArrayIndexOutOfBoundsException e) {
            e.printStackTrace();
            System.out.println("Что-то пошло не так :(");
       }
        catch (ArithmeticException e){
            e.printStackTrace();
            System.out.println("Деление на ноль");
        }
        System.out.println("Я не вылетела :)");
        // обработка и генерация пользовательских исключений
        try {
          // try генерирует исключения
          throw new MyException();
        }
        catch (MyException e){
           System.out.println(e.getMessage());
           System.out.println(e.timestamp);
        }
        try {
            test();
        } catch (MyException e) {
            System.out.println(e.getMessage());
        }
        catch (RuntimeException e) {}
        // Порядок catch -й имеет значение
        // класс Exception и Throwable всегда должны находиться ниже чем пользовательские исключения.
        // Если среди catch -й присутствует класс Exception и Throwable, то  этот catch сробатывает
        //в том случае, если не сработал не один из пользовательских классов-исключений.
        try {
            test();
        }
        catch (Exception e) {
            System.out.println("????????");
        }
        catch (Throwable e){}

        // Игра в угадай число
        Game game = new Game();
        game.start();
    }
    public static void  test ()throws MyException, RuntimeException{
        getManey(-100);
    }
    public static void getManey (int money) throws MyException, RuntimeException{
        if (money <= 0 || money > 1000 ) {
            throw new MyException();
        }
        System.out.println ("Деньги сняты");
        throw new RuntimeException();
    }
}
