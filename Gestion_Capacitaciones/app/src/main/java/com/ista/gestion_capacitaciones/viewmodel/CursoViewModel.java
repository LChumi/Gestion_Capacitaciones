package com.ista.gestion_capacitaciones.viewmodel;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.ista.gestion_capacitaciones.api.clients.CursoApiClient;
import com.ista.gestion_capacitaciones.model.Curso;

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
                    ((MutableLiveData<List<Curso>>) liveData).setValue(null);
                }
            }

            @Override
            public void onFailure(Call<List<Curso>> call, Throwable t) {
                ((MutableLiveData<List<Curso>>) liveData).setValue(null);
            }
        });
        return liveData;
    }
}
