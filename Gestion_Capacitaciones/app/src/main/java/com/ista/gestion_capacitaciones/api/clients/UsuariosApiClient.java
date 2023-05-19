package com.ista.gestion_capacitaciones.api.clients;

import com.ista.gestion_capacitaciones.constants.ApiUrls;
import com.ista.gestion_capacitaciones.interfaces.UsuarioApi;
import com.ista.gestion_capacitaciones.model.Usuario;

import java.util.List;
import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class UsuariosApiClient {

    private UsuarioApi usuarioApi;

    public UsuariosApiClient(){
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

        usuarioApi=retrofit.create(UsuarioApi.class);
    }

    public Call<List<Usuario>> getUsuariosList(){
        return usuarioApi.getUsuariosList();
    }

    public Call<Usuario> obtenerUsuario(String username){
        return usuarioApi.obtenerUsuario(username);
    }

    public Call<Usuario> iniciarSesion(Usuario usuario){
        return usuarioApi.IniciarSesion(usuario);
    }

    public Call<Usuario> create(Usuario usuario){
        return usuarioApi.create(usuario);
    }

    public Call<Usuario> actualizarUsuario(Long id, Usuario usuario){
        return usuarioApi.actualizarUsuario(id,usuario);
    }

    public Call<Void> eliminar(Long id){
        return usuarioApi.eliminar(id);
    }

    public Call<Usuario> login(String usernme,String password){
        return usuarioApi.login(usernme,password);
    }


}
