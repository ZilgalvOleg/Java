package com.example.myfamily.model;

import com.google.gson.annotations.SerializedName;

public class RegistrationRequest {
    @SerializedName("name")
    public String name;
    @SerializedName("pasword")
    public String pasword;
    @SerializedName("email")
    public String email;
}
