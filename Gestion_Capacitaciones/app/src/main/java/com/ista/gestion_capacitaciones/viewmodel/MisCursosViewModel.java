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

import com.ista.gestion_capacitaciones.api.clients.ParticipanteApiClient;
import com.ista.gestion_capacitaciones.model.Participante;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MisCursosViewModel extends AndroidViewModel {

    private MutableLiveData<List<Participante>> participanteLiveData=new MutableLiveData<>();
    private ParticipanteApiClient participanteApi;

    public MisCursosViewModel(@NonNull Application application) {
        super(application);
    }

    public LiveData<List<Participante>> ListarCursoPArticipante(Long id){
        participanteApi=new ParticipanteApiClient();
        LiveData<List<Participante>> liveData=new MutableLiveData<>();
        Call<List<Participante>> call=participanteApi.getCourseByParticipante(id);
        call.enqueue(new Callback<List<Participante>>() {
            @Override
            public void onResponse(Call<List<Participante>> call, Response<List<Participante>> response) {
                if (response.isSuccessful()){
                    ((MutableLiveData<List<Participante>>)liveData).setValue(response.body());
                }else{
                    ((MutableLiveData<List<Participante>>)liveData).setValue(new ArrayList<>());
                }
            }
            @Override
            public void onFailure(Call<List<Participante>> call, Throwable t) {
                ((MutableLiveData<List<Participante>>)liveData).setValue(new ArrayList<>());
            }
        });
        return liveData;
    }

    public LiveData<List<Participante>> listaAsistencias(Long curId){
        participanteApi=new ParticipanteApiClient();
        LiveData<List<Participante>> liveData=new MutableLiveData<>();
        Call<List<Participante>> call=participanteApi.getListParticipanteByCourses(curId);
        call.enqueue(new Callback<List<Participante>>() {
            @Override
            public void onResponse(Call<List<Participante>> call, Response<List<Participante>> response) {
                if (response.isSuccessful()){
                    ((MutableLiveData<List<Participante>>)liveData).setValue(response.body());
                }else {
                    ((MutableLiveData<List<Participante>>)liveData).setValue(new ArrayList<>());
                }
            }

            @Override
            public void onFailure(Call<List<Participante>> call, Throwable t) {
                ((MutableLiveData<List<Participante>>)liveData).setValue(new ArrayList<>());
            }
        });
        return liveData;
    }

    public LiveData<List<Participante>> listaAsistenciasByHorario(Long idCurso,Long idHorario){
        ParticipanteApiClient apiClient=new ParticipanteApiClient();
        Call<List<Participante>> call=apiClient.getListByHorario(idCurso, idHorario);
        call.enqueue(new Callback<List<Participante>>() {
            @Override
            public void onResponse(Call<List<Participante>> call, Response<List<Participante>> response) {
                if (response.isSuccessful()){
                    participanteLiveData.setValue(response.body());
                }else{
                    participanteLiveData.setValue(new ArrayList<>());
                }
            }

            @Override
            public void onFailure(Call<List<Participante>> call, Throwable t) {
                participanteLiveData.setValue(new ArrayList<>());
            }
        });
        return participanteLiveData;
    }

}
