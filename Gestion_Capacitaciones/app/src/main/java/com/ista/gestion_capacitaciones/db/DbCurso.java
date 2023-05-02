package com.ista.gestion_capacitaciones.db;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import androidx.annotation.Nullable;

public class DbCurso extends SqlConexion{

    Context context;

    public DbCurso(@Nullable Context context) {
        super(context);
        this.context=context;
    }

    public long insertarCurso(int codigo, String nombre, String fechaInicio, String fechaFin, int numHoras, int proceso, boolean estado) {
        SQLiteDatabase db = this.getWritableDatabase();
        long result=-1;
        try{
            ContentValues values = new ContentValues();
            values.put("cur_codigo", codigo);
            values.put("cur_nombre", nombre);
            values.put("cur_fechaInicio", fechaInicio);
            values.put("cur_fechaFin", fechaFin);
            values.put("cur_numHora", numHoras);
            values.put("cur_proceso", proceso);
            values.put("cur_estado", estado);

            result = db.insert(TABLE_CURSO, null, values);
        }catch (Exception e){
            Log.e("DbCurso", "Error al insertar curso: " + e.getMessage());
        }finally {
            db.close();
        }
        return result;
    }
}
