/*
 *
 *   Created Luis Chumi on 23/5/23 9:38
 *   Copyright Ⓒ 2023. All rights reserved Ⓒ 2023 http://freefuninfo.com/
 *   Last modified: 22/5/23 22:50
 *
 *   Licensed under the Apache License, Version 2.0 (the "License"); you may not use this file
 *   except in compliance with the License. You may obtain a copy of the License at
 *   http://www.apache.org/licenses/LICENS... Unless required by applicable law or agreed to in writing, software
 *    distributed under the License is distributed on an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND,
 *    either express or implied. See the License for the specific language governing permissions and
 *    limitations under the License.
 * /
 */

package com.ista.gestion_capacitaciones.adapter;


import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.ista.gestion_capacitaciones.R;
import com.ista.gestion_capacitaciones.UI.RegistroCursoActivity;
import com.ista.gestion_capacitaciones.model.Curso;

import java.util.List;

public class CursosPorProgramaAdapater extends RecyclerView.Adapter<CursosPorProgramaAdapater.ViewHolder> {
    private List<Curso> listarCursoPrograma;

    public CursosPorProgramaAdapater(List<Curso> listarCursoPrograma) {
        this.listarCursoPrograma = listarCursoPrograma;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.elemento_curos_programa, parent, false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.setItem(this.listarCursoPrograma.get(position));
    }

    @Override
    public int getItemCount() {
        return this.listarCursoPrograma.size();
    }

    public void updateItems(List<Curso> cursosByPrograma) {
        this.listarCursoPrograma.clear();
        this.listarCursoPrograma.addAll(cursosByPrograma);
        this.notifyDataSetChanged();
    }

    protected static class ViewHolder extends RecyclerView.ViewHolder {
        private final ImageView imgCurso;
        private final TextView txtNombreCurso, txtCurProceso;
        private final Button btnRegistrarCurso;
        private SharedPreferences preferences;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            preferences = PreferenceManager.getDefaultSharedPreferences(itemView.getContext());
            this.imgCurso = itemView.findViewById(R.id.imgCurso);
            this.txtNombreCurso = itemView.findViewById(R.id.txtNombreCurso);
            this.txtCurProceso = itemView.findViewById(R.id.txtCurProceso);
            this.btnRegistrarCurso = itemView.findViewById(R.id.btnRegistrarCurso);

        }

        public void setItem(final Curso c) {
            // Código para cargar la imagen en el ImageView
            Long idRol = preferences.getLong("idRol", 0);
            txtNombreCurso.setText(c.getCurNombre());
            txtCurProceso.setText(c.getCurProceso());
            if (idRol.equals(2L)) {
                btnRegistrarCurso.setVisibility(View.GONE);
            }

            if (idRol.equals(1L)){
                btnRegistrarCurso.setOnClickListener(v -> {
                    Context context = itemView.getContext(); // Obtener el contexto
                    Intent registrar = new Intent(context, RegistroCursoActivity.class);
                    registrar.putExtra("idCurso",c.getCurId());
                    context.startActivity(registrar); // Llamar a startActivity() en el contexto
                });
            }
        }
    }
}

