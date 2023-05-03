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
        long result = -1;
        try (
                SQLiteDatabase db = getWritableDatabase();
        ) {
            ContentValues values = new ContentValues();
            values.put("cur_codigo", codigo);
            values.put("cur_nombre", nombre);

            // Convert fechaInicio to yyyy-MM-dd format
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd", Locale.getDefault());
            String fechaInicioFormatted = sdf.format(fechaInicio);
            values.put("cur_fechaInicio", fechaInicioFormatted);

            // Convert fechaFin to yyyy-MM-dd format
            String fechaFinFormatted = sdf.format(fechaFin);
            values.put("cur_fechaFin", fechaFinFormatted);
            values.put("cur_numHora", numHoras);
            values.put("cur_proceso", proceso);
            values.put("cur_estado", estado);

            result = db.insert(TABLE_CURSO, null, values);
        } catch (Exception e) {
            Log.e("DbCurso", "Error al insertar curso: " + e.getMessage());
        }
        return result;
    }


    public List<CursoDTO> obtenerLista() {
        List<CursoDTO> cursos = new ArrayList<>();
        try (
                SQLiteDatabase db = getReadableDatabase();
                Cursor cursor = db.rawQuery("SELECT * FROM " + TABLE_CURSO, null);
        ) {
            if (cursor.moveToFirst()) {
                do {
                    CursoDTO cursoDTO = new CursoDTO();
                    cursoDTO.setCur_id(cursor.getLong(0));
                    cursoDTO.setCur_codigo(cursor.getLong(1));
                    cursoDTO.setCur_nombre(cursor.getString(2));
                    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd", Locale.getDefault());
                    cursoDTO.setCur_fechaInicio(sdf.parse(cursor.getString(3)));
                    cursoDTO.setCur_fechaFin(sdf.parse(cursor.getString(4)));
                    cursoDTO.setCur_numHora(cursor.getInt(5));
                    cursoDTO.setCur_proceso(cursor.getInt(6));
                    cursoDTO.setCur_estado(cursor.getInt(7) == 1);
                    cursos.add(cursoDTO);
                } while (cursor.moveToNext());
            }
        } catch (Exception e) {
            Log.e("DbCurso", "Error al listar", e);
        }
        return cursos;
    }


    public CursoDTO obtenerCurso(Long id) {
        CursoDTO cursoDTO = null;
        try (
                SQLiteDatabase db = getReadableDatabase();
                Cursor cursor = db.query(TABLE_CURSO, null, "_rowid_ = ?", new String[]{String.valueOf(id)}, null, null, null);
        ) {
            if (cursor != null && cursor.moveToNext()) {
                cursoDTO = new CursoDTO();
                cursoDTO.setCur_id(cursor.getLong(0));
                cursoDTO.setCur_codigo(cursor.getLong(1));
                cursoDTO.setCur_nombre(cursor.getString(2));
                SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd", Locale.getDefault());
                cursoDTO.setCur_fechaInicio(sdf.parse(cursor.getString(3)));
                cursoDTO.setCur_fechaFin(sdf.parse(cursor.getString(4)));
                cursoDTO.setCur_numHora(cursor.getInt(5));
                cursoDTO.setCur_proceso(cursor.getInt(6));
                cursoDTO.setCur_estado(cursor.getInt(7) == 1);
            }
        } catch (Exception e) {
            Log.e("DbCurso", "Error al obtener curso", e);
        }
        return cursoDTO;
    }


    public int eliminarCurso(Long id) {
        int result = 0;
        try (
                SQLiteDatabase db = getWritableDatabase();
        ) {
            result = db.delete(TABLE_CURSO, "_rowid_ = ?", new String[]{String.valueOf(id)});
        } catch (Exception e) {
            Log.e("DbCurso", "Error al eliminar curso", e);
        }
        return result;
    }


    public int actualizar(Long id, Long codigo, String nombre, String fechaInicio, String fechaFin, int numeroHora, int proceso, boolean estado) {
        int result = 0;
        try (
                SQLiteDatabase db = getWritableDatabase();
        ) {
            ContentValues values = new ContentValues();
            values.put("cur_codigo", codigo);
            values.put("cur_nombre", nombre);
            values.put("cur_fechaInicio", fechaInicio);
            values.put("cur_fechaFin", fechaFin);
            values.put("cur_numHora", numeroHora);
            values.put("cur_proceso", proceso);
            values.put("cur_estado", estado);

            result = db.update(TABLE_CURSO, values, "_rowid_ = ?", new String[]{String.valueOf(id)});
        } catch (Exception e) {
            Log.e("DbCurso", "Error al actualizar el curso", e);
        }
        return result;
    }


}
