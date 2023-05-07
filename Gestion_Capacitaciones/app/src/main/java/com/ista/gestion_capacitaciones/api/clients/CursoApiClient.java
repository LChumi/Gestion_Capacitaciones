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

}
