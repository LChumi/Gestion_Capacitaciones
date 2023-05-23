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

package com.ista.gestion_capacitaciones.api.clients;

import com.ista.gestion_capacitaciones.constants.ApiUrls;
import com.ista.gestion_capacitaciones.interfaces.AsistenciaApi;
import com.ista.gestion_capacitaciones.model.Asistencia;
import com.ista.gestion_capacitaciones.model.Participante;
import com.ista.gestion_capacitaciones.model.Usuario;

import java.util.List;
import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class AsistenciaApiClient {

    private AsistenciaApi asistenciaApi;

    public AsistenciaApiClient() {
        OkHttpClient client = new OkHttpClient.Builder()
                .connectTimeout(5, TimeUnit.SECONDS)
                .readTimeout(5, TimeUnit.SECONDS)
                .writeTimeout(5, TimeUnit.SECONDS)
                .build();


        Retrofit retrofit=new Retrofit.Builder()
                .baseUrl(ApiUrls.BASE_URL)
                .client(client)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        asistenciaApi=retrofit.create(AsistenciaApi.class);
    }

    public Call<List<Asistencia>> obtenerLista(){
        return asistenciaApi.obtenerLista();
    }
    public Call<Asistencia> getById(Long id){
        return asistenciaApi.getById(id);
    }
    public Call<Asistencia> crear(Asistencia asistencia){
        return asistenciaApi.crear(asistencia);
    }
    public Call<Asistencia> actualizarUsuario(Long id, Asistencia asistencia){
        return asistenciaApi.actualizarUsuario(id,asistencia);
    }
    public Call<Void> eliminar(Long id){
        return asistenciaApi.eliminar(id);
    }
    public Call<Asistencia> addAsistencia(Long idAsis,Long p){
        return asistenciaApi.addAsistencia(idAsis,p);
    }
}
