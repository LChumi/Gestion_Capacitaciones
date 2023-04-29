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
                "id Long PRIMARY KEY AUTOINCREMENT,"+
                "usu_usuario TEXT NOT NULL,"+
                "usu_password TEXT NOT NULL,"+
                "usu_estado BOOLEAN)");
    }

    private String[] TABLAS = {TABLE_USUARIOS};
    public void verificarTablas(){
        SQLiteDatabase db= getWritableDatabase();

        for (String tabla:TABLAS){
            Cursor cursor=db.rawQuery("SELECT name FROM sqliite_master WHERE type='table' AND name='" + tabla + "'",null);
            if (cursor.getCount()==0){
                crearTablas(db);
            }
            cursor.close();
            db.close();
        }
    }
}

