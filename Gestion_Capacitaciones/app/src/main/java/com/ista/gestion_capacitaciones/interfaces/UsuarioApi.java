/*
 *
 *   Created Luis Chumi on 23/5/23 9:38
 *   Copyright Ⓒ 2023. All rights reserved Ⓒ 2023 http://freefuninfo.com/
 *   Last modified: 18/5/23 9:20
 *
 *   Licensed under the Apache License, Version 2.0 (the "License"); you may not use this file
 *   except in compliance with the License. You may obtain a copy of the License at
 *   http://www.apache.org/licenses/LICENS... Unless required by applicable law or agreed to in writing, software
 *    distributed under the License is distributed on an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND,
 *    either express or implied. See the License for the specific language governing permissions and
 *    limitations under the License.
 * /
 */

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

    @GET("/usuarios/login/{username}/{password}")
    Call<Usuario> login(@Path("username") String username, @Path("password") String password);

    @GET("/usuarios/buscar/{id}")
    Call<Usuario> getById(@Path("id")Long id);


}
