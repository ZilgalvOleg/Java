package com.company;

public class Bankomat implements BankomatImpl {
    private Card [] _cards;
    private Card _userCard;

    public Bankomat (){
        // В конструкторе мы создаем базу данных карточек
        this._cards = new Card[]{
                new Card ("1234567","1234", 1234),
                new Card ("3452541","7895", 23524),
                new Card ("2233558","4897", 124586),
        };
        //
    }
    public boolean checkPin (String cartID, String pin){
        int i = 0;
        for (; i < this._cards.length; i++){
            if (this._cards[i].ID.equals (cartID)) {
            this._userCard = this._cards[i];
            break;
            }
        }
        // found == false ; !found = true
        // found == true ; !found = false
        // ! инвертирует логическое значение, читается ка, "НЕ"
        if (this._userCard == null){ // null - нулевая ссылка (не указывает область памяти)
            System.out.println("Неверный ID карточки");
            return false;
        }
        //  проверяем ПИН-КОД
        return this._cards[i].PIN.equals(pin);

    }
    public float getBalance(){
        return this._userCard.MONEY;
    }

    public void getCash (float cash){
        if (cash > this._userCard.MONEY){
            System.out.println("недостаточно денег");
            }
        else {
            // this._userCard.MONEY = this._userCard.MONEY - cash;
            //-= отнимает и перезаписывает
            this._userCard.MONEY -= cash;
        }
    }
    public void addCash (float cash){
        this._userCard.MONEY += cash;
    }
    public void reject(){
        this._userCard = null;
    }

    class Card {
        String ID;
        String PIN;
        float MONEY;
        public Card (String id, String pin, float money){
            this.ID = id;
            this.PIN = pin;
            this.MONEY = money;
        }
    }
    }
