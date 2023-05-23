/*
 *
 *   Created Luis Chumi on 23/5/23 9:38
 *   Copyright Ⓒ 2023. All rights reserved Ⓒ 2023 http://freefuninfo.com/
 *   Last modified: 16/5/23 22:00
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
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import com.ista.gestion_capacitaciones.R;
import com.ista.gestion_capacitaciones.adapter.CursosPorProgramaAdapater;
import com.ista.gestion_capacitaciones.model.Curso;
import com.ista.gestion_capacitaciones.viewmodel.CursoViewModel;

import java.util.ArrayList;
import java.util.List;

public class ProgramaCursosActivity extends AppCompatActivity {
    private CursoViewModel cursoViewModel;
    private CursosPorProgramaAdapater cursosAdapater;
    private List<Curso> cursos=new ArrayList<>();
    private RecyclerView rcvCursoPrograma;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_programa_cursos);
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
        this.cursoViewModel=vmp.get(CursoViewModel.class);
    }
    private void initAdapter() {
        cursosAdapater=new CursosPorProgramaAdapater(cursos);
        rcvCursoPrograma=findViewById(R.id.rcvCursosPrograma);
        rcvCursoPrograma.setAdapter(cursosAdapater);
        rcvCursoPrograma.setLayoutManager(new LinearLayoutManager(this));
    }
    private void loadData() {
        Long idPrograma = getIntent().getLongExtra("idPrograma", 0);
        cursoViewModel.listarCursoPrograma(idPrograma).observe(this, cursos -> {
            if (cursos != null) {
                cursosAdapater.updateItems(cursos);
            } else {
                // Manejar el caso en el que la lista de cursos sea nula
                Toast.makeText(this, "No se encontraron cursos", Toast.LENGTH_SHORT).show();
            }
        });
    }

}