/*
 *
 *   Created Luis Chumi on 26/5/23 1:24
 *   Copyright Ⓒ 2023. All rights reserved Ⓒ 2023 http://freefuninfo.com/
 *   Last modified: 26/5/23 1:24
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

import android.os.Bundle;

import com.ista.gestion_capacitaciones.R;
import com.ista.gestion_capacitaciones.adapter.HorariosAdapter;
import com.ista.gestion_capacitaciones.viewmodel.RegistroViewModel;

import java.util.ArrayList;

public class Modalidadctivity extends AppCompatActivity {

    private RegistroViewModel registroViewModel;
    private HorariosAdapter adapter;
    RecyclerView rcvHorarios;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_modalidadctivity);
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
        this.registroViewModel=vmp.get(RegistroViewModel.class);
    }
    private void initAdapter() {
        adapter=new HorariosAdapter(new ArrayList<>());
        rcvHorarios=findViewById(R.id.rcvHorarios);
        rcvHorarios.setAdapter(adapter);
        rcvHorarios.setLayoutManager(new LinearLayoutManager(this));

    }
    private void loadData() {
        Long idCurso=getIntent().getLongExtra("idCurso",0);
        registroViewModel.getByCurso(idCurso).observe(this,horarios ->{
            if (horarios!=null){
                adapter.updateItems(horarios,idCurso);
            }
        });
    }
}