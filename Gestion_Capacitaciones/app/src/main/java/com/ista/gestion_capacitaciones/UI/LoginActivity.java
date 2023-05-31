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

package com.ista.gestion_capacitaciones.UI;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;
import com.ista.gestion_capacitaciones.MainActivity;
import com.ista.gestion_capacitaciones.R;
import com.ista.gestion_capacitaciones.api.clients.AuthCtrlApiClient;
import com.ista.gestion_capacitaciones.api.clients.UsuariosApiClient;
import com.ista.gestion_capacitaciones.db.DbPersona;
import com.ista.gestion_capacitaciones.db.DbRol;
import com.ista.gestion_capacitaciones.db.DbUsuarios;;
import com.ista.gestion_capacitaciones.model.LoginRequest;
import com.ista.gestion_capacitaciones.model.Persona;
import com.ista.gestion_capacitaciones.model.UserInfoResponse;
import com.ista.gestion_capacitaciones.model.Usuario;
import com.ista.gestion_capacitaciones.model.dto.PersonaDTO;
import com.ista.gestion_capacitaciones.model.dto.RolDTO;
import com.ista.gestion_capacitaciones.model.dto.UsuarioDTO;
import com.ista.gestion_capacitaciones.security.JwtResponse;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class LoginActivity extends AppCompatActivity {

    private Button btnIngreso;
    private ImageButton btnRegresar;
    private TextInputEditText txtUsername, txtPassword;
    private TextInputLayout txtInputUsuario, txtInputPassword;
    private SharedPreferences preferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        insertarRoles();
        init();
    }

    private void init() {
        txtUsername = findViewById(R.id.txtUsername);
        txtPassword = findViewById(R.id.txtPassword);
        btnIngreso = findViewById(R.id.btnIngreso);
        btnRegresar = findViewById(R.id.btnRegreso);
        txtInputUsuario = findViewById(R.id.txtInputUsuario);
        txtInputPassword = findViewById(R.id.txtInputPassword);

        btnIngreso.setOnClickListener(v -> {
            if (validar()) {
                String username = txtUsername.getText().toString();
                String password = txtPassword.getText().toString();
                login(username, password);
            }
        });

        btnRegresar.setOnClickListener(view -> regresar());
    }

    @Override
    protected void onStart() {
        super.onStart();
        preferences = PreferenceManager.getDefaultSharedPreferences(this);
        String username = preferences.getString("username", "");
        String password = preferences.getString("pass", "");
        long idPer = preferences.getLong("idPer", 0);
        long idRol = preferences.getLong("idRol", 0);

        if (!username.isEmpty() && !password.isEmpty() && idPer != 0 && idRol != 0) {
            toastCorrecto("Bienvenido");
            inicio(idPer);
            overridePendingTransition(R.anim.left_in, R.anim.left_out);
        }
    }

    private void login(String username, String password) {
        try {
            DbUsuarios dbUsuarios = new DbUsuarios(LoginActivity.this);
            UsuarioDTO user = dbUsuarios.login(username, password);

            if (user != null) {
                    SharedPreferences.Editor editor = preferences.edit();
                    editor.putString("username", user.getUsu_usuario());
                    editor.putString("pass", user.getUsu_password());
                    editor.putLong("idPer", user.getPer_id());
                    editor.putLong("idRol", user.getRol_id());
                    editor.apply();
                    toastCorrecto("Bienvenido");
                    inicio(user.getPer_id());

            } else {
                loginWithApi(username, password);
            }
        } catch (Exception e) {
            toastIncorrecto("Se ha producido un error" + e.getMessage());
            Log.e("Error", e.getMessage());
            limpiar();
        }
    }

    private LoginRequest loginRequest;
    private AuthCtrlApiClient authCtrlApiClient;
    private void loginWithApi(String username, String password) {
         loginRequest=new LoginRequest(username, password);
         authCtrlApiClient=new AuthCtrlApiClient();
        Call<JwtResponse> call = authCtrlApiClient.generarToken(loginRequest);
        call.enqueue(new Callback<JwtResponse>() {
            @Override
            public void onResponse(Call<JwtResponse> call, Response<JwtResponse> response) {
                if (response.isSuccessful()) {
                    JwtResponse jwtResponse = response.body();
                    String token = jwtResponse.getToken();
                    Log.i("token",token);
                    signin(loginRequest,password);
                } else {
                    toastIncorrecto("Credenciales Invalidos");
                    limpiar();
                }
            }
            @Override
            public void onFailure(Call<JwtResponse> call, Throwable t) {
                toastIncorrecto("Se ha producido un error" + t.getMessage());
                limpiar();
            }
        });
    }
    private void signin(LoginRequest loginRequest,String password){
        authCtrlApiClient=new AuthCtrlApiClient();
        Call<UserInfoResponse> call1 = authCtrlApiClient.authenticateUser(loginRequest);
        call1.enqueue(new Callback<UserInfoResponse>() {
            @Override
            public void onResponse(Call<UserInfoResponse> call, Response<UserInfoResponse> response) {
                if (response.isSuccessful()){
                    getUsuario(response.body().getId_usuario(),password);
                }else{
                    toastIncorrecto("Credenciales Invalidas");
                    limpiar();
                }
            }
            @Override
            public void onFailure(Call<UserInfoResponse> call, Throwable t) {
                Log.e("ERROR",t.getMessage());
            }
        });
    }
    private void getUsuario(Long id,String password){
        UsuariosApiClient apiClient=new UsuariosApiClient();
        Call<Usuario> call=apiClient.getById(id);
        call.enqueue(new Callback<Usuario>() {
            @Override
            public void onResponse(Call<Usuario> call, Response<Usuario> response) {
                if (response.isSuccessful()){
                    Log.i("Exito","Exito");
                    Usuario usuario = response.body();
                    Log.i("Usuario",usuario.toString());
                    SharedPreferences.Editor editor = preferences.edit();
                    editor.putString("username", usuario.getUsername());
                    editor.putString("pass", usuario.getPassword());
                    editor.putLong("idRol", usuario.getRol().getId_rol());
                    Persona p=new Persona();
                    if (usuario.getPersona()==null){
                        p.setId_persona(0l);
                        p.setCedula("9999999999");
                        p.setNombre("Super");
                        p.setApellido("Admin");
                        p.setFecha_nacimiento(new Date());
                        p.setEmail("info@tecazuay.edu.ec");
                        p.setTelefono("0995363076");
                        p.setEnabled(true);
                        editor.putLong("idPer",p.getId_persona());
                    }else{
                        editor.putLong("idPer", usuario.getPersona().getId_persona());
                    }
                    editor.apply();
                    toastCorrecto("Bienvenido");

                    DbPersona dbPersona = new DbPersona(LoginActivity.this);
                    DbUsuarios dbUsuarios = new DbUsuarios(LoginActivity.this);
                    PersonaDTO personaDTO;
                    if (usuario.getPersona()==null){
                        personaDTO=new PersonaDTO(p);
                    }else{
                        personaDTO = new PersonaDTO(usuario.getPersona());
                    }
                    Long usuId = usuario.getId_usuario();

                    if (dbPersona.obtenerPersona(personaDTO.getPer_id()) == null && dbUsuarios.obtenerUsuario(usuId) == null) {
                            Long per = dbPersona.insertaPersona(personaDTO.getPer_id(), personaDTO.getPer_cedula(), personaDTO.getPer_nombres(), personaDTO.getPer_apellidos(), personaDTO.getPer_fechaNacimiento(), personaDTO.getPer_correo(), personaDTO.isPer_estado());
                            Long us = dbUsuarios.insertaUsuario(usuario.getUsername(), password, personaDTO.getPer_id(), usuario.getRol().getId_rol());
                            if (per > 0 && us > 0) {
                                Log.i("Exito","OK");
                            } else {
                                Toast.makeText(LoginActivity.this, "Error al guardar persona", Toast.LENGTH_LONG).show();
                                Log.e("Error", "No se guardó");
                            }
                    } else {
                                long per = dbPersona.actualizar(personaDTO.getPer_id(), personaDTO.getPer_cedula(), personaDTO.getPer_nombres(), personaDTO.getPer_apellidos(), personaDTO.getPer_fechaNacimiento(), personaDTO.getPer_correo(), personaDTO.isPer_estado());
                                long us = dbUsuarios.actualizar(usuario.getId_usuario(), usuario.getUsername(), password, usuario.getPersona().getId_persona(), usuario.getRol().getId_rol());
                                if (per > 0 && us > 0) {
                                    Toast.makeText(LoginActivity.this, "sync", Toast.LENGTH_LONG).show();
                                } else {
                                    Toast.makeText(LoginActivity.this, "Error al actualizar persona", Toast.LENGTH_LONG).show();
                                    Log.e("Error", "Actualización fallida");
                                }
                    }
                    inicio(personaDTO.getPer_id());
                }else {
                    toastIncorrecto("Credenciales Invalidas");
                    limpiar();
                }

            }

            @Override
            public void onFailure(Call<Usuario> call, Throwable t) {
            }
        });
    }


    private void regresar() {
        Intent regresar = new Intent(this, MainActivity.class);
        startActivity(regresar);
    }

    private void toastCorrecto(String mensaje) {
        LayoutInflater layoutInflater = getLayoutInflater();
        View view = layoutInflater.inflate(R.layout.custom_toast_ok, findViewById(R.id.ll_custom_toast_ok));
        TextView txtMesnaje = view.findViewById(R.id.txtMensajeOk);
        txtMesnaje.setText(mensaje);

        Toast toast = new Toast(getApplicationContext());
        toast.setGravity(Gravity.CENTER_VERTICAL | Gravity.BOTTOM, 0, 200);
        toast.setDuration(Toast.LENGTH_LONG);
        toast.setView(view);
        toast.show();
    }

    private void toastIncorrecto(String mensaje) {
        LayoutInflater layoutInflater = getLayoutInflater();
        View view = layoutInflater.inflate(R.layout.custom_toast_error, findViewById(R.id.ll_custom_toast_err));
        TextView txtMensaje = view.findViewById(R.id.txtMensajeErr);
        txtMensaje.setText(mensaje);

        Toast toast = new Toast(getApplicationContext());
        toast.setGravity(Gravity.CENTER_VERTICAL | Gravity.BOTTOM, 0, 200);
        toast.setDuration(Toast.LENGTH_LONG);
        toast.setView(view);
        toast.show();
    }

    private boolean validar() {
        boolean esValido = true;
        TextInputLayout[] campos = {txtInputUsuario, txtInputPassword};
        for (TextInputLayout campo : campos) {
            EditText editText = campo.getEditText();
            String valor = editText.getText().toString();
            if (valor.isEmpty()) {
                campo.setError("Este campo es obligatorio");
                campo.setErrorEnabled(true);
                esValido = false;
            } else {
                campo.setError(null);
                campo.setErrorEnabled(false);
            }

            editText.setOnTouchListener((v, event) -> {
                campo.setError(null);
                campo.setErrorEnabled(false);
                return false;
            });
        }
        return esValido;
    }


    private void inicio(Long idpersona) {
        Intent inicio = new Intent(this, HomeActivity.class);
        inicio.putExtra("personaId", idpersona);
        limpiar();
        startActivity(inicio);
    }

    private void limpiar() {
        txtPassword.setText("");
        txtUsername.setText("");
    }

    private void insertarRoles() {
        DbRol dbRol = new DbRol(this);

        // Verificar si los roles ya existen en la base de datos
        if (dbRol.obtenerLista().isEmpty()) {
            // Insertar los roles en la base de datos
            List<RolDTO> roles = new ArrayList<>();
            roles.add(new RolDTO(1L, "ROLE_PARTICIPANTE", "Participante", true));
            roles.add(new RolDTO(2L, "ROLE_DOCENTE", "Docente", true));
            roles.add(new RolDTO(3L, "ROLE_ADMIN", "Admin", true));
            roles.add(new RolDTO(4L,"ROLE_SUPADMIN","Supadmin",true));
            for (RolDTO rol : roles) {
                dbRol.insertarRol(rol.getId_rol(), rol.getRol_nombre(), rol.getDescripcion(), rol.getEnabled());
            }
        }
    }
}
