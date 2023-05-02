package com.ista.gestion_capacitaciones.db;

import android.content.Context;

import androidx.annotation.Nullable;

public class DbCurso extends SqlConexion{

    Context context;

    public DbCurso(@Nullable Context context) {
        super(context);
        this.context=context;
    }
}
