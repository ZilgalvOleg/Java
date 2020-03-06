package com.example.myfamily.api;

import com.example.myfamily.model.LoginRequest;
import com.example.myfamily.model.LoginResponse;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;

public interface MyFamily {
    @POST("/login")
    Call<LoginResponse> login (@Body LoginRequest r);
}
