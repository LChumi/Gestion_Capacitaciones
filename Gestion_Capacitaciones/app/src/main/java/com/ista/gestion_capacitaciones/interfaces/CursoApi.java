/*
 *
 *   Created Luis Chumi on 23/5/23 9:38
 *   Copyright Ⓒ 2023. All rights reserved Ⓒ 2023 http://freefuninfo.com/
 *   Last modified: 17/5/23 17:28
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
