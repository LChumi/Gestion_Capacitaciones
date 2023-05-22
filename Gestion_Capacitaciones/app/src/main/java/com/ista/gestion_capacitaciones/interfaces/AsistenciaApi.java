package com.ista.gestion_capacitaciones.interfaces;


import com.ista.gestion_capacitaciones.model.Asistencia;
import com.ista.gestion_capacitaciones.model.Participante;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.DELETE;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Path;

public interface AsistenciaApi {

    @GET("api/asistencia/listar")
    Call<List<Asistencia>> obtenerLista();

    @GET("api/asistencia/buscar/{id}")
    Call<Asistencia> getById(@Path("id")Long id);

    @POST("api/asistencia/crear")
    Call<Asistencia> crear(@Body Asistencia asistencia);

    @PUT("api/asistencia/actualizar/{id}")
    Call<Asistencia> actualizarUsuario(@Path("id")Long id,@Body Asistencia asistencia);

    @DELETE("api/asistencia/eliminar/{id}")
    Call<Void> eliminar(@Path("id")Long id);

    @POST("api/asistencia/addParticipante/{idAsis}/{idPart}")
    Call<Asistencia> addAsistencia(@Path("idAsis")Long idAsis,@Path("idPart")Long idPart);
}
