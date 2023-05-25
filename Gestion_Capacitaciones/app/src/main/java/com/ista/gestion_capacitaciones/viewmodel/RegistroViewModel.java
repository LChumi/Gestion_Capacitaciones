/*
 *
 *   Created Luis Chumi on 24/5/23 16:04
 *   Copyright Ⓒ 2023. All rights reserved Ⓒ 2023 http://freefuninfo.com/
 *   Last modified: 24/5/23 16:04
 *
 *   Licensed under the Apache License, Version 2.0 (the "License"); you may not use this file
 *   except in compliance with the License. You may obtain a copy of the License at
 *   http://www.apache.org/licenses/LICENS... Unless required by applicable law or agreed to in writing, software
 *    distributed under the License is distributed on an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND,
 *    either express or implied. See the License for the specific language governing permissions and
 *    limitations under the License.
 * /
 */

package com.ista.gestion_capacitaciones.viewmodel;

import android.app.Application;
import android.util.Log;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.ista.gestion_capacitaciones.api.clients.CursoApiClient;
import com.ista.gestion_capacitaciones.api.clients.FichaInscripcionApiClient;
import com.ista.gestion_capacitaciones.api.clients.HorarioCursoApiClient;
import com.ista.gestion_capacitaciones.api.clients.PersonaApiClient;
import com.ista.gestion_capacitaciones.model.Curso;
import com.ista.gestion_capacitaciones.model.FichaInscripcion;
import com.ista.gestion_capacitaciones.model.HorarioCurso;
import com.ista.gestion_capacitaciones.model.Persona;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class RegistroViewModel extends AndroidViewModel {
    private MutableLiveData<Curso> cursoLiveData=new MutableLiveData<>();
    private MutableLiveData<Persona> personaLiveData=new MutableLiveData<>();
    private MutableLiveData<FichaInscripcion> fichaLiveData=new MutableLiveData<>();
    private MutableLiveData<List<HorarioCurso>> horariosLiveData=new MutableLiveData<>();

    public RegistroViewModel(@NonNull Application application) {
        super(application);
    }

    public LiveData<Curso> getCurso(Long id){
        CursoApiClient cursoApiClient=new CursoApiClient();
        Call<Curso> call = cursoApiClient.getById(id);
        call.enqueue(new Callback<Curso>() {
            @Override
            public void onResponse(Call<Curso> call, Response<Curso> response) {
                if (response.isSuccessful()){
                    cursoLiveData.setValue(response.body());
                }else {
                    cursoLiveData.setValue(new Curso());
                    Log.e("Error","No se encontro el curso");
                }
            }

            @Override
            public void onFailure(Call<Curso> call, Throwable t) {
                cursoLiveData.setValue(new Curso());
                Log.e("ERROR",t.getMessage());
            }
        });
        return cursoLiveData;
    }

    public LiveData<Persona> getPersona(Long id){
        PersonaApiClient personaApiClient=new PersonaApiClient();
        Call<Persona> call= personaApiClient.getById(id);
        call.enqueue(new Callback<Persona>() {
            @Override
            public void onResponse(Call<Persona> call, Response<Persona> response) {
                if (response.isSuccessful()){
                    personaLiveData.setValue(response.body());
                }else{
                    personaLiveData.setValue(new Persona());
                    Log.e("Error","No se encontro persona");
                }
            }

            @Override
            public void onFailure(Call<Persona> call, Throwable t) {
                personaLiveData.setValue(new Persona());
                Log.e("ERROR",t.getMessage());
            }
        });
        return personaLiveData;
    }

    public LiveData<FichaInscripcion> getFichaInscripcion(Long id){
        FichaInscripcionApiClient fichaInscripcionApiClient = new FichaInscripcionApiClient();
        Call<FichaInscripcion> call=fichaInscripcionApiClient.getById(id);
        call.enqueue(new Callback<FichaInscripcion>() {
            @Override
            public void onResponse(Call<FichaInscripcion> call, Response<FichaInscripcion> response) {
                if (response.isSuccessful()){
                    fichaLiveData.setValue(response.body());
                }else {
                    fichaLiveData.setValue(new FichaInscripcion());
                    Log.e("Error","No se encontro la ficha");
                }
            }

            @Override
            public void onFailure(Call<FichaInscripcion> call, Throwable t) {
                fichaLiveData.setValue(new FichaInscripcion());
                Log.e("ERROR",t.getMessage());
            }
        });
        return fichaLiveData;
    }

    public LiveData<List<HorarioCurso>> getByCurso(Long id){
        HorarioCursoApiClient horarioApiClient=new HorarioCursoApiClient();
        Call<List<HorarioCurso>> call= horarioApiClient.getByCurso(id);
        call.enqueue(new Callback<List<HorarioCurso>>() {
            @Override
            public void onResponse(Call<List<HorarioCurso>> call, Response<List<HorarioCurso>> response) {
                if (response.isSuccessful()){
                    horariosLiveData.setValue(response.body());
                }else{
                    horariosLiveData.setValue(new ArrayList<>());
                }
            }

            @Override
            public void onFailure(Call<List<HorarioCurso>> call, Throwable t) {
                horariosLiveData.setValue(new ArrayList<>());
            }
        });
        return horariosLiveData;
    }
}
