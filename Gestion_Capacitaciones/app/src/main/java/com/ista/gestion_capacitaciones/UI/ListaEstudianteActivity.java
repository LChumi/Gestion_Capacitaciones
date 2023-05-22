package com.ista.gestion_capacitaciones.UI;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.ista.gestion_capacitaciones.R;
import com.ista.gestion_capacitaciones.adapter.ListaEstudiantesAdapter;
import com.ista.gestion_capacitaciones.api.clients.AsistenciaApiClient;
import com.ista.gestion_capacitaciones.db.DbAsistencias;
import com.ista.gestion_capacitaciones.model.Participante;
import com.ista.gestion_capacitaciones.utils.AsistenciaUtil;
import com.ista.gestion_capacitaciones.viewmodel.MisCursosViewModel;

import java.util.ArrayList;
import java.util.List;

public class ListaEstudianteActivity extends AppCompatActivity {

    private MisCursosViewModel cursosViewModel;
    private ListaEstudiantesAdapter adapter;
    RecyclerView rcvListaEstudiantes;
    private Button btnGuardar;
    private List<Participante> participanteList=new ArrayList<>();
    private List<Integer> numFaltas=new ArrayList<>();
    private static final AsistenciaUtil ASISTENCIA_UTIL=new AsistenciaUtil();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista_estudiante);
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
        final ViewModelProvider vmp=new ViewModelProvider(this);
        this.cursosViewModel=vmp.get(MisCursosViewModel.class);
    }
    private void initAdapter() {
        adapter=new ListaEstudiantesAdapter(new ArrayList<>());
        rcvListaEstudiantes=findViewById(R.id.lista_estudiantes);
        rcvListaEstudiantes.setAdapter(adapter);
        rcvListaEstudiantes.setLayoutManager(new LinearLayoutManager(this));

        btnGuardar = findViewById(R.id.btnGuardarAsis);
        btnGuardar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    String resultado = AsistenciaUtil.agregarAsistencias(participanteList, numFaltas);
                    Log.i(resultado, resultado);
                } catch (Exception e) {
                    // Manejar la excepción o imprimir un mensaje de error
                    e.printStackTrace();
                    Log.e("Error", "Error al guardar las asistencias: " + e.getMessage());
                }
            }
        });

    }
    private void loadData() {
        Long idCurso=getIntent().getLongExtra("idCurso",0);
        cursosViewModel.listaAsistencias(idCurso).observe(this,participantes -> {
            if (participantes != null){
                adapter.updateItems(participantes);
                participanteList=participantes;
                numFaltas=adapter.getListaFaltas();
                for(Participante p:participantes){
                    Log.i("participante",p.toString());
                }
            }else{
                Toast.makeText(this, "No se encontraron participantes", Toast.LENGTH_SHORT).show();
            }
        });
    }
}