/*
 *
 *   Created Luis Chumi on 23/5/23 9:38
 *   Copyright Ⓒ 2023. All rights reserved Ⓒ 2023 http://freefuninfo.com/
 *   Last modified: 18/5/23 16:49
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

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import androidx.annotation.Nullable;

public class SqlConexion extends SQLiteOpenHelper {

    private static final int DATABASE_VERSION=2;
    private static  final String DATABASE_NOMBRE="bd_gestion";
    public static final String TABLE_USUARIOS= "t_usuarios";
    public static final String TABLE_CURSO= "t_cursos";
    public static final String TABLE_ASISTENCIA= "t_asistencia";
    public static final String TABLE_PARTICIPANTE= "t_participante";
    public static final String TABLE_PERSONA="t_persona";
    public static final String TABLE_ROL="t_rol";

    public SqlConexion(@Nullable Context context){
        super(context,DATABASE_NOMBRE,null,DATABASE_VERSION);
    }



    @Override
    public void onCreate(SQLiteDatabase db) {
        crearTablas(db);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        onCreate(db);
    }

        private void crearTablas(SQLiteDatabase db){
            db.execSQL("CREATE TABLE IF NOT EXISTS " + TABLE_USUARIOS +"("+
                    "usu_id INTEGER PRIMARY KEY AUTOINCREMENT,"+
                    "usu_usuario TEXT NOT NULL,"+
                    "usu_password TEXT NOT NULL,"+
                    "per_id INTEGER NOT NULL,"+
                    "rol_id INTEGER NOT NULL,"+
                    "FOREIGN KEY(per_id) REFERENCES "+TABLE_PERSONA+"(per_id) ON DELETE CASCADE,"+
                    "FOREIGN KEY(rol_id) REFERENCES "+TABLE_ROL+"(id_rol) ON DELETE CASCADE)");

            db.execSQL("CREATE TABLE IF NOT EXISTS "+ TABLE_CURSO +"("+
                    "cur_id INTEGER PRIMARY KEY AUTOINCREMENT,"+
                    "cur_codigo INTEGER NOT NULL," +
                    "cur_nombre TEXT NOT NULL,"+
                    "cur_fechaInicio DATE NOT NULL,"+
                    "cur_fechaFin DATE NOT NULL,"+
                    "cur_numHora INTEGER NOT NULL,"+
                    "cur_proceso INTEGER NOT NULL,"+
                    "cur_estado BOOLEAN NOT NULL"+
                    ")");

            db.execSQL("CREATE TABLE IF NOT EXISTS "+ TABLE_ASISTENCIA +"("+
                    "asi_id INTEGER PRIMARY KEY AUTOINCREMENT,"+
                    "asi_numAsistencia INTEGER NOT NULL,"+
                    "asi_fecha DATE NOT NULL,"+
                    "par_id INTEGER NOT NULL,"+
                    "FOREIGN KEY(par_id) REFERENCES "+TABLE_PARTICIPANTE+"(par_id) ON DELETE CASCADE)");


            db.execSQL("CREATE TABLE IF NOT EXISTS "+ TABLE_PARTICIPANTE+ "("+
                    "par_id INTEGER PRIMARY KEY AUTOINCREMENT,"+
                    "par_notaParcial REAL,"+
                    "par_notaFinal REAL,"+
                    "par_notaPromedio REAL,"+
                    "par_observacion TEXT,"+
                    "par_estado BOOLEAN,"+
                    "per_id INTEGER NOT NULL,"+
                    "cur_id INTEGER NOT NULL,"+
                    "FOREIGN KEY(per_id) REFERENCES "+TABLE_PERSONA+"(per_id) ON DELETE CASCADE,"+
                    "FOREIGN KEY(cur_id) REFERENCES "+TABLE_CURSO+"(cur_id) ON DELETE CASCADE)");


            db.execSQL("CREATE TABLE IF NOT EXISTS "+TABLE_PERSONA+ "("+
                    "per_id INTEGER PRIMARY KEY AUTOINCREMENT,"+
                    "per_cedula TEXT NOT NULL," +
                    "per_nombres TEXT NOT NULL,"+
                    "per_apellidos TEXT NOT NULL,"+
                    "per_fechaNacimiento DATE NOT NULL,"+
                    "per_correo TEXT NOT NULL,"+
                    "per_estado BOOLEAN NOT NULL"+
                    ")");
            db.execSQL("CREATE TABLE IF NOT EXISTS " + TABLE_ROL + "(" +
                    "id_rol INTEGER PRIMARY KEY AUTOINCREMENT, " +
                    "rol_nombre TEXT NOT NULL, " +
                    "descripcion TEXT, " +
                    "enabled BOOLEAN NOT NULL" +
                    ")");

        }


    private String[] TABLAS = {TABLE_USUARIOS,TABLE_PERSONA,TABLE_PARTICIPANTE,TABLE_ASISTENCIA,TABLE_CURSO,TABLE_ROL};
    private void verificarTablas() {
        try (
                SQLiteDatabase db = getWritableDatabase();
        ) {
            for (String tabla : TABLAS) {
                Cursor cursor = db.rawQuery("SELECT name " +
                        "FROM sqlite_master " +
                        "WHERE type='table' " +
                        "AND name='" + tabla + "'", null);
                if (cursor.getCount() == 0) {
                    crearTablas(db);
                }
                cursor.close();
            }
        } catch (Exception e) {
            Log.e("DbAsistencia", "Error al verificar tablas: " + e.getMessage());
        }
    }

}

