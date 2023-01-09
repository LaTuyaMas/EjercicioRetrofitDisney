package com.example.retrofit.ejercicioretrofitdisney.conexiones;

import com.example.retrofit.ejercicioretrofitdisney.config.Constantes;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitObject {

    public static Retrofit getConexion(){
        return new Retrofit.Builder()
                .baseUrl(Constantes.baseURL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
    }
}
