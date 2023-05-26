/*
 *
 *   Created Luis Chumi on 23/5/23 9:38
 *   Copyright Ⓒ 2023. All rights reserved Ⓒ 2023 http://freefuninfo.com/
 *   Last modified: 22/5/23 20:50
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
import androidx.appcompat.widget.Toolbar;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.ista.gestion_capacitaciones.R;
import com.ista.gestion_capacitaciones.adapter.ListaEstudiantesAdapter;
import com.ista.gestion_capacitaciones.model.Participante;
import com.ista.gestion_capacitaciones.utils.AsistenciaUtil;
import com.ista.gestion_capacitaciones.viewmodel.MisCursosViewModel;

import java.util.ArrayList;
import java.util.List;

import cn.pedant.SweetAlert.SweetAlertDialog;

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
                alert();
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

    public void alert(){
        new SweetAlertDialog(this,SweetAlertDialog.SUCCESS_TYPE).setTitleText("Guardar la lista de asistencias")
                .setContentText("Desea guardar la lista de asistencia ?")
                .setCancelText("No, Cancelar!").setConfirmText("Si, Guardar")
                .showCancelButton(true).setCancelClickListener(sDialog ->{
                    sDialog.dismissWithAnimation();
                    new SweetAlertDialog(this,SweetAlertDialog.ERROR_TYPE).setTitleText("Operacion cancelada")
                            .setContentText("No se guardo las asistencias")
                            .show();
                }).setConfirmClickListener(sweetAlertDialog -> {
                    sweetAlertDialog.dismissWithAnimation();
                    try {
                        String resultado = AsistenciaUtil.agregarAsistencias(participanteList, numFaltas);
                        Log.i(resultado, resultado);
                        this.finish();
                        this.overridePendingTransition(R.anim.rigth_in,R.anim.rigth_out);
                        Intent regresar = new Intent(this, HomeActivity.class);
                        startActivity(regresar);
                    } catch (Exception e) {
                        // Manejar la excepción o imprimir un mensaje de error
                        e.printStackTrace();
                        Log.e("Error", "Error al guardar las asistencias: " + e.getMessage());

                    }
                }).show();
    }
}