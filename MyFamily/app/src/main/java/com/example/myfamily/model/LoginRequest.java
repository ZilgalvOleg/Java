package com.example.myfamily.model;

import com.google.gson.annotations.SerializedName;

public class LoginRequest {
    @SerializedName("email")
    public String email;
    @SerializedName("password")
    public String password;
}
