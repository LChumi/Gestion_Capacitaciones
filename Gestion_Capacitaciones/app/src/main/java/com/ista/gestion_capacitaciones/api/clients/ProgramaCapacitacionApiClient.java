package com.ista.gestion_capacitaciones.api.clients;

import com.ista.gestion_capacitaciones.constants.ApiUrls;
import com.ista.gestion_capacitaciones.interfaces.ProgramaCapacitacionApi;
import com.ista.gestion_capacitaciones.model.ProgramaCapacitacion;

import java.util.List;
import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ProgramaCapacitacionApiClient {

    private ProgramaCapacitacionApi capacitacionApi;

    public ProgramaCapacitacionApiClient() {
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

        capacitacionApi=retrofit.create(ProgramaCapacitacionApi.class);
    }

    public Call<List<ProgramaCapacitacion>> listar(){
        return capacitacionApi.obtenerProgramas();
    }
    public Call<ProgramaCapacitacion> getById(Long id){
        return capacitacionApi.getById(id);
    }
    public Call<ProgramaCapacitacion> crear(ProgramaCapacitacion capacitacion){
        return capacitacionApi.crear(capacitacion);
    }
    public Call<Void> eliminar(Long id){
        return capacitacionApi.eliminar(id);
    }
    public Call<ProgramaCapacitacion> actualizar(Long id,
                                                 ProgramaCapacitacion capacitacion){
        return capacitacionApi.actualizar(id,capacitacion);
    }


}
