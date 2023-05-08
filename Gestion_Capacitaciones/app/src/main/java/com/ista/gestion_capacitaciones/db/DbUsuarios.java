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

    public long insertaUsuario(String username, String password, Long personaId,Long rolId) {
        SQLiteDatabase db = this.getWritableDatabase();
        long result = -1;
        try{
            ContentValues values = new ContentValues();
            values.put("usu_usuario", username);
            values.put("usu_password", password);
            values.put("per_id", personaId);
            values.put("rol_id",rolId);

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
                usuarioDTO.setRol_id(cursor.getLong(4));
                usuarios.add(usuarioDTO);
                }while(cursor.moveToNext());
            }
        }catch (Exception e){
            Log.e("DbUsuario","Error al obtener Usuarios",e);
        }
        return usuarios;
    }

    public UsuarioDTO obtenerUsuario(Long id){
        UsuarioDTO usuarioDTO=null;
        try(
                SQLiteDatabase db=getReadableDatabase();
                Cursor cursor=db.query(TABLE_USUARIOS,null,"_rowid_=?",new String[]{String.valueOf(id)},null,null,null);
                ){
            if (cursor!=null && cursor.moveToFirst()){
                usuarioDTO=new UsuarioDTO();
                usuarioDTO.setUsu_id(cursor.getLong(0));
                usuarioDTO.setUsu_usuario(cursor.getString(1));
                usuarioDTO.setUsu_password(cursor.getString(2));

                usuarioDTO.setPer_id(cursor.getLong(3));
                usuarioDTO.setRol_id(cursor.getLong(4));
            }
        }catch (Exception e){
            Log.e("DbUsuario","Error al obtener usuario",e);
        }
        return usuarioDTO;
    }

    public int eliminarUsuario(Long id){
        int result=0;
        try(
                SQLiteDatabase db=getWritableDatabase();
                ){
            result=db.delete(TABLE_USUARIOS,"_row_id=?",new String[]{String.valueOf(id)});
        }catch(Exception e){
            Log.e("DbUsusario","Error al eliminar persona",e);
        }
        return result;
    }

    public int actualizar(Long id,String usuario,String password,Long per_id,Long idRol){
        int result=0;
        try(
                SQLiteDatabase db=getWritableDatabase();
                ){
            ContentValues values=new ContentValues();
            values.put("usu_id",id);
            values.put("usu_usuario",usuario);
            values.put("usu_password",password);
            values.put("per_id",per_id);
            values.put("rol_id",idRol);

            result=db.update(TABLE_USUARIOS,values,"_rowid_=?",new String[]{String.valueOf(id)});
        }catch (Exception e){
            Log.e("DbUsuario","Error al actualizar Usuario",e);
        }
        return result;
    }

    public UsuarioDTO login(String username, String password) {
        UsuarioDTO usuarioDTO = null;
        try (SQLiteDatabase db = getReadableDatabase();
             Cursor cursor = db.query(TABLE_USUARIOS, null, "usu_usuario=? AND usu_password=?", new String[]{username, password}, null, null, null)) {
            if (cursor != null && cursor.moveToFirst()) {
                usuarioDTO = new UsuarioDTO();
                usuarioDTO.setUsu_id(cursor.getLong(0));
                usuarioDTO.setUsu_usuario(cursor.getString(1));
                usuarioDTO.setUsu_password(cursor.getString(2));
                usuarioDTO.setPer_id(cursor.getLong(3));
            }
        } catch (Exception e) {
            Log.e("DbUsuarios", "Error al obtener usuario", e);
        }
        return usuarioDTO;
    }

}
