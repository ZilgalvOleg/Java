package com.example.myfamily.model;

import com.google.gson.annotations.SerializedName;

public class LoginResponse {
    //Поля для отправки на сервер
    @SerializedName("result")
    public boolean result;
    @SerializedName("error")
    public String error;
    @SerializedName("token")
    public String token;//информация о пользователе (проверяет имеем ли доступ к тому или иному свойству)

}
