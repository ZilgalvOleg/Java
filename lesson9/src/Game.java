import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;

public class Game {
    private int number;
    private int nCount;


    public Game(){
        //генерация случайных чисел
        //1-й способ
        //Double r = Math.random(); // r [0;1)
        //r * (max - min) + min; => [min;max]

        //2-й способ
        Random rand = new Random();
        this.number = rand.nextInt(100) + 1;
    }
    public void start () {
        Scanner sc = new Scanner(System.in);
        while (true) {
            System.out.println("Введите число");
            int user;
            try { // если пользователь введет не корректное число
                user = sc.nextInt();
            } catch (InputMismatchException e) {
                System.out.println("Введите корректное число");
                sc = new Scanner(System.in);
                continue;
            }
            this.nCount++;
            if (this.number == user) {
                System.out.println("Поздравляем!");
                System.out.print("Вы угадали число за " + this.nCount + " попыток");
                break;
            }
            if (this.number > user) {
                System.out.println("Загаданное число больше");
            }
            if (this.number < user) {
                System.out.println("Загаданное число меньше");
            }
        }
    }

}
