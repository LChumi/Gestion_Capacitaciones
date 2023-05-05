package com.ista.gestion_capacitaciones.UI;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.telecom.Call;
import android.text.TextUtils;
import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputEditText;
import com.ista.gestion_capacitaciones.MainActivity;
import com.ista.gestion_capacitaciones.R;
import com.ista.gestion_capacitaciones.api.clients.UsuariosApiClient;
import com.ista.gestion_capacitaciones.db.DbPersona;
import com.ista.gestion_capacitaciones.db.DbUsuarios;
import com.ista.gestion_capacitaciones.interfaces.UsuarioApi;
import com.ista.gestion_capacitaciones.model.Usuario;
import com.ista.gestion_capacitaciones.model.dto.PersonaDTO;
import com.ista.gestion_capacitaciones.model.dto.UsuarioDTO;

import retrofit2.Callback;
import retrofit2.Response;

public class LoginActivity extends AppCompatActivity {

    private UsuariosApiClient usuariosApiClient;

    Button btnIngreso;
    ImageButton btnRegresar;
    TextInputEditText username,password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        username=findViewById(R.id.txtUsername);
        password=findViewById(R.id.txtPassword);
        btnIngreso=findViewById(R.id.btnIngreso);
        btnRegresar=findViewById(R.id.btnRegreso);

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
        btnRegresar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Regresar();
            }
        });
    }

    public void Login(String username, String password) {
        UsuariosApiClient usuariosApiClient = new UsuariosApiClient();
        DbUsuarios dbUsuarios = new DbUsuarios(LoginActivity.this);

        if(dbUsuarios.login(username,password)!=null){
            //Toast.makeText(LoginActivity.this, "Accseso Correcto", Toast.LENGTH_LONG).show();
            ToastCorrecto("Correcto");
        }else{
            //consumo de api-Rest
            retrofit2.Call<Usuario> call = usuariosApiClient.login(username, password);

            call.enqueue(new Callback<Usuario>() {
                @Override
                public void onResponse(retrofit2.Call<Usuario> call, Response<Usuario> response) {
                    if (response.isSuccessful()) {
                        Usuario usuario = response.body();
                        //Toast.makeText(LoginActivity.this, "Acceso correcto " + usuario.getUsername(), Toast.LENGTH_LONG).show();
                            ToastCorrecto("Correcto");
                        //base de datos
                        DbPersona dbPersona = new DbPersona(LoginActivity.this);
                        PersonaDTO personaDTO = new PersonaDTO(usuario.getPersona());
                        long perId = personaDTO.getPer_id();
                        if (dbPersona.obtenerPersona(perId) == null) {
                            long per = dbPersona.insertaPersona(perId, personaDTO.getPer_cedula(), personaDTO.getPer_nombres(), personaDTO.getPer_apellidos(), personaDTO.getPer_fechaNacimiento().toString(), personaDTO.getPer_correo(), personaDTO.isPer_estado());
                            if (per > 0) {
                                Toast.makeText(LoginActivity.this, "Persona guardada", Toast.LENGTH_LONG).show();
                            } else {
                                Toast.makeText(LoginActivity.this, "Error al guardar persona", Toast.LENGTH_LONG).show();
                            }
                        }


                        long usuId=usuario.getId_usuario();
                        if (dbUsuarios.obtenerUsuario(usuId) == null) {
                            long us = dbUsuarios.insertaUsuario(username, password, perId);
                            if (us > 0) {
                                Toast.makeText(LoginActivity.this, "Usuario guardado", Toast.LENGTH_LONG).show();
                            } else {
                                Toast.makeText(LoginActivity.this, "Error al guardar usuario", Toast.LENGTH_LONG).show();
                            }
                        }

                    } else {
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

    public void Regresar(){
        Intent regresar=new Intent(this, MainActivity.class);
        startActivity(regresar);
    }
    public void ToastCorrecto(String mensaje){
        LayoutInflater layoutInflater=getLayoutInflater();
        View view=layoutInflater.inflate(R.layout.custom_toast_ok,(ViewGroup) findViewById(R.id.ll_custom_toast_ok));
        TextView txtMesnaje=view.findViewById(R.id.txtMensajeOk);
        txtMesnaje.setText(mensaje);

        Toast toast=new Toast(getApplicationContext());
        toast.setGravity(Gravity.CENTER_VERTICAL | Gravity.BOTTOM,0,200);
        toast.setDuration(Toast.LENGTH_LONG);
        toast.setView(view);
        toast.show();
    }


}