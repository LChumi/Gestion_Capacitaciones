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
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.ista.gestion_capacitaciones.api.clients.ProgramaCapacitacionApiClient;
import com.ista.gestion_capacitaciones.model.ProgramaCapacitacion;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ProgramaViewModel extends AndroidViewModel {

    private ProgramaCapacitacionApiClient capacitacionApi;


    public ProgramaViewModel(@NonNull Application application) {
        super(application);
    }



    public LiveData<List<ProgramaCapacitacion>> listarProgramasCapacitacion() {
        capacitacionApi=new ProgramaCapacitacionApiClient();
        LiveData<List<ProgramaCapacitacion>> liveData = new MutableLiveData<>();
        Call<List<ProgramaCapacitacion>> call = capacitacionApi.listar();
        call.enqueue(new Callback<List<ProgramaCapacitacion>>() {
            @Override
            public void onResponse(Call<List<ProgramaCapacitacion>> call, Response<List<ProgramaCapacitacion>> response) {
                if (response.isSuccessful()) {
                    ((MutableLiveData<List<ProgramaCapacitacion>>) liveData).setValue(response.body());
                } else {
                    ((MutableLiveData<List<ProgramaCapacitacion>>) liveData).setValue(new ArrayList<>());
                    Toast.makeText(getApplication(), "Error de red Sin Conexión", Toast.LENGTH_LONG).show();
                }
            }

            @Override
            public void onFailure(Call<List<ProgramaCapacitacion>> call, Throwable t) {
                ((MutableLiveData<List<ProgramaCapacitacion>>) liveData).setValue(new ArrayList<>());
                Toast.makeText(getApplication(), "Error de red Sin Conexión", Toast.LENGTH_LONG).show();
            }

        });

        return liveData;

    }
}
