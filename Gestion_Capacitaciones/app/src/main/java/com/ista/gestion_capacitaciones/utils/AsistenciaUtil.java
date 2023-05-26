/*
 *
 *   Created Luis Chumi on 25/5/23 0:29
 *   Copyright Ⓒ 2023. All rights reserved Ⓒ 2023 http://freefuninfo.com/
 *   Last modified: 23/5/23 9:38
 *
 *   Licensed under the Apache License, Version 2.0 (the "License"); you may not use this file
 *   except in compliance with the License. You may obtain a copy of the License at
 *   http://www.apache.org/licenses/LICENS... Unless required by applicable law or agreed to in writing, software
 *    distributed under the License is distributed on an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND,
 *    either express or implied. See the License for the specific language governing permissions and
 *    limitations under the License.
 * /
 */

package com.ista.gestion_capacitaciones.utils;

import android.util.Log;

import com.ista.gestion_capacitaciones.api.clients.AsistenciaApiClient;
import com.ista.gestion_capacitaciones.api.clients.ParticipanteApiClient;
import com.ista.gestion_capacitaciones.db.DbAsistencias;
import com.ista.gestion_capacitaciones.model.Asistencia;
import com.ista.gestion_capacitaciones.model.Participante;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class AsistenciaUtil {

    private static final ArrayList<Participante> detalleAsistencia = new ArrayList<>();

    public static String agregarAsistencias(List<Participante> participantes, List<Integer> numFaltas) {
        for (int i = 0; i < participantes.size(); i++) {
            Participante participante = participantes.get(i);
            // Verifica que asistencia no sea nula antes de agregarla a la lista
            if (participante.getAsistencias() == null) {
                participante.setAsistencias(new ArrayList<>());
            }

            int num = numFaltas.get(i);
            Asistencia asistencia = new Asistencia();
            asistencia.setAsiNumfaltas(num);
            asistencia.setAsiEstado(true);
            asistencia.setAsiParticipante(participante);
            // Agregar asistencia a la lista
            participante.getAsistencias().add(asistencia);
            // Guardar asistencia en la API
            guardarAsistenciaEnApi(asistencia,participante);



        }

        return "Asistencias guardadas";
    }


    private static void guardarAsistenciaEnApi(Asistencia asistencia,Participante p) {
        AsistenciaApiClient apiClient = new AsistenciaApiClient();
        Call<Asistencia> call = apiClient.crear(asistencia);
        call.enqueue(new Callback<Asistencia>() {
            @Override
            public void onResponse(Call<Asistencia> call, Response<Asistencia> response) {
                if (response.isSuccessful()) {
                    asignarParticipanteAsistencia(response.body().getAsiId(),p.getParId());

                } else {
                    Log.e("error", "Error al guardar la asistencia. Código de error: " + response.code());
                }
            }

            @Override
            public void onFailure(Call<Asistencia> call, Throwable t) {
                Log.e("ERROR", "Error al guardar la asistencia: " + t.getMessage());
            }
        });
    }

    private static  void asignarParticipanteAsistencia(Long id,Long p){
        AsistenciaApiClient apiClient=new AsistenciaApiClient();
        Call<Asistencia> call=apiClient.addAsistencia(id,p);

        call.enqueue(new Callback<Asistencia>() {
            @Override
            public void onResponse(Call<Asistencia> call, Response<Asistencia> response) {
                if (response.isSuccessful()){
                    Log.i("Datos", "Asistencia guardada correctamente: " + response.body());
                }
                else {
                    Log.i("Datos", "Error al guardar la asistencia. Código de error: " + response.code());
                }
            }

            @Override
            public void onFailure(Call<Asistencia> call, Throwable t) {
                Log.e("ERROR", "Error al guardar la asistencia: " + t.getMessage());
            }
        });
    }




    private static void guardarAsistenciaEnBaseDeDatos(Asistencia asistencia, DbAsistencias dbAsistencia) {
        long result = dbAsistencia.insertarAsistencia(asistencia.getAsiNumfaltas(), asistencia.getAsiFecha(), asistencia.getAsiParticipante().getParId());
        if (result > 0) {
            // Asistencia guardada en la base de datos local correctamente
        } else {
            // Error al guardar la asistencia en la base de datos local
        }
    }
}

