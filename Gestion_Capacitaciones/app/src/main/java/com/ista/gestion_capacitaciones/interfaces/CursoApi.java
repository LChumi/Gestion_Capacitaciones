package com.ista.gestion_capacitaciones.interfaces;

import com.ista.gestion_capacitaciones.model.Curso;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.DELETE;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Path;

public interface CursoApi {

    @GET("api/iCurso/listar")
    Call<List<Curso>> obtenerLista();

    @GET("api/iCurso/buscar/{id}")
    Call<Curso> getById(@Path("id")Long id);

    @POST("api/iCurso/crear")
    Call<Curso> crear(@Body Curso curso);

    @PUT("api/iCurso/actualizar/{id}")
    Call<Curso> actualizarUsuario(@Path("id")Long id,@Body Curso curso);

    @DELETE("api/iCurso/eliminar/{id}")
    Call<Void> eliminar(@Path("id")Long id);

}
