package com.ista.gestion_capacitaciones.interfaces;

import android.app.Person;

import com.ista.gestion_capacitaciones.model.Persona;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.DELETE;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Path;

public interface PersonaApi {

    @GET("api/persona/listar")
    Call<List<Persona>> obtenerLista();

    @GET("api/persona/buscar/{id}")
    Call<Persona> getById(@Path("id")Long id);

    @POST("api/persona/crear")
    Call<Persona> crear(@Body Persona persona);

    @PUT("api/persona/actualizar/{id}")
    Call<Persona> actualizarUsuario(@Path("id")Long id,@Body Persona persona);

    @DELETE("api/persona/eliminar/{id}")
    Call<Void> eliminar(@Path("id")Long id);
}
