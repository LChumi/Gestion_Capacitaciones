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
import com.ista.gestion_capacitaciones.interfaces.PersonaApi;
import com.ista.gestion_capacitaciones.model.Persona;

import java.util.List;
import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class PersonaApiClient {

    PersonaApi personaApi;

    public PersonaApiClient(){
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
        personaApi=retrofit.create(PersonaApi.class);
    }

    public Call<List<Persona>> obtenerLista(){
        return personaApi.obtenerLista();
    }
    public Call<Persona> getById(Long id){
        return personaApi.getById(id);
    }
    public Call<Persona> crear(Persona persona){
        return personaApi.crear(persona);
    }
    public Call<Persona> actualizarPersona(Long id,Persona persona){
        return personaApi.actualizarPersona(id,persona);
    }
    public Call<Void> eliminar(Long id){
        return personaApi.eliminar(id);
    }
}
