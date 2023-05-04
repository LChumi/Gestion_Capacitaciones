package com.ista.gestion_capacitaciones.UI;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.telecom.Call;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputEditText;
import com.ista.gestion_capacitaciones.R;
import com.ista.gestion_capacitaciones.api.clients.UsuariosApiClient;
import com.ista.gestion_capacitaciones.interfaces.UsuarioApi;
import com.ista.gestion_capacitaciones.model.Usuario;
import com.ista.gestion_capacitaciones.model.dto.UsuarioDTO;

import retrofit2.Callback;
import retrofit2.Response;

public class LoginActivity extends AppCompatActivity {

    private UsuariosApiClient usuariosApiClient;

    Button btnIngreso;
    TextInputEditText username,password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        username=findViewById(R.id.txtUsername);
        password=findViewById(R.id.txtPassword);
        btnIngreso=findViewById(R.id.btnIngreso);

        btnIngreso.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (TextUtils.isEmpty(username.getText().toString()) || TextUtils.isEmpty((password.getText().toString()))){
                    Toast.makeText(LoginActivity.this,"Username / Password Necesarios",Toast.LENGTH_LONG).show();
                }else{
                    //funcion boton menu
                    Login(username.getText().toString(),password.getText().toString());
                }
            }
        });
    }

    public void Login(String username,String password){

        usuariosApiClient.login(username, password).enqueue(new Callback<Usuario>() {
            @Override
            public void onResponse(retrofit2.Call<Usuario> call, Response<Usuario> response) {
                if (response.isSuccessful()){
                    Usuario usuario= response.body();
                }else{
                    Toast.makeText(LoginActivity.this, "Credenciales inválidas o problema de conexión", Toast.LENGTH_SHORT).show();
                    Log.e("LoginActivity", "Error al iniciar sesión: " + response.code() + " - " + response.message());
                }
            }

            @Override
            public void onFailure(retrofit2.Call<Usuario> call, Throwable t) {
                Log.e("Error", t.getMessage());
            }
        });


    }
}