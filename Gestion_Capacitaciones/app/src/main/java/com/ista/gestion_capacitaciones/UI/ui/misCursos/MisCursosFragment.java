package com.ista.gestion_capacitaciones.UI.ui.misCursos;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import com.ista.gestion_capacitaciones.R;



public class MisCursosFragment extends Fragment {

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
       return inflater.inflate(R.layout.fragment_miscursos,container,false);
    }

}