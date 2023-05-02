package com.ista.gestion_capacitaciones.db;

import android.content.Context;

import androidx.annotation.Nullable;

public class DbAsistencias extends SqlConexion{

    Context context;

    public DbAsistencias(@Nullable Context context) {
        super(context);
        this.context=context;
    }
}
