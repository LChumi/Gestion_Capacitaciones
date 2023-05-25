/*
 *
 *   Created Luis Chumi on 24/5/23 10:20
 *   Copyright Ⓒ 2023. All rights reserved Ⓒ 2023 http://freefuninfo.com/
 *   Last modified: 24/5/23 10:20
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

import com.ista.gestion_capacitaciones.model.FichaInscripcion;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.DELETE;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Path;

public interface FichaInscripcionApi {

    @GET("/api/FichaInscripcion/listar")
    Call<List<FichaInscripcion>> obtennerLista();

    @GET("/api/FichaInscripcion/buscar/{id}")
    Call<FichaInscripcion> getById(@Path("id")Long id);

    @POST("/api/FichaInscripcion/crear")
    Call<FichaInscripcion> crear(@Body FichaInscripcion fichaInscripcion);

    @DELETE("/api/FichaInscripcion/eliminar/{id}")
    Call<Void> eliminar(@Path("id")Long id);

    @PUT("/api/FichaInscripcion/actualizar/{id}")
    Call<FichaInscripcion> actualizar(@Path("id")Long id,@Body FichaInscripcion fichaInscripcion);
}
