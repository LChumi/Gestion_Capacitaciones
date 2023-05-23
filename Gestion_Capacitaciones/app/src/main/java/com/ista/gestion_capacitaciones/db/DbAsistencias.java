/*
 *
 *   Created Luis Chumi on 23/5/23 9:38
 *   Copyright Ⓒ 2023. All rights reserved Ⓒ 2023 http://freefuninfo.com/
 *   Last modified: 21/5/23 18:13
 *
 *   Licensed under the Apache License, Version 2.0 (the "License"); you may not use this file
 *   except in compliance with the License. You may obtain a copy of the License at
 *   http://www.apache.org/licenses/LICENS... Unless required by applicable law or agreed to in writing, software
 *    distributed under the License is distributed on an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND,
 *    either express or implied. See the License for the specific language governing permissions and
 *    limitations under the License.
 * /
 */

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

    public long insertarAsistencia(int numAsistencia, Date fecha, Long parId) {
        long result = -1;
        try (
                SQLiteDatabase db = getWritableDatabase();
        ) {
            ContentValues values = new ContentValues();
            values.put("asi_numAsistencia", numAsistencia);

            // Convert fecha to yyyy-MM-dd format
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd", Locale.getDefault());
            String fechaFormatted = sdf.format(fecha);
            values.put("asi_fecha", fechaFormatted);

            values.put("par_id", parId);

            result = db.insert(TABLE_ASISTENCIA, null, values);
        } catch (Exception e) {
            Log.e("DbAsistencia", "Error al insertar asistencia: " + e.getMessage());
        }
        return result;
    }


    public List<AsistenciaDTO> obtenerLista() {
        List<AsistenciaDTO> asistencias = new ArrayList<>();
        try (
                SQLiteDatabase db = getReadableDatabase();
                Cursor cursor = db.rawQuery("SELECT * FROM " + TABLE_ASISTENCIA, null);
        ) {
            if (cursor.moveToFirst()) {
                do {
                    AsistenciaDTO asistenciaDTO = new AsistenciaDTO();
                    asistenciaDTO.setAsi_id(cursor.getLong(0));
                    asistenciaDTO.setAsi_numAsistencia(cursor.getInt(1));
                    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd", Locale.getDefault());
                    asistenciaDTO.setAsi_fecha(sdf.parse(cursor.getString(2)));
                    asistenciaDTO.setPar_id(cursor.getLong(3));
                    asistencias.add(asistenciaDTO);
                } while (cursor.moveToNext());
            }
        } catch (Exception e) {
            Log.e("DbAsistencia", "Error al obtener asistencias", e);
        }
        return asistencias;
    }


    public AsistenciaDTO obtenerAsistencia(Long id) {
        AsistenciaDTO asistenciaDTO = null;
        try (
                SQLiteDatabase db = getReadableDatabase();
                Cursor cursor = db.query(TABLE_ASISTENCIA, null, "_rowid_=?", new String[]{String.valueOf(id)}, null, null, null);
        ) {
            if (cursor != null && cursor.moveToFirst()) {
                asistenciaDTO = new AsistenciaDTO();
                asistenciaDTO.setAsi_id(cursor.getLong(0));
                asistenciaDTO.setAsi_numAsistencia(cursor.getInt(1));

                // Convert fecha to yyyy-MM-dd format
                SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd", Locale.getDefault());
                String fechaFormatted = sdf.format(cursor.getString(2));
                asistenciaDTO.setAsi_fecha(sdf.parse(fechaFormatted));

                asistenciaDTO.setPar_id(cursor.getLong(3));
            }
        } catch (Exception e) {
            Log.e("DbAsistencia", "Error al obtener asistencias", e);
        }
        return asistenciaDTO;
    }


    public int eliminarAsistencia(Long id) {
        int result = 0;
        try (
                SQLiteDatabase db = getWritableDatabase();
        ) {
            result = db.delete(TABLE_ASISTENCIA, "_rowid_=?", new String[]{String.valueOf(id)});
        } catch (Exception e) {
            Log.e("DbAsistencia", "Error al eliminar asistencia", e);
        }
        return result;
    }


    public int actualizar(Long id, int numAsistencia, String asi_fecha, Long par_id) {
        int result = 0;
        try (
                SQLiteDatabase db = getWritableDatabase();
        ) {
            ContentValues values = new ContentValues();
            values.put("asi_numAsistencia", numAsistencia);

            // Convert asi_fecha to yyyy-MM-dd format
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd", Locale.getDefault());
            String asi_fechaFormatted = sdf.format(asi_fecha);
            values.put("asi_fecha", asi_fechaFormatted);

            values.put("par_id", par_id);

            result = db.update(TABLE_ASISTENCIA, values, "_rowid_=?", new String[]{String.valueOf(id)});
        } catch (Exception e) {
            Log.e("DbAsistencias", "Error al actualizar asistencia", e);
        }
        return result;
    }



}
