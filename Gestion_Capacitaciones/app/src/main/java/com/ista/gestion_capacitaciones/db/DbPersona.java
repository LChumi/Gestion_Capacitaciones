package com.ista.gestion_capacitaciones.db;

import android.content.Context;

import androidx.annotation.Nullable;

public class DbPersona extends SqlConexion{

    Context context;

    public DbPersona(@Nullable Context context) {
        super(context);
        this.context=context;
    }

}
