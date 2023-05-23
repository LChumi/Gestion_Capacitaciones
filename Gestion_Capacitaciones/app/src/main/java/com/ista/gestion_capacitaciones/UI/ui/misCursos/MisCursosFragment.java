/*
 *
 *   Created Luis Chumi on 23/5/23 9:38
 *   Copyright Ⓒ 2023. All rights reserved Ⓒ 2023 http://freefuninfo.com/
 *   Last modified: 20/5/23 23:25
 *
 *   Licensed under the Apache License, Version 2.0 (the "License"); you may not use this file
 *   except in compliance with the License. You may obtain a copy of the License at
 *   http://www.apache.org/licenses/LICENS... Unless required by applicable law or agreed to in writing, software
 *    distributed under the License is distributed on an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND,
 *    either express or implied. See the License for the specific language governing permissions and
 *    limitations under the License.
 * /
 */

package com.ista.gestion_capacitaciones.UI.ui.misCursos;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.ista.gestion_capacitaciones.R;
import com.ista.gestion_capacitaciones.UI.HomeActivity;
import com.ista.gestion_capacitaciones.adapter.CursosDocenteAdapter;
import com.ista.gestion_capacitaciones.adapter.MisCursosAdapter;
import com.ista.gestion_capacitaciones.model.Participante;
import com.ista.gestion_capacitaciones.viewmodel.CursoViewModel;
import com.ista.gestion_capacitaciones.viewmodel.MisCursosViewModel;

import java.util.ArrayList;
import java.util.List;


public class MisCursosFragment extends Fragment {

    private MisCursosViewModel cursosViewModel;
    private CursoViewModel viewModel;
    private MisCursosAdapter cursosAdapter;
    private CursosDocenteAdapter docenteAdapter;
    private RecyclerView rcvMisCursos;
    private SharedPreferences preferences;


    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
       return inflater.inflate(R.layout.fragment_miscursos,container,false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        preferences = PreferenceManager.getDefaultSharedPreferences(requireContext());
        init(view);
        initViewModel();
        initAdapter();
        loadData();
    }

    private void init(View view) {
        rcvMisCursos= view.findViewById(R.id.rcvMisCursos);
    }
    private void initViewModel() {
        Long idPer = preferences.getLong("idPer", 0);
        Long idRol = preferences.getLong("idRol", 0);

        if (idRol.equals(1L)) {
            cursosViewModel = new ViewModelProvider(this).get(MisCursosViewModel.class);
        }
        if (idRol.equals(2L)) {
            ViewModelProvider vmp = new ViewModelProvider(this);
            viewModel = vmp.get(CursoViewModel.class);
        }
    }

    private void initAdapter() {
        Long idPer = preferences.getLong("idPer", 0);
        Long idRol=preferences.getLong("idRol",0);
        if(idRol.equals(1L)){
            cursosAdapter=new MisCursosAdapter(new ArrayList<>());
            rcvMisCursos.setLayoutManager(new GridLayoutManager(getContext(), 1));
            rcvMisCursos.setAdapter(cursosAdapter);
        }
        if (idRol.equals(2L)){
            docenteAdapter=new CursosDocenteAdapter(new ArrayList<>());
            rcvMisCursos.setLayoutManager(new GridLayoutManager(getContext(), 2));
            rcvMisCursos.setAdapter(docenteAdapter);
        }

    }
    private void loadData() {
        Long idPer = preferences.getLong("idPer", 0);
        Long idRol = preferences.getLong("idRol", 0);

        if (idRol.equals(2L)) {
            Toast.makeText(getContext(), "Docente", Toast.LENGTH_LONG).show();
            if (idPer != 0L) {
                Long id = idPer;
                this.viewModel.listarCursosDocente(id).observe(getViewLifecycleOwner(), cursos -> {
                    docenteAdapter.updateItems(cursos);
                });
            }
        }

        if (idRol.equals(1L)) {
            Toast.makeText(getContext(), "Participante", Toast.LENGTH_LONG).show();
            if (idPer != 0L) {
                Long id = idPer;
                this.cursosViewModel.ListarCursoPArticipante(id).observe(getViewLifecycleOwner(), participantes -> {
                    cursosAdapter.updateItems(participantes);
                });
            }
        }
    }




}