package com.company;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
	Bankomat bankomat = new Bankomat();
        Scanner sc = new Scanner(System.in);
        System.out.println("Вставьте карту (ввидите номер карточки)");
        String cardID = sc.nextLine();
        boolean success = false;
        for (int i = 0; i <3; i++){
            System.out.println("Введите пин-код");
            String pin =sc.nextLine();
            if (bankomat.checkPin(cardID,pin)){
                success = true;
                break;
            }
            System.out.println("Неверный пин-код");
        }
        if (!success){
            System.out.println("Ваша карта заблакирована");
            return;
        }
        while (true){
            System.out.println("Главное меню");
            System.out.println("1. Показать баланс");
            System.out.println("2. Снять наличные");
            System.out.println("3. Пополнить баланс");
            System.out.println("4. Закончить работу");
            int menu = sc.nextInt();
            switch (menu){
                case 4:
                    bankomat. reject();
                    System.out.println("Заберите вашу карту");
                    return;
                case 1:
                    float balanse = bankomat.getBalance();
                    System.out.println(balanse);
                    break;
                case 2:
                    System.out.println("Введите сумму");
                    float cach = sc.nextFloat();
                    bankomat.getCash(cach);
                    break;
                case 3:
                    System.out.println("Введите сумму");
                    cach = sc.nextFloat();
                    bankomat.addCash(cach);
                    break;
                    default:
                        System.out.println("Введите корректный №");
                        break;

            }
        }
    }
}
