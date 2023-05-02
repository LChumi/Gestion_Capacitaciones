package com.ista.gestion_capacitaciones.db;

import android.content.Context;

import androidx.annotation.Nullable;

public class DbParticipantes extends SqlConexion{

    Context context;

    public DbParticipantes(@Nullable Context context) {
        super(context);
        this.context=context;
    }
}
