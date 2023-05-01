package com.ista.gestion_capacitaciones.UI;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.ista.gestion_capacitaciones.R;
import com.ista.gestion_capacitaciones.adapter.LlenarListaEstudiantesAdapter;
import com.ista.gestion_capacitaciones.model.LlenarListaEstudiantes;

import java.util.ArrayList;
import java.util.List;

public class AsistenciasActivity extends AppCompatActivity{

    private RecyclerView listaEstudiantes;
    private LlenarListaEstudiantesAdapter estudiantesAdapter;

    private List<LlenarListaEstudiantes> estudiantesList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_asistencias);
        getSupportActionBar().hide();

        estudiantesList = new ArrayList<>();

        listaEstudiantes = findViewById(R.id.lista_estudiantes);
        listaEstudiantes.setLayoutManager((new LinearLayoutManager(this)));
        estudiantesAdapter = new LlenarListaEstudiantesAdapter((this));
        listaEstudiantes.setAdapter(estudiantesAdapter);

        LlenarListaEstudiantes estudiante = new LlenarListaEstudiantes();
        estudiante.setId(1);
        estudiante.setNombre("Pepe El Toro");
        estudiante.setStatus(0);

        estudiantesList.add(estudiante);
        estudiantesList.add(estudiante);
        estudiantesList.add(estudiante);

        estudiantesAdapter.setEstudiante(estudiantesList);
    }
}