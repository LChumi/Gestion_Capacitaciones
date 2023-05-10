package com.ista.gestion_capacitaciones.UI;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
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
import com.ista.gestion_capacitaciones.db.DbRol;
import com.ista.gestion_capacitaciones.db.DbUsuarios;
import com.ista.gestion_capacitaciones.interfaces.UsuarioApi;
import com.ista.gestion_capacitaciones.model.Usuario;
import com.ista.gestion_capacitaciones.model.dto.PersonaDTO;
import com.ista.gestion_capacitaciones.model.dto.RolDTO;
import com.ista.gestion_capacitaciones.model.dto.UsuarioDTO;

import cn.pedant.SweetAlert.SweetAlertDialog;
import retrofit2.Call;
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
        this.init();;

    }

    private void init(){
        txtusername=findViewById(R.id.txtUsername);
        txtpassword=findViewById(R.id.txtPassword);
        btnIngreso=findViewById(R.id.btnIngreso);
        btnRegresar=findViewById(R.id.btnRegreso);
        txtInputUsuario=findViewById(R.id.txtInputUsuario);
        txtInputPassword=findViewById(R.id.txtInputPassword);

        btnIngreso.setOnClickListener(v ->{
            try {
                if (validar()){
                    Login(txtusername.getText().toString(),txtpassword.getText().toString());
                }
            }catch (Exception e) {
                toastIncorrecto("Se ha producido un error al intentar loguearte : " + e.getMessage());
            }
        });

        btnRegresar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                regresar();
            }
        });
    }



    private void loginWithApi(String username, String password) {
        UsuariosApiClient usuariosApiClient = new UsuariosApiClient();
        Call<Usuario> call = usuariosApiClient.login(username, password);

        call.enqueue(new Callback<Usuario>() {
            @Override
            public void onResponse(Call<Usuario> call, Response<Usuario> response) {

                if (response.isSuccessful()) {
                    Usuario usuario = response.body();
                    SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(LoginActivity.this);
                    SharedPreferences.Editor editor = preferences.edit();
                    editor.putString("username", usuario.getUsername());
                    editor.putString("pass",usuario.getPassword());
                    Long idPer=usuario.getPersona().getId_persona();
                    editor.putString("idPer",idPer.toString());
                    editor.apply();
                    toastCorrecto("Correcto");
                    Log.i("mensaje"+response.body(),response.message());

                    DbPersona dbPersona = new DbPersona(LoginActivity.this);
                    DbUsuarios dbUsuarios = new DbUsuarios(LoginActivity.this);
                    DbRol dbRol=new DbRol(LoginActivity.this);
                    UsuarioDTO usuarioDTO=new UsuarioDTO(usuario);
                    PersonaDTO personaDTO = new PersonaDTO(usuario.getPersona());
                    RolDTO rolDTO=new RolDTO(usuario.getRol());
                    long perId = personaDTO.getPer_id();
                    long usuId=usuario.getId_usuario();
                    if (dbPersona.obtenerPersona(perId) == null && dbUsuarios.obtenerUsuario(usuId) == null) {
                        long per = dbPersona.insertaPersona(perId, personaDTO.getPer_cedula(), personaDTO.getPer_nombres(), personaDTO.getPer_apellidos(), personaDTO.getPer_fechaNacimiento(), personaDTO.getPer_correo(), personaDTO.isPer_estado());
                        long us = dbUsuarios.insertaUsuario(username, password, perId,usuarioDTO.getRol_id());
                        long rol=dbRol.insertarRol(rolDTO.getId_rol(),rolDTO.getRol_nombre(),rolDTO.getDescripcion(),rolDTO.getEnabled());
                        if (per > 0 && us > 0 && rol>0) {
                            Toast.makeText(LoginActivity.this, "Datos guardados", Toast.LENGTH_LONG).show();
                        } else {
                            Toast.makeText(LoginActivity.this, "Error al guardar persona", Toast.LENGTH_LONG).show();
                        }
                    }else {
                        if (dbPersona.obtenerPersona(perId) != null && dbUsuarios.obtenerUsuario(usuId) != null) {
                            long per = dbPersona.actualizar(perId, personaDTO.getPer_cedula(), personaDTO.getPer_nombres(), personaDTO.getPer_apellidos(), personaDTO.getPer_fechaNacimiento(), personaDTO.getPer_correo(), personaDTO.isPer_estado());
                            long us = dbUsuarios.actualizar(usuario.getId_usuario(),usuario.getUsername(), usuario.getPassword(), usuario.getPersona().getId_persona(),usuario.getRol().getId_rol());
                            long rol=dbRol.actualizar(rolDTO.getId_rol(),rolDTO.getRol_nombre(),rolDTO.getDescripcion(),rolDTO.getEnabled());
                            if (per > 0 && us > 0 && rol >0) {
                                Toast.makeText(LoginActivity.this, "sync", Toast.LENGTH_LONG).show();
                            } else {
                                Toast.makeText(LoginActivity.this, "Error al actualizar persona", Toast.LENGTH_LONG).show();
                            }
                        }else {
                            Toast.makeText(LoginActivity.this, "Usuario no existe "+dbPersona.obtenerPersona(perId).getPer_id()+dbUsuarios.obtenerUsuario(usuId).getUsu_usuario(), Toast.LENGTH_LONG).show();
                        }
                    }
                    inicio(personaDTO.getPer_id());
                }
            }
            @Override
            public void onFailure(Call<Usuario> call, Throwable t) {
                toastIncorrecto("Credenciales inválidas o problema de conexión");
                limpiar();
                Log.e("Error", t.getMessage());
            }
        });
    }

    private void Login(String username, String password) {
        try {
            DbUsuarios dbUsuarios = new DbUsuarios(LoginActivity.this);
            if (dbUsuarios.login(username, password) != null) {
                UsuarioDTO user = dbUsuarios.login(username, password);
                SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(this);
                SharedPreferences.Editor editor = preferences.edit();
                editor.putString("username", user.getUsu_usuario());
                editor.putString("pass",user.getUsu_password());
                Long idPer=user.getPer_id();
                editor.putString("idPer",idPer.toString());
                editor.apply();
                toastCorrecto("Correcto");
                inicio(user.getPer_id());
            } else {
                loginWithApi(username, password);
            }
        } catch (Exception e) {
            toastIncorrecto("Se ha producido un error" + e.getMessage());
            limpiar();
        }
    }


    private void regresar(){
        Intent regresar=new Intent(this, MainActivity.class);
        startActivity(regresar);
    }
    private void toastCorrecto(String mensaje){
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

    private void toastIncorrecto(String mensaje){
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

    private boolean validar() {
        boolean esValido = true;
        TextInputLayout[] campos = {txtInputUsuario, txtInputPassword};
        for (TextInputLayout campo : campos) {
            String valor = campo.getEditText().getText().toString();
            if (valor.isEmpty()) {
                campo.setError("Este campo es obligatorio");
                campo.setErrorEnabled(true);
                esValido = false;
            } else {
                campo.setError(null);
                campo.setErrorEnabled(false);
            }
        }
        return esValido;
    }


    private void inicio(Long idpersona){
        Intent inicio=new Intent(this, HomeActivity.class);
        inicio.putExtra("personaId",idpersona);
        limpiar();
        startActivity(inicio);
    }

    private void limpiar(){
        txtpassword.setText("");
        txtusername.setText("");
    }

    @Override
    protected void onStart(){
        super.onStart();
        try {
            SharedPreferences preferences= PreferenceManager.getDefaultSharedPreferences(this);
            String pref=preferences.getString("username", "");
            String prefp=preferences.getString("pass","");
            String idPer=preferences.getString("idPer","");
            Long id=Long.parseLong(idPer);
            if (!pref.equals("") && !prefp.equals("") && !idPer.equals("")){
                toastCorrecto("Inicio activo "+prefp);
                inicio(id);
                Log.i("mensaje",idPer);
                this.startActivity(new Intent(this,HomeActivity.class));
                this.overridePendingTransition(R.anim.left_in, R.anim.left_out);
            }
            inicio(id);
        } catch (Exception e) {
            Log.e("TAG", "Error en onStart(): " + e.getMessage());
        }
    }






}