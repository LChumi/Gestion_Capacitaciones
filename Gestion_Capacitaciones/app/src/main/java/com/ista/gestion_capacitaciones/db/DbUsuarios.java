package com.ista.gestion_capacitaciones.db;

import android.content.Context;

import androidx.annotation.Nullable;

public class DbUsuarios extends SqlConexion{

    Context context;

    public DbUsuarios(@Nullable Context context) {
        super(context);
        this.context=context;
    }
}
