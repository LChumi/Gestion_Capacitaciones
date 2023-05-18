package com.ista.gestion_capacitaciones.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.ista.gestion_capacitaciones.R;
import com.ista.gestion_capacitaciones.model.Curso;
import com.ista.gestion_capacitaciones.model.Participante;

import java.util.List;

public class MisCursosAdapter extends RecyclerView.Adapter<MisCursosAdapter.ViewHolder> {

    private List<Participante> listarMisCursos;

    public MisCursosAdapter(List<Participante> listarMisCursos){
        this.listarMisCursos=listarMisCursos;
    }

    @NonNull
    @Override
    public MisCursosAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v= LayoutInflater.from(parent.getContext()).inflate(R.layout.elemento_curos_programa,parent,false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull MisCursosAdapter.ViewHolder holder, int position) {
        holder.setItem(this.listarMisCursos.get(position));
    }

    @Override
    public int getItemCount() {
        return this.listarMisCursos.size();
    }

    public void updateItems(List<Participante> cursosByParticipante){
        this.listarMisCursos.clear();
        this.listarMisCursos.addAll(cursosByParticipante);
        this.notifyDataSetChanged();
    }

    protected static class ViewHolder extends RecyclerView.ViewHolder{

        private final ImageView imgCurso;
        private final TextView txtNombreCurso, txtCurProceso;
        private final Button btnAplicar;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            this.imgCurso = itemView.findViewById(R.id.imgCurso);
            this.txtNombreCurso = itemView.findViewById(R.id.txtNombreCurso);
            this.txtCurProceso = itemView.findViewById(R.id.txtCurProceso);
            this.btnAplicar = itemView.findViewById(R.id.btnRegistrarCurso);
        }

        public void setItem(final Participante p) {
            // Código para cargar la imagen en el ImageView

            txtNombreCurso.setText(p.getParCurso().getCurNombre());
            txtCurProceso.setText(p.getParEstadoaprovacion());
            btnAplicar.setOnClickListener(v -> {
                // Código para registrar el curso
            });
        }
    }




}
