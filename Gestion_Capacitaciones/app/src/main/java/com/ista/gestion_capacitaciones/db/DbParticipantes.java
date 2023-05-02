package com.ista.gestion_capacitaciones.db;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import androidx.annotation.Nullable;

public class DbParticipantes extends SqlConexion{

    Context context;

    public DbParticipantes(@Nullable Context context) {
        super(context);
        this.context=context;
    }

    public long insertarParticipante(double notaParcial, double notaFinal, double notaPromedio, String observacion, boolean estado, int idPersona) {
        SQLiteDatabase db = getWritableDatabase();
        long result=-1;
        try{
            ContentValues valores = new ContentValues();
            valores.put("par_notaParcial", notaParcial);
            valores.put("par_notaFinal", notaFinal);
            valores.put("par_notaPromedio", notaPromedio);
            valores.put("par_observacion", observacion);
            valores.put("par_estado", estado);
            valores.put("per_id", idPersona);

            result= db.insert(TABLE_PARTICIPANTE, null, valores);
        }catch (Exception e){
            Log.e("DbParticipante", "Error al insertar participante: " + e.getMessage());
        }finally {
            db.close();
        }
        return result;

    }

}
