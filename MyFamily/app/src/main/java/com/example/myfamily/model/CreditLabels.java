package com.example.myfamily.model;

public enum CreditLabels {
    FOOD("Питание"),
    TRANSPORT("Транспорт"),
    ENTRTEINMENT("Развлечения"),
    OTHER("Другое.....");

    private String label;
    CreditLabels (String label){
        this.label = label;
    }
    public String get_Label(){
        return this.label;
    }
}
