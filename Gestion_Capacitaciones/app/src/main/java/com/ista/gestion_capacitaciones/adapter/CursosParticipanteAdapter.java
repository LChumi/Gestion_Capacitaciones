/*
 *
 *   Created Luis Chumi on 25/5/23 1:32
 *   Copyright Ⓒ 2023. All rights reserved Ⓒ 2023 http://freefuninfo.com/
 *   Last modified: 25/5/23 1:32
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
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.ista.gestion_capacitaciones.R;
import com.ista.gestion_capacitaciones.model.Participante;

import java.util.List;

public class CursosParticipanteAdapter extends BaseAdapter {

    private List<Participante> listaCursos;
    private Context context;

    public CursosParticipanteAdapter(Context context, List<Participante> listaCursos){
        this.context = context;
        this.listaCursos = listaCursos;
    }

    @Override
    public int getCount() {
        return listaCursos.size();
    }

    @Override
    public Object getItem(int position) {
        return listaCursos.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder;

        if (convertView == null) {
            convertView = LayoutInflater.from(context).inflate(R.layout.elemenstos_programa_cursos, parent, false);
            holder = new ViewHolder(convertView);
            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }

        Participante participante = listaCursos.get(position);
        holder.setItem(participante);

        return convertView;
    }

    public void updateItems(List<Participante> cursosByParticipante){
        this.listaCursos.clear();
        this.listaCursos.addAll(cursosByParticipante);
        notifyDataSetChanged();
    }

    protected static class ViewHolder {
        private final TextView txtNombreCurso;

        public ViewHolder(View itemView) {
            this.txtNombreCurso = itemView.findViewById(R.id.txtPrograma);
        }

        public void setItem(final Participante p){
            txtNombreCurso.setText(p.getParCurso().getCurNombre());
            txtNombreCurso.setTextSize(TypedValue.COMPLEX_UNIT_DIP, 10);
        }
    }
}

