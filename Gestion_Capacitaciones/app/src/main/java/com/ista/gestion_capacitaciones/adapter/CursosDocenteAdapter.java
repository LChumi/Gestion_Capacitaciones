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
            this.txtNombreCurso=itemView.findViewById(R.id.txtPrograma);

        }

        public void setItem(final Curso c) {
            // Código para cargar la imagen en el ImageView
            txtNombreCurso.setText(c.getCurNombre());
        }
    }
}
