package com.ista.gestion_capacitaciones.db;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class SqlConexion extends SQLiteOpenHelper {

    private static final int DATABASE_VERSION=1;
    private static  final String DATABASE_NOMBRE="gcomplexivoC2.db";
    public static final String TABLE_USUARIOS= "t_usuarios";
    public static final String TABLE_CURSO= "t_cursos";
    public static final String TABLE_ASISTENCIA= "t_asistencia";
    public static final String TABLE_PARTICIPANTE= "t_participante";

    public SqlConexion(@Nullable Context context){
        super(context,DATABASE_NOMBRE,null,DATABASE_VERSION);
    }



    @Override
    public void onCreate(SQLiteDatabase db) {
        crearTablas(db);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS "+TABLE_USUARIOS);
        onCreate(db);
    }

    private void crearTablas(SQLiteDatabase db){
        db.execSQL("CREATE TABLE IF NOT EXISTS " + TABLE_USUARIOS +"("+
                "usu_id Long PRIMARY KEY AUTOINCREMENT,"+
                "usu_usuario TEXT NOT NULL,"+
                "usu_password TEXT NOT NULL)");
        db.execSQL("CREATE TABLE IF NOT EXISTS "+ TABLE_CURSO +"("+
                "cur_id Long PRIMARY KEY AUTOINCREMENT,"+
                "cur_codigo INTEGER NOT NULL," +
                "cur_nombre TEXT NOT NULL,"+
                "cur_fechaInicio DATE NOT NULL,"+
                "cur_fechaFin DATE NOT NULL,"+
                "cur_numHora INTEGER NOT NULL,"+
                "cur_proceso INTEGER NOT NULL,"+
                "cur_estado BOOLEAN NOT NULL,"+
                "CONSTRAINT unique_curso_codigo UNIQUE (cur_codigo))");
        db.execSQL("CREATE TABLE IF NOT EXISTS "+ TABLE_ASISTENCIA +"("+
                "asi_id Long PRIMARY KEY AUTOINCREMENT,"+
                "asi_numAsistencia INTEGER NOT NULL,"+
                "asi_fecha DATE NOT NULL)");
        
    }

    private String[] TABLAS = {TABLE_USUARIOS};
    public void verificarTablas(){
        SQLiteDatabase db= getWritableDatabase();

        for (String tabla:TABLAS){
            Cursor cursor=db.rawQuery("SELECT name " +
                    "FROM sqliite_master " +
                    "WHERE type='table' " +
                    "AND name='" + tabla + "'",null);
            if (cursor.getCount()==0){
                crearTablas(db);
            }
            cursor.close();
            db.close();
        }
    }
}

