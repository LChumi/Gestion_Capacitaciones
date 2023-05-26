/*
 *
 *   Created Luis Chumi on 26/5/23 1:48
 *   Copyright Ⓒ 2023. All rights reserved Ⓒ 2023 http://freefuninfo.com/
 *   Last modified: 26/5/23 1:48
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

import android.content.Intent;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.ista.gestion_capacitaciones.R;
import com.ista.gestion_capacitaciones.UI.ListaEstudianteActivity;
import com.ista.gestion_capacitaciones.model.HorarioCurso;

import java.util.List;

public class HorariosAdapter extends RecyclerView.Adapter<HorariosAdapter.ViewHolder> {

    private static List<HorarioCurso> listaHorarios;
    private static Long idCurso;

    public HorariosAdapter(List<HorarioCurso> listaHorarios) {
        this.listaHorarios = listaHorarios;
    }

    @NonNull
    @Override
    public HorariosAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v= LayoutInflater.from(parent.getContext()).inflate(R.layout.elemento_jornada,parent,false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull HorariosAdapter.ViewHolder holder, int position) {
        holder.setItems(this.listaHorarios.get(position));
    }

    @Override
    public int getItemCount() {
        return this.listaHorarios.size();
    }

    public void updateItems(List<HorarioCurso> cursoByHorario,Long idCurso){
        this.idCurso=idCurso;
        this.listaHorarios.clear();
        this.listaHorarios.addAll(cursoByHorario);
        this.notifyDataSetChanged();
    }

    protected static class ViewHolder extends RecyclerView.ViewHolder{

        private TextView txtNombreHorario;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            this.txtNombreHorario = itemView.findViewById(R.id.txtNombreHorario);
            itemView.setOnClickListener(v -> {
                HorarioCurso horario = listaHorarios.get(getAdapterPosition());
                Long idHorario = horario.getHcuId(); // Obtener el ID del HorarioCurso

                Intent i = new Intent(itemView.getContext(), ListaEstudianteActivity.class);
                i.putExtra("idHorario", idHorario); // Pasar el ID como extra en el Intent
                i.putExtra("idCurso",idCurso);
                itemView.getContext().startActivity(i);
            });
        }
        public void setItems(HorarioCurso h){
            txtNombreHorario.setText(h.getHcuNombre());
        }
    }

}
