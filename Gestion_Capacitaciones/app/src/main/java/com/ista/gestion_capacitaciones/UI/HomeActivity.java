/*
 *
 *   Created Luis Chumi on 23/5/23 9:38
 *   Copyright Ⓒ 2023. All rights reserved Ⓒ 2023 http://freefuninfo.com/
 *   Last modified: 18/5/23 23:54
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

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.view.Menu;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.snackbar.Snackbar;
import com.google.android.material.navigation.NavigationView;
import com.ista.gestion_capacitaciones.R;
import com.ista.gestion_capacitaciones.databinding.ActivityHomeBinding;
import com.ista.gestion_capacitaciones.db.DbPersona;
import com.ista.gestion_capacitaciones.db.DbUsuarios;
import com.ista.gestion_capacitaciones.model.dto.PersonaDTO;

import androidx.annotation.NonNull;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.appcompat.app.AppCompatActivity;

import de.hdodenhof.circleimageview.CircleImageView;


public class HomeActivity extends AppCompatActivity {

    private AppBarConfiguration mAppBarConfiguration;
    private ActivityHomeBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityHomeBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        setSupportActionBar(binding.appBarHome.toolbar);
        binding.appBarHome.fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
        DrawerLayout drawer = binding.drawerLayout;
        NavigationView navigationView = binding.navView;
        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
        mAppBarConfiguration = new AppBarConfiguration.Builder(
                R.id.nav_inicio, R.id.nav_perfil, R.id.nav_misCursos)
                .setOpenableLayout(drawer)
                .build();
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment_content_home);
        NavigationUI.setupActionBarWithNavController(this, navController, mAppBarConfiguration);
        NavigationUI.setupWithNavController(navigationView, navController);
    }

    @Override
    protected void onStart(){
        super.onStart();
        cargarDatos();
    }

    private void cargarDatos(){
        Long personId = getIntent().getLongExtra("personaId", 0);
        Log.i("ID",personId.toString());
        DbPersona dbPersona = new DbPersona(HomeActivity.this);
        final View vistaHeader = binding.navView.getHeaderView(0);
        final TextView txtNombre = vistaHeader.findViewById(R.id.txtnombreUsuario);
        final TextView txtDesc = vistaHeader.findViewById(R.id.txtDesc);
        final CircleImageView imgFoto = vistaHeader.findViewById(R.id.imgFotoPerfil);

        PersonaDTO personaDTO = dbPersona.obtenerPersona(personId);

        if (personaDTO != null){
            Toast.makeText(HomeActivity.this, "Persona encontrada"+personaDTO.Datos()+personaDTO.getPer_correo()+personaDTO.getPer_apellidos(), Toast.LENGTH_LONG).show();
            txtNombre.setText(personaDTO.Datos());
            txtDesc.setText(personaDTO.getPer_correo());
            Log.i(personaDTO.getPer_cedula(),"datos");
            Log.i(personaDTO.getPer_apellidos(),"dato");
            Log.i(personaDTO.getPer_correo(),"dato");

        } else {
            txtNombre.setText("Not Found");
            txtDesc.setText("Not Found");
        }
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.home, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case R.id.cerrarSesion:
                this.logout();
                break;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public boolean onSupportNavigateUp() {
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment_content_home);
        return NavigationUI.navigateUp(navController, mAppBarConfiguration)
                || super.onSupportNavigateUp();
    }

    private void logout() {
        SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(this);
        SharedPreferences.Editor editor = preferences.edit();
        editor.remove("username"); // Remueve el valor asociado con la clave "username"
        editor.remove("pass"); // Remueve el valor asociado con la clave "pass"
        editor.remove("idPer"); // Remueve el valor asociado con la clave "idPer"
        editor.remove("idRol");
        editor.apply();

        Intent intent = new Intent(this, LoginActivity.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_NEW_TASK); // Elimina todas las actividades de la pila y crea una nueva instancia de LoginActivity
        startActivity(intent);
        finish(); // Cierra la actividad actual
        overridePendingTransition(R.anim.left_in, R.anim.left_out);
    }


}