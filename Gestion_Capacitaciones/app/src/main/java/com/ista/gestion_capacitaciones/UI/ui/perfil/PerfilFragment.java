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

package com.ista.gestion_capacitaciones.UI.ui.perfil;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridView;
import android.widget.ListAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.RecyclerView;

import com.ista.gestion_capacitaciones.R;
import com.ista.gestion_capacitaciones.adapter.CursosParticipanteAdapter;
import com.ista.gestion_capacitaciones.adapter.MisCursosAdapter;
import com.ista.gestion_capacitaciones.db.DbPersona;
import com.ista.gestion_capacitaciones.model.Persona;
import com.ista.gestion_capacitaciones.model.dto.PersonaDTO;
import com.ista.gestion_capacitaciones.viewmodel.CursoViewModel;
import com.ista.gestion_capacitaciones.viewmodel.MisCursosViewModel;
import com.ista.gestion_capacitaciones.viewmodel.RegistroViewModel;

import java.text.SimpleDateFormat;
import java.util.ArrayList;


public class PerfilFragment extends Fragment {

    private SharedPreferences preferences;
    private CursosParticipanteAdapter adapter;
    private MisCursosViewModel viewModel;
    private RegistroViewModel rViewModel;
    private GridView gvCursos;
    private TextView txtCedula,txtEmail,txtTelefono,txtCelular,txtDireccion,txtNivelI,txtFecha,txtGenero,txtEtnia,txtNombres,txtCargo;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_perfil,container,false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        init(view);
        initViewModel();
        initAdapter();
        loadData();
    }

    private void init(View v){
        preferences = PreferenceManager.getDefaultSharedPreferences(getContext());
        gvCursos=v.findViewById(R.id.gvMisCursos);
        txtCedula=v.findViewById(R.id.txtCedulaP);
        txtEmail=v.findViewById(R.id.txtEmailD);
        txtTelefono=v.findViewById(R.id.txtTelefonoD);
        txtCelular=v.findViewById(R.id.txtCelularD);
        txtDireccion=v.findViewById(R.id.txtDirecciónD);
        txtNivelI=v.findViewById(R.id.txtNivelD);
        txtFecha=v.findViewById(R.id.txtFechaD);
        txtGenero=v.findViewById(R.id.txtGeneroD);
        txtEtnia=v.findViewById(R.id.txtEtniaD);
        txtNombres=v.findViewById(R.id.txtNombresP);
        txtCargo=v.findViewById(R.id.txtCargo);

    }

    private void initViewModel(){
        viewModel=new ViewModelProvider(this).get(MisCursosViewModel.class);
        final ViewModelProvider vmp=new ViewModelProvider(this);
        this.rViewModel=vmp.get(RegistroViewModel.class);
    }

    private void initAdapter(){
        adapter = new CursosParticipanteAdapter(getContext(), new ArrayList<>());
        gvCursos.setAdapter(adapter);
    }

    private void loadData(){
        Long idPer = preferences.getLong("idPer", 0);
        Long idRol = preferences.getLong("idRol", 0);
        this.viewModel.ListarCursoPArticipante(idPer).observe(getViewLifecycleOwner(),cursos ->{
            adapter.updateItems(cursos);
        });
        if (idRol.equals(2L)) {
            txtCargo.setText("Docente");
        }
        if (idRol.equals(1L)){
            txtCargo.setText("Estudiante");
        }

        this.rViewModel.getPersona(idPer).observe(getViewLifecycleOwner(),persona -> {
            DbPersona dbPersona=new DbPersona(getContext());
            PersonaDTO personaDTO=dbPersona.obtenerPersona(idPer);
            if (persona!=null&& personaDTO!=null){
                if (persona.getNombre()!=null){
                    txtNombres.setText(persona.getNombre()+" "+persona.getApellido());
                    txtEtnia.setText(persona.getEtnia());
                    txtEmail.setText(persona.getEmail());
                    txtGenero.setText(persona.getSexo());
                    SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy"); // Define el formato deseado
                    String fechaFormateada = dateFormat.format(persona.getFecha_nacimiento()); // Formatea la fecha
                    txtFecha.setText(fechaFormateada); // Establece el texto formateado en el TextView
                    txtCelular.setText(persona.getCelular());
                    txtCedula.setText(persona.getCedula());
                    txtNivelI.setText(persona.getNivelintruccion());
                    txtTelefono.setText(persona.getTelefono());
                    txtDireccion.setText(persona.getDireccion());
                }else{
                    txtNombres.setText(personaDTO.getPer_nombres()+" "+personaDTO.getPer_apellidos());
                    txtCedula.setText(personaDTO.getPer_cedula());
                    SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy"); // Define el formato deseado
                    String fechaFormateada = dateFormat.format(personaDTO.getPer_fechaNacimiento()); // Formatea la fecha
                    txtFecha.setText(fechaFormateada); // Establece el texto formateado en el TextView
                    txtEmail.setText(personaDTO.getPer_correo());
                    txtEtnia.setText("");
                    txtGenero.setText("");
                    txtCelular.setText("");
                    txtNivelI.setText("");
                    txtTelefono.setText("");
                    txtDireccion.setText("");
                }
            }
        });

    }
}