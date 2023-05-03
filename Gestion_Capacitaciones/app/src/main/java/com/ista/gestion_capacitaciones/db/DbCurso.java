package com.ista.gestion_capacitaciones.db;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import androidx.annotation.Nullable;

import com.ista.gestion_capacitaciones.model.dto.CursoDTO;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

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

    public List<CursoDTO> listarCursos(){
        SQLiteDatabase db=getReadableDatabase();
        List<CursoDTO> cursos=new ArrayList<>();
        CursoDTO cursoDTO=null;
        Cursor cursor=null;
        try {
            cursor=db.rawQuery("SELECT _rowid_ FROM "+ TABLE_CURSO,null);
            if (cursor.moveToFirst()){
                do {
                    cursoDTO=new CursoDTO();
                    cursoDTO.setCur_id(cursor.getLong(0));
                    cursoDTO.setCur_codigo(cursor.getLong(1));
                    cursoDTO.setCur_nombre(cursor.getString(2));
                    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd", Locale.getDefault());
                    Date fechaInicio = sdf.parse(cursor.getString(3));
                    cursoDTO.setCur_fechaInicio(fechaInicio);
                    Date fechaFin=sdf.parse(cursor.getString(4));
                    cursoDTO.setCur_numHora(cursor.getInt(5));
                    cursoDTO.setCur_proceso(cursor.getInt(6));
                    cursoDTO.setCur_estado(cursor.getInt(7) == 1);
                    cursos.add(cursoDTO);
                }while (cursor.moveToNext());
            }
            cursor.close();
        }catch (Exception e){
            Log.e("DbCurso","Error al listar"+e.getMessage());
        }finally {
            db.close();
        }
        return cursos;
    }

}
