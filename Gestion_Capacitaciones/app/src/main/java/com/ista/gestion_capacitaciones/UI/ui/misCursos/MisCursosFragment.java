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
        String idPer = preferences.getString("idPer", "");
        String idRol=preferences.getString("idRol","");
        if(idRol.equals("1")){
            cursosViewModel= new ViewModelProvider(this).get(MisCursosViewModel.class);
        }
        if (idRol.equals("2")){
            ViewModelProvider vmp=new ViewModelProvider(this);
            viewModel=vmp.get(CursoViewModel.class);
        }

    }
    private void initAdapter() {
        String idPer = preferences.getString("idPer", "");
        String idRol=preferences.getString("idRol","");
        if(idRol.equals("1")){
            cursosAdapter=new MisCursosAdapter(new ArrayList<>());
            rcvMisCursos.setLayoutManager(new GridLayoutManager(getContext(), 1));
            rcvMisCursos.setAdapter(cursosAdapter);
        }
        if (idRol.equals("2")){
            docenteAdapter=new CursosDocenteAdapter(new ArrayList<>());
            rcvMisCursos.setLayoutManager(new GridLayoutManager(getContext(), 1));
            rcvMisCursos.setAdapter(docenteAdapter);
        }

    }
    private void loadData() {
        String idPer = preferences.getString("idPer", "");
        String idRol=preferences.getString("idRol","");
        if (idRol.equals("2")){
            Toast.makeText(getContext(), "Docente", Toast.LENGTH_LONG).show();
            if (!idPer.equals("")) {
                Long id = Long.parseLong(idPer);
                this.viewModel.listarCursosDocente(id).observe(getViewLifecycleOwner(),cursos -> {
                    docenteAdapter.updateItems(cursos);
                });
            }

        }
        if(idRol.equals("1")){
            Toast.makeText(getContext(), "Participante", Toast.LENGTH_LONG).show();
            if (!idPer.equals("")) {
                Long id = Long.parseLong(idPer);
                this.cursosViewModel.ListarCursoPArticipante(id).observe(getViewLifecycleOwner(), participantes -> {
                    cursosAdapter.updateItems(participantes);
                });
            }
        }


    }



}