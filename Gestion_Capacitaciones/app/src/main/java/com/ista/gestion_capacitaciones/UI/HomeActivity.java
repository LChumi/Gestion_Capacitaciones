package com.ista.gestion_capacitaciones.UI;

import android.os.Bundle;
import android.util.Log;
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
                R.id.nav_inicio, R.id.nav_cursos, R.id.nav_misCursos)
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
        Long personId = getIntent().getLongExtra("personaId", -1);
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
            Log.e(personaDTO.getPer_cedula(),"datos");
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
    public boolean onSupportNavigateUp() {
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment_content_home);
        return NavigationUI.navigateUp(navController, mAppBarConfiguration)
                || super.onSupportNavigateUp();
    }
}