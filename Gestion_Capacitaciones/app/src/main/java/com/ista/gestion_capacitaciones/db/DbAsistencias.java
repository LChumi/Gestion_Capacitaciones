package com.ista.gestion_capacitaciones.db;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import androidx.annotation.Nullable;

public class DbAsistencias extends SqlConexion{

    Context context;

    public DbAsistencias(@Nullable Context context) {
        super(context);
        this.context=context;
    }

    public long insertaAsistencia(int numAsistencia, String fecha, int parId) {
        SQLiteDatabase db = getWritableDatabase();
        long result =-1;
        try{
            ContentValues values = new ContentValues();
            values.put("asi_numAsistencia", numAsistencia);
            values.put("asi_fecha", fecha);
            values.put("par_id", parId);

            result= db.insert(TABLE_ASISTENCIA, null, values);
        }catch (Exception e){
            Log.e("DbAsistencia", "Error al insertar asistencia: " + e.getMessage());
        }finally {
            db.close();
        }
        return result;
    }
}
