/*
 *
 *   Created Luis Chumi on 23/5/23 9:38
 *   Copyright Ⓒ 2023. All rights reserved Ⓒ 2023 http://freefuninfo.com/
 *   Last modified: 21/5/23 20:27
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
