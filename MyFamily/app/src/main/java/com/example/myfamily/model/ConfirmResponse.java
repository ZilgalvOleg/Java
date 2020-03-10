package com.example.myfamily.model;

import com.google.gson.annotations.SerializedName;

public class ConfirmResponse {
    @SerializedName("result")
    public boolean result;
    @SerializedName("error")
    public String error;
    @SerializedName("token")
    public String token;
}
