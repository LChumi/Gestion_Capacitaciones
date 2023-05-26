/*
 *
 *   Created Luis Chumi on 26/5/23 11:23
 *   Copyright Ⓒ 2023. All rights reserved Ⓒ 2023 http://freefuninfo.com/
 *   Last modified: 26/5/23 11:23
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

import android.os.Bundle;
import android.widget.TextView;

import com.ista.gestion_capacitaciones.R;
import com.ista.gestion_capacitaciones.viewmodel.RegistroViewModel;

import java.text.SimpleDateFormat;

public class DetalleCursoActivity extends AppCompatActivity {

    private RegistroViewModel viewModel;
    TextView txtCursNombre,txtCurProce,txtxModalida,txtFechaIni,txtFechaFin,txtDatosSila,txtCurricular,txtEspecialidad;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalle_curso);
        init();
        initViewModel();
        loadData();
    }

    private void initViewModel() {
        final ViewModelProvider vmp=new ViewModelProvider(this);
        viewModel=vmp.get(RegistroViewModel.class);
    }

    private void init(){
        Toolbar toolbar=this.findViewById(R.id.toolbar);
        toolbar.setNavigationIcon(R.drawable.ic_regresar);
        toolbar.setNavigationOnClickListener(v->{
            this.finish();
            this.overridePendingTransition(R.anim.rigth_in,R.anim.rigth_out);
        });
        txtCursNombre=findViewById(R.id.txtCurNombre);
        txtCurProce=findViewById(R.id.txtCurProce);
        txtxModalida=findViewById(R.id.txtModalidadC);
        txtFechaFin=findViewById(R.id.txtFechaFin);
        txtFechaIni=findViewById(R.id.txtFechaIni);
        txtDatosSila=findViewById(R.id.txtDatoSil);
        txtCurricular=findViewById(R.id.txtCurricular);
        txtEspecialidad=findViewById(R.id.txtEspecialidad);
    }

    public void loadData(){
        Long idCurso=getIntent().getLongExtra("idCurso",0);
        viewModel.getCurso(idCurso).observe(this,curso->{
            if (curso!=null){
                txtCursNombre.setText(curso.getCurNombre());
                txtCurProce.setText(curso.getCurProceso());
                txtxModalida.setText(curso.getMcursos().getMcuNombre());
                SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy"); // Define el formato deseado
                String fechaFormateada = dateFormat.format(curso.getCurFechainicio()); // Formatea la fecha
                txtFechaIni.setText(fechaFormateada); // Establece el texto formateado en el TextView
                String fechaFin=dateFormat.format(curso.getCurFechafin());
                txtFechaFin.setText(fechaFin);
                txtDatosSila.setText(curso.getDatosSilabo().getDsiDescripcioncurso());
                txtCurricular.setText(curso.getDisenoCurricular().getDcuTemastransversales());
                txtEspecialidad.setText(curso.getEcursos().getEspNombre());
            }
        });
    }

}