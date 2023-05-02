package com.ista.gestion_capacitaciones.interfaces;

import com.ista.gestion_capacitaciones.model.Participante;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.DELETE;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Path;

public interface ParticipanteApi {

    @GET("api/participante/listar")
    Call<List<Participante>> obtenerLista();

    @GET("api/participante/buscar/{id}")
    Call<Participante> getById(@Path("id")Long id);

    @POST("api/participante/crear")
    Call<Participante> crear(@Body Participante participante);

    @PUT("api/participante/actualizar/{id}")
    Call<Participante> actualizarParticipante(@Path("id")Long id,@Body Participante participante);

    @DELETE("api/participante/eliminar/{id}")
    Call<Void> eliminar(@Path("id")Long id);


}
