package com.example.myfamily.model;

import com.google.gson.annotations.SerializedName;

public class JoinResponse {
    @SerializedName("result")
    public boolean result;
    @SerializedName("error")
    public String error;
}
