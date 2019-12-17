package com.company;

public interface BankomatImpl {
    boolean checkPin (String cartID, String pin);
    float getBalance();
    void getCash (float cash);
    void addCash (float cash);
    void reject();
}
