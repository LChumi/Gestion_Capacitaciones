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

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            this.imgCurso = itemView.findViewById(R.id.imgCurso);
            this.txtNombreCurso = itemView.findViewById(R.id.txtNombreCurso);
            this.txtCurProceso = itemView.findViewById(R.id.txtCurProceso);
            this.btnRegistrarCurso = itemView.findViewById(R.id.btnRegistrarCurso);
        }

        public void setItem(final Curso c) {
            // Código para cargar la imagen en el ImageView

            txtNombreCurso.setText(c.getCurNombre());
            txtCurProceso.setText(c.getCurProceso());
            btnRegistrarCurso.setOnClickListener(v -> {
                // Código para registrar el curso
            });
        }
    }
}

