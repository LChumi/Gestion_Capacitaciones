package com.ista.gestion_capacitaciones.adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.ista.gestion_capacitaciones.R;
import com.ista.gestion_capacitaciones.UI.ProgramaCursosActivity;
import com.ista.gestion_capacitaciones.model.ProgramaCapacitacion;

import java.util.List;

public class ProgamaAdapter extends ArrayAdapter<ProgramaCapacitacion> {

    public ProgamaAdapter(@NonNull Context context, int resource, @NonNull List<ProgramaCapacitacion> objects) {
        super(context, resource, objects);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        if (convertView==null){
            convertView= LayoutInflater.from(getContext()).inflate(R.layout.elemenstos_programa_cursos,parent,false);
        }
        ProgramaCapacitacion p=this.getItem(position);
        TextView txtPrograma=convertView.findViewById(R.id.txtPrograma);
        txtPrograma.setText(p.getPcaNombre());
        convertView.setOnClickListener(v -> {
            Intent i=new Intent(getContext(), ProgramaCursosActivity.class);
            i.putExtra("idPrograma",p.getPcaId());//id de programa
            getContext().startActivity(i);
        });
        return convertView;
    }
}
