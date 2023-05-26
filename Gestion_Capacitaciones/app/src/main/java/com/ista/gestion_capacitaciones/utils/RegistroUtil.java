/*
 *
 *   Created Luis Chumi on 25/5/23 0:29
 *   Copyright Ⓒ 2023. All rights reserved Ⓒ 2023 http://freefuninfo.com/
 *   Last modified: 24/5/23 16:58
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

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.ista.gestion_capacitaciones.api.clients.CursoApiClient;
import com.ista.gestion_capacitaciones.api.clients.FichaInscripcionApiClient;
import com.ista.gestion_capacitaciones.api.clients.PersonaApiClient;
import com.ista.gestion_capacitaciones.api.clients.UsuariosApiClient;
import com.ista.gestion_capacitaciones.interfaces.FichaInscripcionApi;
import com.ista.gestion_capacitaciones.model.Curso;
import com.ista.gestion_capacitaciones.model.FichaInscripcion;
import com.ista.gestion_capacitaciones.model.HorarioCurso;
import com.ista.gestion_capacitaciones.model.Participante;
import com.ista.gestion_capacitaciones.model.Persona;
import com.ista.gestion_capacitaciones.model.Usuario;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class RegistroUtil {

    public static FichaInscripcion fichaInscripcion;

    public  void guardarFichaEnApi(FichaInscripcion f,Long idPerson,Long idCurso,Long idHorario){
        Log.i("Llegada",f.toString());
        f.setFinEstado(true);
        f.setFinAprobacion(0);
        FichaInscripcionApiClient apiClient=new FichaInscripcionApiClient();
        Call<FichaInscripcion> call=apiClient.crear(f);
        call.enqueue(new Callback<FichaInscripcion>() {
            @Override
            public void onResponse(Call<FichaInscripcion> call, Response<FichaInscripcion> response) {
                if (response.isSuccessful()){
                    addDependencies(idPerson,idCurso,idHorario,response.body().getFinId());
                }else{
                    Log.e("Error","Error al guardar la ficha"+response.toString());
                }
            }
            @Override
            public void onFailure(Call<FichaInscripcion> call, Throwable t) {
                Log.e("ERROR","Error al guardar"+t.getMessage());
            }
        });
    }

    public void addDependencies(Long idPersona,Long idCurso,Long idHorario,Long idFicha){
        FichaInscripcionApiClient apiClient=new FichaInscripcionApiClient();
        Call<FichaInscripcion> call=apiClient.saveByIds(idPersona,idCurso,idHorario,idFicha);
        call.enqueue(new Callback<FichaInscripcion>() {
            @Override
            public void onResponse(Call<FichaInscripcion> call, Response<FichaInscripcion> response) {
                if (response.isSuccessful()){
                    Log.i("Exito","Datos asignados");
                }else{
                    Log.e("Error","Error al asignar"+response.toString());
                }
            }

            @Override
            public void onFailure(Call<FichaInscripcion> call, Throwable t) {
                Log.e("ERROR","Error al guardar"+t.getMessage());
            }
        });
;    }
}
