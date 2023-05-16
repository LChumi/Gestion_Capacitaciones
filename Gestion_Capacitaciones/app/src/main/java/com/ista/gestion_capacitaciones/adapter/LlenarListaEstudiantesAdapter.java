package com.ista.gestion_capacitaciones.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;

import androidx.recyclerview.widget.RecyclerView;

import com.ista.gestion_capacitaciones.R;
import com.ista.gestion_capacitaciones.UI.AsistenciasActivity;
import com.ista.gestion_capacitaciones.model.LlenarListaEstudiantes;

import java.util.List;

public class LlenarListaEstudiantesAdapter extends RecyclerView.Adapter<LlenarListaEstudiantesAdapter.ViewHolder> {

    private List<LlenarListaEstudiantes> llenarEstudiantesList;
    private AsistenciasActivity asistenciasActivity;

    public LlenarListaEstudiantesAdapter(AsistenciasActivity activity) {
        this.asistenciasActivity = activity;
    }

    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.elemnto_lista_estudiantes, parent, false);
        return new ViewHolder(itemView);
    }

    public void onBindViewHolder(ViewHolder holder, int position){
        LlenarListaEstudiantes item  = llenarEstudiantesList.get(position);
        holder.estudiante.setId(item.getId());
        holder.estudiante.setText(item.getNombre());
        holder.estudiante.setChecked(toBolean(item.getStatus()));
    }

    public int getItemCount(){
        return llenarEstudiantesList.size();
    }

    private boolean toBolean(int n){
        return n !=0;
    }

    public void setEstudiante(List<LlenarListaEstudiantes> llenarEstudiantesList){
        this.llenarEstudiantesList = llenarEstudiantesList;
        notifyDataSetChanged();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder{
        CheckBox estudiante;
        ViewHolder(View view){
            super(view);
            estudiante = view.findViewById(R.id.check_list_id);
        }
    }
}
