package com.example.myfamily.api;

import com.example.myfamily.model.ConfirmRequest;
import com.example.myfamily.model.ConfirmResponse;
import com.example.myfamily.model.JoinRequest;
import com.example.myfamily.model.JoinResponse;
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
    @POST("/register")
    Call<RegistrationResponse> registration(@Body RegistrationRequest r);
    @POST("/submit")
    Call<ConfirmResponse> confirm(@Body ConfirmRequest r);
    @POST("/join")
    Call<JoinResponse> join (@Body JoinRequest r);

}
