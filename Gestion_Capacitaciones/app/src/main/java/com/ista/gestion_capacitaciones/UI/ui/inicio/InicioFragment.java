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

package com.ista.gestion_capacitaciones.UI.ui.inicio;

import android.graphics.Color;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import com.ista.gestion_capacitaciones.R;
import com.ista.gestion_capacitaciones.adapter.ProgamaAdapter;
import com.ista.gestion_capacitaciones.adapter.SliderAdapter;
import com.ista.gestion_capacitaciones.model.ProgramaCapacitacion;
import com.ista.gestion_capacitaciones.model.SliderItem;
import com.ista.gestion_capacitaciones.viewmodel.ProgramaViewModel;
import com.smarteist.autoimageslider.IndicatorView.animation.type.IndicatorAnimationType;
import com.smarteist.autoimageslider.SliderAnimations;
import com.smarteist.autoimageslider.SliderView;

import java.util.ArrayList;
import java.util.List;

public class InicioFragment extends Fragment {

    private ProgramaViewModel programaViewModel;
    private GridView gvPrograma;
    private ProgamaAdapter programaAdapter;
    private SliderView svCarrucel;
    private SliderAdapter sliderAdapter;
    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_inicio,container,false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        init(view);
        initAdapter();
        loadData();
    }

    private void init(View v){
        svCarrucel=v.findViewById(R.id.svCarrusel);
        ViewModelProvider vmp=new ViewModelProvider(this);
        programaViewModel =vmp.get(ProgramaViewModel.class);
        gvPrograma=v.findViewById(R.id.gvPrograma);
    }

    private void initAdapter(){
        sliderAdapter = new SliderAdapter(getContext());
        svCarrucel.setSliderAdapter(sliderAdapter);
        svCarrucel.setIndicatorAnimation(IndicatorAnimationType.WORM); //set indicator animation by using IndicatorAnimationType. :WORM or THIN_WORM or COLOR or DROP or FILL or NONE or SCALE or SCALE_DOWN or SLIDE and SWAP!!
        svCarrucel.setSliderTransformAnimation(SliderAnimations.SIMPLETRANSFORMATION);
        svCarrucel.setAutoCycleDirection(SliderView.AUTO_CYCLE_DIRECTION_BACK_AND_FORTH);
        svCarrucel.setIndicatorSelectedColor(Color.WHITE);
        svCarrucel.setIndicatorUnselectedColor(Color.GRAY);
        svCarrucel.setScrollTimeInSec(4); //set scroll delay in seconds :
        svCarrucel.startAutoCycle();

        programaAdapter=new ProgamaAdapter(getContext(),R.layout.elemenstos_programa_cursos,new ArrayList<>());
        gvPrograma.setAdapter(programaAdapter);
    }

    private void loadData() {

        List<SliderItem> lista=new ArrayList<>();
        lista.add(new SliderItem(R.drawable.img_inicio,"Presentacion"));
        lista.add(new SliderItem(R.drawable.img_docentes,"Docentes"));
        lista.add(new SliderItem(R.drawable.img_mision,"Mision"));
        lista.add(new SliderItem(R.drawable.img_institucion,"Insitucion"));
        sliderAdapter.updateItem(lista);

        programaViewModel.listarProgramasCapacitacion().observe(getViewLifecycleOwner(), new Observer<List<ProgramaCapacitacion>>() {
            @Override
            public void onChanged(List<ProgramaCapacitacion> programas) {
                programaAdapter.clear();
                programaAdapter.addAll(programas);
                programaAdapter.notifyDataSetChanged();
            }
        });
    }



}