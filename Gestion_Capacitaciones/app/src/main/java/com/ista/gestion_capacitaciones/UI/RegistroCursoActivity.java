/*
 *
 *   Created Luis Chumi on 23/5/23 9:38
 *   Copyright Ⓒ 2023. All rights reserved Ⓒ 2023 http://freefuninfo.com/
 *   Last modified: 23/5/23 3:01
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

import android.app.ProgressDialog;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;
import android.preference.PreferenceManager;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.util.Patterns;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.google.android.material.textfield.TextInputLayout;
import com.ista.gestion_capacitaciones.R;
import com.ista.gestion_capacitaciones.model.FichaInscripcion;
import com.ista.gestion_capacitaciones.model.HorarioCurso;
import com.ista.gestion_capacitaciones.utils.RegistroUtil;
import com.ista.gestion_capacitaciones.viewmodel.RegistroViewModel;

import java.text.SimpleDateFormat;

import cn.pedant.SweetAlert.SweetAlertDialog;

public class RegistroCursoActivity extends AppCompatActivity {

    private RegistroViewModel registroViewModel;
    private FichaInscripcion fichaInscripcion;
    private RegistroUtil registroUtil;
    TextView txtCursoNombre, txtCodCurso,txtModalidadCurso,txtApellidos,txtCedula,txtSexo,txtTelConv,txtNombres,txtFechaNac,txtEtnia,txtCelular,txtCorreo,txtNivelIns;
    TextInputLayout txtInputTrabaEst,txtInputDireccionInsti,txtInputCorreoInstitucional,txtInputNumeroInstitucional,txtInputActividadInstitu,txtInputComoSeEntero,txtInputCursoSeguir,txtInputNombreAus,txtInputHorario,txtInputAutocomplete;
    EditText edtTrabaEst,edtDireccionInsti,edtCorreoInstitucional,edtNumeroInstitucional,edtActividadInstitu,edtComoSeEntero,edtCursoSeguir,edtNombreAus;
    private SharedPreferences preferences;
    Button btnAplicar;
    String[] items = {"Si", "No"};
    AutoCompleteTextView autoCompleteTxt,autocompleteTxtHorario;
    ArrayAdapter<String> adapterItems;
    ArrayAdapter<String> adapterHorarios;
    Long personaId,cursoId,horarioId;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registro_curso);
        init();
        initViewModel();
        loadData();
        edtCorreoInstitucional.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
            }

            @Override
            public void afterTextChanged(Editable s) {
                String email = s.toString();
                if (isValidEmail(email)) {
                    txtInputCorreoInstitucional.setError(null); // Elimina el mensaje de error si es válido
                } else {
                    txtInputCorreoInstitucional.setError("Correo electrónico no válido"); // Muestra el mensaje de error si no es válido
                }
            }
        });
    }

    private void initViewModel() {
        final ViewModelProvider vmp=new ViewModelProvider(this);
        this.registroViewModel=vmp.get(RegistroViewModel.class);
    }

    private void init(){
        //inicializacion y configuracion de boton de regreso
        Toolbar toolbar=this.findViewById(R.id.toolbar);
        toolbar.setNavigationIcon(R.drawable.ic_regresar);
        toolbar.setNavigationOnClickListener(v->{
            this.finish();
            this.overridePendingTransition(R.anim.rigth_in,R.anim.rigth_out);
        });

        fichaInscripcion =new FichaInscripcion();
        preferences = PreferenceManager.getDefaultSharedPreferences(this);
        registroUtil=new RegistroUtil();
        //inicializacion de texViews
        txtCursoNombre=findViewById(R.id.txtCursoNombre);
        txtCodCurso=findViewById(R.id.txtCodCurso);
        txtModalidadCurso=findViewById(R.id.txtModalidad);
        txtApellidos=findViewById(R.id.txtApellidos);
        txtCedula=findViewById(R.id.txtCedula);
        txtSexo=findViewById(R.id.txtSexo);
        txtTelConv=findViewById(R.id.txtTelConv);
        txtNombres=findViewById(R.id.txtNombres);
        txtFechaNac=findViewById(R.id.txtFechaNac);
        txtEtnia=findViewById(R.id.txtEtnia);
        txtCelular=findViewById(R.id.txtCelular);
        txtCorreo=findViewById(R.id.txtCorreo);
        txtNivelIns=findViewById(R.id.txtNivelInstruccion);
        //inicializacion de textInputs
        txtInputTrabaEst=findViewById(R.id.txtInputTrabajoEst);
        txtInputDireccionInsti=findViewById(R.id.txtInputDireccionInst);
        txtInputCorreoInstitucional=findViewById(R.id.txtInputCorreoInsti);
        txtInputNumeroInstitucional=findViewById(R.id.txtInputNumeroInstitucional);
        txtInputActividadInstitu=findViewById(R.id.txtInputActividadInstitucion);
        txtInputComoSeEntero=findViewById(R.id.txtInputComoSeEntero);
        txtInputCursoSeguir=findViewById(R.id.txtInputCursosSeguir);
        txtInputNombreAus=findViewById(R.id.txtInputNombreAus);
        txtInputHorario=findViewById(R.id.txtInputHorario);
        txtInputAutocomplete=findViewById(R.id.txtInputAutocomplete);
        //inicializacion de editText
        edtTrabaEst=findViewById(R.id.edtTrabajoEst);
        edtDireccionInsti=findViewById(R.id.edtDireccionInst);
        edtCorreoInstitucional=findViewById(R.id.edtCorreoInsti);
        edtNumeroInstitucional=findViewById(R.id.edtNumeroInstitucional);
        edtActividadInstitu=findViewById(R.id.edtActividadInstitucion);
        edtComoSeEntero=findViewById(R.id.edtComoSeEntero);
        edtCursoSeguir=findViewById(R.id.edtCursosSeguir);
        edtNombreAus=findViewById(R.id.edtNombreAus);
        //inicializacion de buttons
        btnAplicar=findViewById(R.id.btnAplicarCurso);
        //inicializacion de Autocompete(combobox)
        autocompleteTxtHorario=findViewById(R.id.autocompleteTxtHorario);
        adapterHorarios=new ArrayAdapter<>(this,R.layout.lista_items);
        autoCompleteTxt = findViewById(R.id.autocompleteTxt);
        adapterItems = new ArrayAdapter<>(this, R.layout.lista_items, items);
        autoCompleteTxt.setAdapter(adapterItems);
        autoCompleteTxt.setOnItemClickListener((adapterView, view, i, l) -> {
            if (!isFinishing()) {
                String item = adapterView.getItemAtPosition(i).toString();
                Log.i("item", item);
                if (item.equals("Si")){
                    fichaInscripcion.setFinAuspiciadoinst(true);
                }
                if (item.equals("No")){
                    fichaInscripcion.setFinAuspiciadoinst(false);
                }
            }
        });

    }

    public void loadData(){
        Long idPer = preferences.getLong("idPer", 0);
        Long idCurso= getIntent().getLongExtra("idCurso",0);
        registroViewModel.getCurso(idCurso).observe(this,curso -> {
            if (curso!=null){
                cursoId=curso.getCurId();
                fichaInscripcion.setFinCurso(curso);
                txtCursoNombre.setText(curso.getCurNombre());
                txtCodCurso.setText(curso.getCurCodigo());
                txtModalidadCurso.setText(curso.getMcursos().getMcuNombre());
            }
        });
        registroViewModel.getByCurso(idCurso).observe(this, horarioCursos -> {
            if (horarioCursos != null) {
                adapterHorarios.clear();
                for (HorarioCurso h : horarioCursos) {
                    adapterHorarios.add(h.getHcuNombre());
                }
                autocompleteTxtHorario.setAdapter(adapterHorarios);

                autocompleteTxtHorario.setOnItemClickListener((adapterView, view, position, id) -> {
                    HorarioCurso selectedHorario = horarioCursos.get(position); // Obtener el objeto HorarioCurso seleccionado
                    Long selectedId = selectedHorario.getHcuId();
                    horarioId=selectedId;
                    fichaInscripcion.setFinHorario(selectedHorario);
                });
            }
        });
        registroViewModel.getPersona(idPer).observe(this,persona -> {
            if (persona!=null){
                personaId=persona.getId_persona();
                fichaInscripcion.setFinPersona(persona);
                txtApellidos.setText(persona.getApellido());
                txtCedula.setText(persona.getCedula());
                txtSexo.setText(persona.getSexo());
                txtTelConv.setText(persona.getTelefono());
                txtNombres.setText(persona.getNombre());
                SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy"); // Define el formato deseado
                String fechaFormateada = dateFormat.format(persona.getFecha_nacimiento()); // Formatea la fecha
                txtFechaNac.setText(fechaFormateada);
                txtEtnia.setText(persona.getEtnia());
                txtCedula.setText(persona.getCelular());
                txtCorreo.setText(persona.getEmail());
                txtNivelIns.setText(persona.getNivelintruccion());
            }
        });

        btnAplicar.setOnClickListener(v -> {
            if (validar()) {
                ProgressDialog progressDialog = ProgressDialog.show(this, "", "Registrando curso...", true);
                progressDialog.setCancelable(false);

                new Handler().postDelayed(() -> {
                    if (!isFinishing()){
                        fichaInscripcion.setFinId(0L);
                        fichaInscripcion.setFinAprobacion(0);
                        fichaInscripcion.setFinInstituciontraest("Ista");
                        fichaInscripcion.setFinEstado(true);
                        fichaInscripcion.setFinNombreauspicia(edtNombreAus.getText().toString());
                        fichaInscripcion.setFinActividadinst(edtActividadInstitu.getText().toString());
                        fichaInscripcion.setFinDireccioninst(edtDireccionInsti.getText().toString());
                        fichaInscripcion.setFinCorreoinst(edtCorreoInstitucional.getText().toString());
                        fichaInscripcion.setFinTelefonoinst(edtNumeroInstitucional.getText().toString());
                        fichaInscripcion.setFinComoentero(edtComoSeEntero.getText().toString());
                        fichaInscripcion.setFinOtroscursosdesea(edtCursoSeguir.getText().toString());
                        Log.i("Dato",fichaInscripcion.toString());
                        registroUtil.guardarFichaEnApi(fichaInscripcion,personaId,cursoId,horarioId);

                    }


                    progressDialog.dismiss();

                    new SweetAlertDialog(this, SweetAlertDialog.SUCCESS_TYPE)
                            .setTitleText("Información")
                            .setContentText("Se ha registrado a este curso")
                            .setConfirmText("Aceptar")
                            .setConfirmClickListener(sweetAlertDialog -> {
                                // Código adicional después de aceptar
                                this.overridePendingTransition(R.anim.rigth_in, R.anim.rigth_out);
                                Intent regresar = new Intent(this, HomeActivity.class);
                                startActivity(regresar);
                            })
                            .show();
                }, 2000); // Simula un tiempo de espera de 2 segundos antes de registrar el curso y mostrar el diálogo de éxito
            }
        });


    }
    private boolean validar(){
        boolean estado=true;
        TextInputLayout[] campos={txtInputTrabaEst,txtInputDireccionInsti,txtInputComoSeEntero,txtInputCorreoInstitucional,txtInputNumeroInstitucional,txtInputActividadInstitu,txtInputCursoSeguir,txtInputNombreAus};
        for(TextInputLayout campo:campos){
            EditText editText=campo.getEditText();
            String valor =editText.getText().toString();
            if (valor.isEmpty()){
                campo.setError("Este campo es obligatorio");
                campo.setErrorEnabled(true);
                estado=false;
            }else {
                campo.setError(null);
                campo.setErrorEnabled(false);
            }
            editText.setOnTouchListener((v,event)->{
                campo.setError(null);
                campo.setErrorEnabled(false);
                return false;
            });
        }
        String horarioSeleccionado = autocompleteTxtHorario.getText().toString();
        if (horarioSeleccionado.isEmpty()) {
            // Mostrar error en el autocompletado de horarios
            autocompleteTxtHorario.setError("Seleccione un horario");
            estado = false;
        } else {
            // No hay error, limpiar el error en el autocompletado de horarios
            autocompleteTxtHorario.setError(null);
        }

        // Validación del autocompletado de opciones
        String opcionSeleccionada = autoCompleteTxt.getText().toString();
        if (opcionSeleccionada.isEmpty()) {
            // Mostrar error en el autocompletado de opciones
            autoCompleteTxt.setError("Seleccione una opción");
            estado = false;
        } else {
            // No hay error, limpiar el error en el autocompletado de opciones
            autoCompleteTxt.setError(null);
        }

        return estado;
    }

    private boolean isValidEmail(CharSequence email) {
        return Patterns.EMAIL_ADDRESS.matcher(email).matches();
    }

}


