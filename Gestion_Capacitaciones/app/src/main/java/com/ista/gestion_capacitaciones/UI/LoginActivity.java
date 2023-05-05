package com.ista.gestion_capacitaciones.UI;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
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
import com.google.android.material.textfield.TextInputLayout;
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

    private Button btnIngreso;
    private ImageButton btnRegresar;
    private TextInputEditText txtusername,txtpassword;
    private TextInputLayout txtInputUsuario,txtInputPassword;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        txtusername=findViewById(R.id.txtUsername);
        txtpassword=findViewById(R.id.txtPassword);
        btnIngreso=findViewById(R.id.btnIngreso);
        btnRegresar=findViewById(R.id.btnRegreso);
        txtInputUsuario=findViewById(R.id.txtInputUsuario);
        txtInputPassword=findViewById(R.id.txtInputPassword);


        btnIngreso.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (TextUtils.isEmpty(txtusername.getText().toString()) || TextUtils.isEmpty((txtpassword.getText().toString()))){
                    Toast.makeText(LoginActivity.this,"Username / Password Necesarios",Toast.LENGTH_LONG).show();
                }else{
                    //funcion boton menu
                    Login(txtusername.getText().toString(),txtpassword.getText().toString());
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

    private void loginWithApi(String username, String password) {
        UsuariosApiClient usuariosApiClient = new UsuariosApiClient();
        DbUsuarios dbUsuarios = new DbUsuarios(LoginActivity.this);

        retrofit2.Call<Usuario> call = usuariosApiClient.login(username, password);

        call.enqueue(new Callback<Usuario>() {
            @Override
            public void onResponse(retrofit2.Call<Usuario> call, Response<Usuario> response) {
                if (response.isSuccessful()) {
                    Usuario usuario = response.body();
                    ToastCorrecto("Correcto");

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
                    Inicio(personaDTO.getPer_id());
                } else {
                    Toast.makeText(LoginActivity.this, "Credenciales inválidas o problema de conexión", Toast.LENGTH_SHORT).show();
                    Log.e("LoginActivity", "Error al iniciar sesión: " + response.code() + " - " + response.message());
                    ToastIncorrecto("Credenciales inválidas o problema de conexión");
                    Limpiar();
                }
            }

            @Override
            public void onFailure(retrofit2.Call<Usuario> call, Throwable t) {
                Log.e("Error", t.getMessage());
            }
        });
    }

    public void Login(String username, String password) {
        try {
            if (!validar()){
                ToastIncorrecto("Por favor llene los datos ");
                return;
            }
            DbUsuarios dbUsuarios = new DbUsuarios(LoginActivity.this);
            if(dbUsuarios.login(username,password)!=null){
                UsuarioDTO user=dbUsuarios.login(username,password);
                ToastCorrecto("Correcto");
                Inicio(user.getPer_id());
            } else {
                loginWithApi(username, password);
            }
        } catch (Exception e) {
            ToastIncorrecto("Se ha producido un error" + e.getMessage());
            Limpiar();
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

    public void ToastIncorrecto(String mensaje){
        LayoutInflater layoutInflater=getLayoutInflater();
        View view=layoutInflater.inflate(R.layout.custom_toast_error,(ViewGroup)  findViewById(R.id.ll_custom_toast_err));
        TextView txtMensaje=view.findViewById(R.id.txtMensajeErr);
        txtMensaje.setText(mensaje);

        Toast toast=new Toast(getApplicationContext());
        toast.setGravity(Gravity.CENTER_VERTICAL | Gravity.BOTTOM,0,200);
        toast.setDuration(Toast.LENGTH_LONG);
        toast.setView(view);
        toast.show();
    }

    private boolean validar(){
        Boolean retorno=true;
        String usuario,password1;
        usuario=txtusername.getText().toString();
        password1=txtpassword.getText().toString();
        if(usuario.isEmpty()){
            txtInputUsuario.setError("Ingrese su Usuario");
            retorno=false;
        }else{
            txtInputUsuario.setErrorEnabled(false);
        }
        if(password1.isEmpty()){
            txtInputPassword.setError("Ingrese su contraseña");
        }else{
            txtInputPassword.setErrorEnabled(false);
        }
        return retorno;
    }

    public void Inicio(Long idpersona){
        Intent inicio=new Intent(this, HomeActivity.class);
        inicio.putExtra("personaId",idpersona);
        Limpiar();
        startActivity(inicio);
    }

    public void Limpiar(){
        txtpassword.setText("");
        txtusername.setText("");
    }


}