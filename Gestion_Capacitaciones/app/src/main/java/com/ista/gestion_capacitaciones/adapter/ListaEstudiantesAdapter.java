package com.ista.gestion_capacitaciones.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.ista.gestion_capacitaciones.R;
import com.ista.gestion_capacitaciones.model.Participante;

import java.util.List;

public class ListaEstudiantesAdapter extends RecyclerView.Adapter<ListaEstudiantesAdapter.ViewHolder> {

    private List<Participante> listaParticipantes;

    public ListaEstudiantesAdapter(List<Participante> listaParticipantes){
        this.listaParticipantes=listaParticipantes;
    }

    @NonNull
    @Override
    public ListaEstudiantesAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v= LayoutInflater.from(parent.getContext()).inflate(R.layout.elemnto_lista_estudiantes,parent,false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull ListaEstudiantesAdapter.ViewHolder holder, int position) {
        holder.setItem(this.listaParticipantes.get(position));
    }

    @Override
    public int getItemCount() {
        return this.listaParticipantes.size();
    }

    public void updateItems(List<Participante> participantesByCurso){
        this.listaParticipantes.clear();
        this.listaParticipantes.addAll(participantesByCurso);
        this.notifyDataSetChanged();
    }

    protected class ViewHolder extends RecyclerView.ViewHolder{

        private TextView txtIdEstudinate;
        private TextView txtNombreEstudiante;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            this.txtIdEstudinate=itemView.findViewById(R.id.num_estudiante_text);
            this.txtNombreEstudiante=itemView.findViewById(R.id.nombre_estudiante_text);

        }

        public void setItem(Participante p){
            int numero = listaParticipantes.indexOf(p) + 1;
            txtIdEstudinate.setText(String.valueOf(numero));
            txtNombreEstudiante.setText(p.getParPersona().getNombre()+" "+p.getParPersona().getApellido());
        }


    }
}
