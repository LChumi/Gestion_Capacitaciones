/*
 *
 *   Created Luis Chumi on 23/5/23 9:38
 *   Copyright Ⓒ 2023. All rights reserved Ⓒ 2023 http://freefuninfo.com/
 *   Last modified: 19/5/23 8:58
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

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.ista.gestion_capacitaciones.api.clients.CursoApiClient;
import com.ista.gestion_capacitaciones.model.Curso;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class CursoViewModel extends AndroidViewModel {

    private CursoApiClient cursoApi;

    public CursoViewModel(@NonNull Application application) {
        super(application);
    }

    public LiveData<List<Curso>> listarCursoPrograma(Long id){
        cursoApi=new CursoApiClient();
        LiveData<List<Curso>> liveData=new MutableLiveData<>();
        Call<List<Curso>> call=cursoApi.getByPrograma(id);
        call.enqueue(new Callback<List<Curso>>() {
            @Override
            public void onResponse(Call<List<Curso>> call, Response<List<Curso>> response) {
                if (response.isSuccessful()){
                    ((MutableLiveData<List<Curso>>) liveData).setValue(response.body());
                }else{
                    ((MutableLiveData<List<Curso>>) liveData).setValue(new ArrayList<>());
                }
            }

            @Override
            public void onFailure(Call<List<Curso>> call, Throwable t) {
                ((MutableLiveData<List<Curso>>) liveData).setValue(new ArrayList<>());
            }
        });
        return liveData;
    }

    public LiveData<List<Curso>> listarCursosDocente(Long id_persona){
        cursoApi=new CursoApiClient();
        LiveData<List<Curso>> liveData=new MutableLiveData<>();
        Call<List<Curso>> call= cursoApi.getByUser(id_persona);
        call.enqueue(new Callback<List<Curso>>() {
            @Override
            public void onResponse(Call<List<Curso>> call, Response<List<Curso>> response) {
                if (response.isSuccessful()){
                    ((MutableLiveData<List<Curso>>)liveData).setValue(response.body());
                }else{
                    ((MutableLiveData<List<Curso>>)liveData).setValue(new ArrayList<>());
                }
            }

            @Override
            public void onFailure(Call<List<Curso>> call, Throwable t) {
                ((MutableLiveData<List<Curso>>)liveData).setValue(new ArrayList<>());
            }
        });
        return liveData;
    }
}
