package com.ista.gestion_capacitaciones.viewmodel;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.ista.gestion_capacitaciones.constants.clients.ParticipanteApiClient;
import com.ista.gestion_capacitaciones.model.Participante;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MisCursosViewModel extends AndroidViewModel {

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

}
