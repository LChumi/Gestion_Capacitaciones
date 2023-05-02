package com.ista.gestion_capacitaciones.api.clients;

import com.ista.gestion_capacitaciones.constants.ApiUrls;
import com.ista.gestion_capacitaciones.interfaces.ParticipanteApi;
import com.ista.gestion_capacitaciones.model.Participante;

import java.util.List;

import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ParticipanteApiClient {

    ParticipanteApi participanteApi;

    public ParticipanteApiClient(){
        Retrofit retrofit=new Retrofit.Builder()
                .baseUrl(ApiUrls.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        participanteApi=retrofit.create(ParticipanteApi.class);
    }

    public Call<List<Participante>> obtenerLista(){
        return participanteApi.obtenerLista();
    }
    public Call<Participante> getById(Long id){
        return participanteApi.getById(id);
    }
    public Call<Participante> crear(Participante participante){
        return participanteApi.crear(participante);
    }
    public Call<Participante> actualizarParticipante(Long id,Participante participante){
        return participanteApi.actualizarParticipante(id,participante);
    }
    public Call<Void> eliminar(Long id){
        return participanteApi.eliminar(id);
    }
}
