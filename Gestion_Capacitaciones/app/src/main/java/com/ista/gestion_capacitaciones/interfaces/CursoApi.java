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

    @GET("api/Curso/listar")
    Call<List<Curso>> obtenerLista();

    @GET("api/Curso/buscar/{id}")
    Call<Curso> getById(@Path("id")Long id);

    @POST("api/Curso/crear")
    Call<Curso> crear(@Body Curso curso);

    @PUT("api/Curso/actualizar/{id}")
    Call<Curso> actualizarCurso(@Path("id")Long id,@Body Curso curso);

    @DELETE("api/Curso/eliminar/{id}")
    Call<Void> eliminar(@Path("id")Long id);

    @GET("api/Curso/findByUser/{id_persona}")
    Call<List<Curso>> getByDocente(@Path("id_persona")Long id_persona);

    @GET("api/Curso/findBycursosprograma/{idPrograma}")
    Call<List<Curso>> getByPrograma(@Path("idPrograma")Long idPrograma);

}
