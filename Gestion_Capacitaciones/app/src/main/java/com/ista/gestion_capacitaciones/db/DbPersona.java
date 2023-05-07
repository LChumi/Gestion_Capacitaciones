package com.ista.gestion_capacitaciones.db;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import androidx.annotation.Nullable;

import com.ista.gestion_capacitaciones.model.dto.PersonaDTO;
import com.ista.gestion_capacitaciones.model.dto.UsuarioDTO;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

public class DbPersona extends SqlConexion{

    Context context;

    public DbPersona(@Nullable Context context) {
        super(context);
        this.context=context;
    }

    public long insertaPersona(Long id,String cedula, String nombres, String apellidos, Date fechaNacimiento, String correo, boolean estado) {
        SQLiteDatabase db = this.getWritableDatabase();
        long result=-1;
        try {
            ContentValues valores = new ContentValues();
            valores.put("per_id",id);
            valores.put("per_cedula", cedula);
            valores.put("per_nombres", nombres);
            valores.put("per_apellidos", apellidos);
            valores.put("per_fechaNacimiento", fechaNacimiento.getTime());
            valores.put("per_correo", correo);
            valores.put("per_estado", estado);

            result= db.insert(TABLE_PERSONA, null, valores);
        }catch (Exception e){
            Log.e("DbPersona", "Error al insertar persona: " + e.getMessage());
        }finally {
            db.close();
        }

        return result;
    }


    public List<PersonaDTO> obtenerLista(){
        List<PersonaDTO> personas=new ArrayList<>();
        try(
                SQLiteDatabase db=getReadableDatabase();
            Cursor cursor=db.rawQuery("SELECT * FROM "+ TABLE_PERSONA,null);
        ){
            if (cursor.moveToFirst()){
                do{
                    PersonaDTO personaDTO= new PersonaDTO();
                    personaDTO = new PersonaDTO();
                    personaDTO.setPer_id(cursor.getLong(0));
                    personaDTO.setPer_cedula(cursor.getString(1));
                    personaDTO.setPer_nombres(cursor.getString(2));
                    personaDTO.setPer_apellidos(cursor.getString(3));
                    personaDTO.setPer_fechaNacimiento(new Date(cursor.getLong(4)));
                    personaDTO.setPer_correo(cursor.getString(5));
                    personaDTO.setPer_estado(cursor.getInt(6) == 1);
                }while(cursor.moveToNext());
            }
        }catch (Exception e){
            Log.e("DbPersona","Error al obtener personas",e);
        }
        return personas;
    }

    public PersonaDTO obtenerPersona(Long id){
        PersonaDTO personaDTO=null;
        try(
                SQLiteDatabase db=getReadableDatabase();
                Cursor cursor=db.query(TABLE_PERSONA,null,"_rowid_=?",new String[]{String.valueOf(id)},null,null,null);
                ){
            SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy", Locale.getDefault());
            if (cursor != null && cursor.moveToFirst()) {
                personaDTO = new PersonaDTO();
                personaDTO.setPer_id(cursor.getLong(0));
                personaDTO.setPer_cedula(cursor.getString(1));
                personaDTO.setPer_nombres(cursor.getString(2));
                personaDTO.setPer_apellidos(cursor.getString(3));
                personaDTO.setPer_fechaNacimiento(new Date(cursor.getLong(4)));
                personaDTO.setPer_correo(cursor.getString(5));
                personaDTO.setPer_estado(cursor.getInt(6) == 1);

                return personaDTO;
            }

        }catch (Exception e){
            Log.e("DbPersona","Error al obtener persona",e);
        }
        return personaDTO;
    }

    public int eliminarPersona(Long id){
        int result=0;
        try(
                SQLiteDatabase db=getWritableDatabase();
                ){
            result= db.delete(TABLE_PERSONA,"_row_id=?",new String[]{String.valueOf(id)});
        }catch (Exception e){
            Log.e("DbPersona","Error al eliminar persona",e);
        }
        return result;
    }

    public int actualizar(Long id, String cedula, String nombres, String apellidos, Date fechaNacimiento, String correo, boolean estado){
        int result=0;
        try(
                SQLiteDatabase db=getWritableDatabase();
                ){
            ContentValues values=new ContentValues();
            values.put("per_id",id);
            values.put("per_cedula",cedula);
            values.put("per_nombres",nombres);
            values.put("per_apellidos",apellidos);
            values.put("per_fechaNacimiento",fechaNacimiento.getTime());
            values.put("per_correo",correo);
            values.put("per_estado",estado);

            result=db.update(TABLE_PERSONA,values,"_rowid_=?",new String[]{String.valueOf(id)});
        }catch (Exception e){
            Log.e("DbPersona","Error al actualizar persona",e);
        }
        return result;
    }






}
