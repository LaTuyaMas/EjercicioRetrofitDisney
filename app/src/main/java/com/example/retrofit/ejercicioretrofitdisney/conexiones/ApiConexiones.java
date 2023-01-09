package com.example.retrofit.ejercicioretrofitdisney.conexiones;

import com.example.retrofit.ejercicioretrofitdisney.modelos.Personaje;
import com.example.retrofit.ejercicioretrofitdisney.modelos.Respuesta;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface ApiConexiones {

    // Obtener página inicial
    @GET("/characters")
    Call<Respuesta> getPersonajes();

    // Obtener siguiente página
    @GET("/characters?")
    Call<Respuesta> getPage(@Query("page") String page);

    // Obtener un personaje
    @GET("/characters/{id}")
    Call<Personaje> getPersonaje(@Path("id") String id);
}
