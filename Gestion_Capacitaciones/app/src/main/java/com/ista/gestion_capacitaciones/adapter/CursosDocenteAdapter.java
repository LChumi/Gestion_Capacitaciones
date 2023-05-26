/*
 *
 *   Created Luis Chumi on 23/5/23 9:38
 *   Copyright Ⓒ 2023. All rights reserved Ⓒ 2023 http://freefuninfo.com/
 *   Last modified: 18/5/23 22:35
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
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.ista.gestion_capacitaciones.R;
import com.ista.gestion_capacitaciones.UI.ListaEstudianteActivity;
import com.ista.gestion_capacitaciones.UI.Modalidadctivity;
import com.ista.gestion_capacitaciones.model.Curso;
import com.ista.gestion_capacitaciones.model.Participante;

import java.util.List;

public class CursosDocenteAdapter extends RecyclerView.Adapter<CursosDocenteAdapter.ViewHolder> {

    private List<Curso> listaCursoDocente;

    public CursosDocenteAdapter(List<Curso> listaAsistencias){
        this.listaCursoDocente=listaAsistencias;
    }

    @NonNull
    @Override
    public CursosDocenteAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v= LayoutInflater.from(parent.getContext()).inflate(R.layout.elemenstos_programa_cursos,parent,false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull CursosDocenteAdapter.ViewHolder holder, int position) {
        holder.setItem(this.listaCursoDocente.get(position));
    }

    @Override
    public int getItemCount() {
        return this.listaCursoDocente.size();
    }

    public void updateItems(List<Curso> cursosByDocente){
        this.listaCursoDocente.clear();
        this.listaCursoDocente.addAll(cursosByDocente);
        this.notifyDataSetChanged();
    }

    protected class ViewHolder extends RecyclerView.ViewHolder{

        private TextView txtNombreCurso;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            this.txtNombreCurso = itemView.findViewById(R.id.txtPrograma);
            itemView.setOnClickListener(v -> {
                Context context = itemView.getContext();
                Curso curso = listaCursoDocente.get(getAdapterPosition());
                Intent i = new Intent(context, Modalidadctivity.class);
                i.putExtra("idCurso", curso.getCurId());
                Log.i("curso",curso.getCurId().toString()+"|"+curso.getCurNombre());
                context.startActivity(i);
            });
        }

        public void setItem(final Curso c) {
            // Código para cargar la imagen en el ImageView
            txtNombreCurso.setTextSize(10);
            txtNombreCurso.setText(c.getCurNombre());


        }
    }
}
