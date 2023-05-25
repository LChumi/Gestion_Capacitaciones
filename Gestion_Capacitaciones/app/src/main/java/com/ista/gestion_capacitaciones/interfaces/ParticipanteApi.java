/*
 *
 *   Created Luis Chumi on 23/5/23 9:38
 *   Copyright Ⓒ 2023. All rights reserved Ⓒ 2023 http://freefuninfo.com/
 *   Last modified: 17/5/23 17:13
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

import com.ista.gestion_capacitaciones.model.Participante;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.DELETE;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Path;

public interface ParticipanteApi {

    @GET("api/participante/listar")
    Call<List<Participante>> obtenerLista();

    @GET("api/participante/buscar/{id}")
    Call<Participante> getById(@Path("id")Long id);

    @POST("api/participante/crear")
    Call<Participante> crear(@Body Participante participante);

    @PUT("api/participante/actualizar/{id}")
    Call<Participante> actualizarParticipante(@Path("id")Long id,@Body Participante participante);

    @DELETE("api/participante/eliminar/{id}")
    Call<Void> eliminar(@Path("id")Long id);

    @GET("api/participante/participantesPersonaCurso/{idPersona}")
    Call<List<Participante>> getCoursesByParticipante(@Path("idPersona")Long idPersona);

    @GET("api/participante/listarparticipantes/{curId}")
    Call<List<Participante>> getListParticipanteByCourses(@Path("curId") Long curId);

    @GET("api/participante/participantesPorhorarioc/{idCurso}/{idHorarioc}")
    Call<List<Participante>> getListByHorarios(@Path("idCurso")Long idCurso,@Path("idHorarios")Long idHorarios);

}
