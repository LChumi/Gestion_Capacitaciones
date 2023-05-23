/*
 *
 *   Created Luis Chumi on 23/5/23 9:38
 *   Copyright Ⓒ 2023. All rights reserved Ⓒ 2023 http://freefuninfo.com/
 *   Last modified: 16/5/23 22:00
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
