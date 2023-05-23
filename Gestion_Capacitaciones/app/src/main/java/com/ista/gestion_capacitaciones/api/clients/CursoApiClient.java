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

package com.ista.gestion_capacitaciones.api.clients;

import com.ista.gestion_capacitaciones.constants.ApiUrls;
import com.ista.gestion_capacitaciones.interfaces.CursoApi;
import com.ista.gestion_capacitaciones.model.Curso;

import java.util.List;
import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class CursoApiClient {

    CursoApi cursoApi;

    public CursoApiClient(){
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
        cursoApi = retrofit.create(CursoApi.class);
    }

    public Call<List<Curso>> obtenerLista(){
        return cursoApi.obtenerLista();
    }
    public Call<Curso> getById(Long id){
        return cursoApi.getById(id);
    }
    public Call<Curso> crear(Curso curso){
        return cursoApi.crear(curso);
    }
    public Call<Curso> actualizarCurso(Long id,Curso curso){
        return cursoApi.actualizarCurso(id,curso);
    }
    public Call<Void> eliminar(Long id){
        return cursoApi.eliminar(id);
    }
    public Call<List<Curso>> getByUser(Long id_persona){
        return cursoApi.getByDocente(id_persona);
    }
    public Call<List<Curso>> getByPrograma(Long idPrograma){
        return cursoApi.getByPrograma(idPrograma);
    }
}
