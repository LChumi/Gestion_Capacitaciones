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

    @GET("usuarios/users/list")
    Call<List<Usuario>> getUsuariosList();

    @GET("usuarios/search/{username}")
    Call<Usuario> obtenerUsuario(@Path("username")String username);

    @POST("usuarios/signin")
    Call<Usuario> IniciarSesion(@Body Usuario usuario);

    @POST("usuarios/signup")
    Call<Usuario> create(@Body Usuario usuario);

    @PUT("usuarios/actualizar/{id}")
    Call<Usuario> actualizarUsuario(@Path("id")Long id,@Body Usuario usuario);

    @DELETE("usuarios/delete/{usuarioId}")
    Call<Void> eliminar(@Path("id")Long id);

    @GET("usuarios/login/{username}/{password}")
    Call<Usuario> login(@Path("username") String username, @Path("password") String password);



}
