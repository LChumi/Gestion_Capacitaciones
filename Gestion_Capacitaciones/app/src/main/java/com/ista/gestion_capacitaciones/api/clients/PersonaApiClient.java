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
