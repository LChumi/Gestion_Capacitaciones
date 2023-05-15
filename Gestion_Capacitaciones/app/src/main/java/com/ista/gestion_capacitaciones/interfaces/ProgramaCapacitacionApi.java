package com.ista.gestion_capacitaciones.interfaces;

import com.ista.gestion_capacitaciones.model.ProgramaCapacitacion;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.DELETE;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Path;

public interface ProgramaCapacitacionApi {

    @GET("/api/programacapacitacion/listar")
    Call<List<ProgramaCapacitacion>> obtenerProgramas();

    @GET("/api/programacapacitacion/buscar/{id}")
    Call<ProgramaCapacitacion> getById(@Path("id")Long id);

    @POST("/api/programacapacitacion/crear")
    Call<ProgramaCapacitacion> crear(@Body ProgramaCapacitacion programa);

    @DELETE("/api/programacapacitacion/eliminar/{id}")
    Call<Void> eliminar(@Path("id")Long id);

    @PUT("/api/programacapacitacion/actualizar/{id}")
    Call<ProgramaCapacitacion> actualizar(@Path("id")Long id,
                                          @Body ProgramaCapacitacion capacitacion);

}
