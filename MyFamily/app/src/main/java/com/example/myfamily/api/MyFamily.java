package com.example.myfamily.api;

import com.example.myfamily.model.AddFinanceRequest;
import com.example.myfamily.model.AddFinanceResponse;
import com.example.myfamily.model.ConfirmRequest;
import com.example.myfamily.model.ConfirmResponse;
import com.example.myfamily.model.FinanceResponse;
import com.example.myfamily.model.JoinRequest;
import com.example.myfamily.model.JoinResponse;
import com.example.myfamily.model.LoginRequest;
import com.example.myfamily.model.LoginResponse;
import com.example.myfamily.model.RegistrationRequest;
import com.example.myfamily.model.RegistrationResponse;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Query;

public interface MyFamily {
    @POST("/login")
    Call<LoginResponse> login (@Body LoginRequest r);
    @POST("/register")
    Call<RegistrationResponse> registration(@Body RegistrationRequest r);
    @POST("/submit")
    Call<ConfirmResponse> confirm(@Body ConfirmRequest r);
    @POST("/join")
    Call<JoinResponse> join (@Body JoinRequest r);
    @GET("/finance")
    Call<FinanceResponse> getFinance (@Query("startAt")String start, @Query("endAt")String end);
    //Дополнительные параметры в запросе передаются в Query(часть адреса расположенная после знака ?)
    //Параметры задаются в виде key=value
    //Между собой параметры разделяются знаком &
    //<server>/finance?startAt=01-01-2020&endAt=31-01-2020
    //Чтобы задать Query параметр в Retrofit необходимо использовать директиву @Query("key"),
    //где key - название параметра.
    //Ретрафит автоматически задаст параметры значения указанное в аргументе следующем за директивой.
    @PUT("/finance")
    Call<AddFinanceResponse> addFinance (@Body AddFinanceRequest req);


}
