package com.ista.gestion_capacitaciones.db;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import androidx.annotation.Nullable;

import com.ista.gestion_capacitaciones.model.dto.UsuarioDTO;

import java.util.ArrayList;
import java.util.List;

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

    public List<UsuarioDTO> obtenerLista(){
        List<UsuarioDTO> usuarios=new ArrayList<>();
        try(
                SQLiteDatabase db=getReadableDatabase();
                Cursor cursor=db.rawQuery("SELECT * FROM "+TABLE_USUARIOS,null);
                ){
            if (cursor.moveToFirst()){
                do{
                    UsuarioDTO usuarioDTO=new UsuarioDTO();
                usuarioDTO.setUsu_id(cursor.getLong(0));
                usuarioDTO.setUsu_usuario(cursor.getString(1));
                usuarioDTO.setUsu_password(cursor.getString(2));
                usuarioDTO.setPer_id(cursor.getLong(3));
                usuarios.add(usuarioDTO);
                }while(cursor.moveToNext());
            }
        }catch (Exception e){
            Log.e("DbUsuario","Error al obtener Usuarios",e);
        }
        return usuarios;
    }

}
