package com.ista.gestion_capacitaciones.db;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import androidx.annotation.Nullable;

import com.ista.gestion_capacitaciones.model.Asistencia;
import com.ista.gestion_capacitaciones.model.dto.AsistenciaDTO;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

public class DbAsistencias extends SqlConexion{


    public DbAsistencias(@Nullable Context context) {
        super(context);
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

    public List<AsistenciaDTO> obtenerLista(){
        SQLiteDatabase db =getReadableDatabase();
        List<AsistenciaDTO> asistencias= new ArrayList<>();
        AsistenciaDTO asistenciaDTO=null;
        Cursor cursor=null;
        try{
            cursor=db.rawQuery("SELECT _rowid_ FROM "+ TABLE_ASISTENCIA,null);
            if (cursor.moveToFirst()){
                do {
                    asistenciaDTO=new AsistenciaDTO();
                    asistenciaDTO.setAsi_id(cursor.getLong(0));
                    asistenciaDTO.setAsi_numAsistencia(cursor.getInt(1));
                    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd", Locale.getDefault());
                    Date fecha = sdf.parse(cursor.getString(2));
                    asistenciaDTO.setAsi_fecha(fecha);
                    asistenciaDTO.setPar_id(cursor.getLong(3));
                    asistencias.add(asistenciaDTO);
                }while (cursor.moveToNext());
            }
            cursor.close();
        }catch (Exception e){
            Log.e("DbAsistencia", "Error al obtener asistencias:" + e.getMessage());
        }finally {
            db.close();
        }
        return asistencias;
    }

    public AsistenciaDTO obtenerAsistencia(Long id){
        AsistenciaDTO asistenciaDTO=null;
        SQLiteDatabase db=getReadableDatabase();
        Cursor cursor=null;

        try {
            cursor=db.query(TABLE_ASISTENCIA,null,"_rowid_=?",new String[]{String.valueOf(id)},null,null,null);
            if (cursor!=null && cursor.moveToFirst()){
                asistenciaDTO=new AsistenciaDTO();
                asistenciaDTO.setAsi_id(cursor.getLong(0));
                asistenciaDTO.setAsi_numAsistencia(cursor.getInt(1));
                SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd", Locale.getDefault());
                Date fecha = sdf.parse(cursor.getString(2));
                asistenciaDTO.setAsi_fecha(fecha);
                asistenciaDTO.setPar_id(cursor.getLong(3));
            }
        }catch (Exception e){
            Log.e("DbAsistencia","Error al obtener asistencias"+e.getMessage());
        }finally {
            if (cursor!=null){
                cursor.close();
            }
            db.close();
        }
        return asistenciaDTO;
    }

    public int eliminarAsistencia(Long id){
        SQLiteDatabase db=getWritableDatabase();
        int result=0;
        try {
            result=db.delete(TABLE_ASISTENCIA, "_rowid_=?", new String[]{String.valueOf(id)});
        }catch (Exception e){
            Log.e("Dbasistencia","Error al eliminar asistencia"+e.getMessage());
        }finally {
            db.close();
        }
        return result;
    }

    public int actualizar(Long id,int numAsistencia,String asi_fecha,Long par_id){
        SQLiteDatabase db=getWritableDatabase();
        int result=0;
        try{
            ContentValues values=new ContentValues();
            values.put("asi_numAsistencia",numAsistencia);
            values.put("asi_fecha",asi_fecha);
            values.put("par_id",par_id);

            result=db.update(TABLE_ASISTENCIA,values,"_rowid_=?",new String[]{String.valueOf(id)});
        }catch (Exception e){
            Log.e("DbAsistencias","Error al actualizar asistencia"+e.getMessage());
        }finally {
            db.close();
        }
        return result;
    }


}
