package com.example.myfamily.api;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class APIServise {
    private Retrofit mRetrofit;
    // Патерн Singleton
    private static APIServise instance;
    public static APIServise getInstance() {
        if (instance == null){
            //инициализация объекта instance
            instance = new APIServise();
            //патерн FabricBuilder (Фабричный конструктор)
            instance.mRetrofit = new Retrofit.Builder()
                    .baseUrl("http://48da1b80.ngrok.io")//указываем адрес сервера
                    .addConverterFactory(GsonConverterFactory.create())//конвертируем информацию из json в объект
                    .build();

        }
        return instance;
    }
    public MyFamily getAPI(){
        return mRetrofit.create(MyFamily.class);
    }
}
