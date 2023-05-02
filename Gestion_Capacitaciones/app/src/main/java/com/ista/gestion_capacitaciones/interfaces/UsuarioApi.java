package com.ista.gestion_capacitaciones.interfaces;

import com.ista.gestion_capacitaciones.model.Persona;
import com.ista.gestion_capacitaciones.model.Usuario;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.DELETE;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Path;

public interface UsuarioApi {

    @GET("api/usuarios/listar")
    Call<List<Usuario>> getUsuariosList();

    @GET("api/usuarios/search/{username}")
    Call<Usuario> obtenerUsuario(@Path("username")String id);

    @POST("api/usuarios/signin")
    Call<Usuario> IniciarSesion(@Body Usuario usuario);

    @POST("api/usuarios/signup")
    Call<Usuario> create(@Body Usuario usuario);

    @PUT("api/usuarios/actualizar/{id}")
    Call<Usuario> actualizarUsuario(@Path("id")Long id,@Body Usuario usuario);

    @DELETE("api/usuarios/eliminar/{id}")
    Call<Void> eliminar(@Path("id")Long id);

    @GET("api/usuario/login/{username}/{password}")
    Call<Usuario> login(@Path("username") String username, @Path("password") String password);

}
