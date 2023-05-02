package com.ista.gestion_capacitaciones.db;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import androidx.annotation.Nullable;

public class DbPersona extends SqlConexion{

    Context context;

    public DbPersona(@Nullable Context context) {
        super(context);
        this.context=context;
    }

    public long insertaPersona(String cedula, String nombres, String apellidos, String fechaNacimiento, String correo, boolean estado) {
        SQLiteDatabase db = this.getWritableDatabase();
        long result=-1;
        try {
            ContentValues valores = new ContentValues();
            valores.put("per_cedula", cedula);
            valores.put("per_nombres", nombres);
            valores.put("per_apellidos", apellidos);
            valores.put("per_fechaNacimiento", fechaNacimiento);
            valores.put("per_correo", correo);
            valores.put("per_estado", estado);

            result= db.insert(TABLE_PERSONA, null, valores);
        }catch (Exception e){
            Log.e("DbPersona", "Error al insertar persona: " + e.getMessage());
        }finally {
            db.close();
        }

        return result;
    }


}
