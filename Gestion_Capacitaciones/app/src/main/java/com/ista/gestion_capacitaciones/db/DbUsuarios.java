package com.ista.gestion_capacitaciones.db;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import androidx.annotation.Nullable;

public class DbUsuarios extends SqlConexion{

    Context context;

    public DbUsuarios(@Nullable Context context) {
        super(context);
        this.context=context;
    }

    public long insertaUsuario(String username, String password, int personaId) {
        SQLiteDatabase db = this.getWritableDatabase();
        long result = -1;
        try{
            ContentValues values = new ContentValues();
            values.put("usu_usuario", username);
            values.put("usu_password", password);
            values.put("per_id", personaId);

            result = db.insert(TABLE_USUARIOS, null, values);

        }catch (Exception e){
            Log.e("DbUsuarios", "Error al insertar usuario: " + e.getMessage());
        }finally {
            db.close();
        }
        return result;
    }

}
