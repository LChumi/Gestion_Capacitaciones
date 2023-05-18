package com.ista.gestion_capacitaciones.UI;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.ista.gestion_capacitaciones.R;
import com.ista.gestion_capacitaciones.adapter.ListaEstudiantesAdapter;
import com.ista.gestion_capacitaciones.model.Participante;
import com.ista.gestion_capacitaciones.viewmodel.MisCursosViewModel;

import java.util.ArrayList;
import java.util.List;

public class AsistenciasActivity extends AppCompatActivity{

    private MisCursosViewModel cursosViewModel;
    private ListaEstudiantesAdapter estudiantesAdapter;
    private List<Participante> participantes=new ArrayList<>();
    private RecyclerView rcvListaAsistencias;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_asistencias);
        init();
        initViewModel();
        initAdapter();
        loadData();
    }
    private void init() {
        Toolbar toolbar=this.findViewById(R.id.toolbar);
        toolbar.setNavigationIcon(R.drawable.ic_regresar);
        toolbar.setNavigationOnClickListener(v->{
            this.finish();
            this.overridePendingTransition(R.anim.rigth_in,R.anim.rigth_out);
        });
    }
    private void initViewModel() {
        cursosViewModel=new ViewModelProvider(this).get(MisCursosViewModel.class);
    }
    private void initAdapter() {
        estudiantesAdapter=new ListaEstudiantesAdapter(participantes);
        rcvListaAsistencias=findViewById(R.id.lista_estudiantes);
        rcvListaAsistencias.setAdapter(estudiantesAdapter);
        rcvListaAsistencias.setLayoutManager(new LinearLayoutManager(this));

    }
    private void loadData() {


    }
}