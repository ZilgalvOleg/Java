package com.example.myfamily.api;

import com.example.myfamily.model.ConfirmRequest;
import com.example.myfamily.model.ConfirmResponse;
import com.example.myfamily.model.LoginRequest;
import com.example.myfamily.model.LoginResponse;
import com.example.myfamily.model.RegistrationRequest;
import com.example.myfamily.model.RegistrationResponse;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;

public interface MyFamily {
    @POST("/login")
    Call<LoginResponse> login (@Body LoginRequest r);
    @POST("/registration")
    Call<RegistrationResponse> registration (@Body RegistrationRequest r);
    @POST("/confirm")
    Call<ConfirmResponse> registration (@Body ConfirmRequest r);

    Call<ConfirmResponse> confirm(ConfirmRequest r);
}
