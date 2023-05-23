/*
 *
 *   Created Luis Chumi on 23/5/23 9:38
 *   Copyright Ⓒ 2023. All rights reserved Ⓒ 2023 http://freefuninfo.com/
 *   Last modified: 16/5/23 22:00
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
import androidx.core.database.sqlite.SQLiteDatabaseKt;

import com.ista.gestion_capacitaciones.model.Rol;
import com.ista.gestion_capacitaciones.model.dto.RolDTO;

import java.util.ArrayList;
import java.util.List;

public class DbRol extends SqlConexion{

    Context context;

    public DbRol(@Nullable Context context){
        super(context);
        this.context=context;
    }

    public long insertarRol(Long id,String nombre,String descripcion,boolean enable){
        SQLiteDatabase db=this.getWritableDatabase();
        long result=-1;
        try{
            ContentValues valores=new ContentValues();
            valores.put("id_rol",id);
            valores.put("rol_nombre",nombre);
            valores.put("descripcion",descripcion);
            valores.put("enabled",enable);

            result=db.insert(TABLE_ROL,null,valores);
        }catch (Exception e){
            Log.e("Db Rol","Error al insertar rol"+e.getMessage());
        }finally {
            db.close();
        }
        return result;
    }

   public List<RolDTO> obtenerLista(){
       List<RolDTO> roles=new ArrayList<>();
       try(
               SQLiteDatabase db=getReadableDatabase();
               Cursor cursor=db.rawQuery("SELECT * FROM "+ TABLE_ROL,null);
               ){
           if(cursor.moveToFirst()){
               do{
                   RolDTO rolDTO=new RolDTO();
                   rolDTO.setId_rol(cursor.getLong(0));
                   rolDTO.setRol_nombre(cursor.getString(1));
                   rolDTO.setDescripcion(cursor.getString(2));
                   rolDTO.setEnabled(cursor.getInt(3)==1);
                   roles.add(rolDTO);
               }while(cursor.moveToNext());
           }
       }catch (Exception e){
           Log.e("DbRol","Error al obtener roles",e);
       }
       return roles;
   }

   public RolDTO obtenerRol(Long id){
        RolDTO rolDTO=null;
        try(
                SQLiteDatabase db=getReadableDatabase();
                Cursor cursor=db.query(TABLE_ROL,null,"_rowid_=?",new String[]{String.valueOf(id)},null,null,null);
                ){
            if (cursor !=null && cursor.moveToFirst()){
                rolDTO=new RolDTO();
                rolDTO.setId_rol(cursor.getLong(0));
                rolDTO.setRol_nombre(cursor.getString(1));
                rolDTO.setDescripcion(cursor.getString(2));
                rolDTO.setEnabled(cursor.getInt(3)==1);

                return rolDTO;
            }
        }catch(Exception e){
            Log.e("DbRol","Error al obtener rol",e);
        }
        return rolDTO;
   }

   public int eliminarRol(Long id){
        int result=0;
        try(
                SQLiteDatabase db=getWritableDatabase();
                ){
            result=db.delete(TABLE_ROL,"_rowid_=?",new String[]{String.valueOf(id)});
        }
        return result;
   }

   public int actualizar(Long id,String nombre,String descripcion,boolean enable){
        int result=0;
        try(
                SQLiteDatabase db=getWritableDatabase();
                ){
            ContentValues valores=new ContentValues();
            valores.put("id_rol",id);
            valores.put("rol_nombre",nombre);
            valores.put("descripcion",descripcion);
            valores.put("enabled",enable);

            result=db.update(TABLE_ROL,valores,"_rowid_=?",new String[]{String.valueOf(id)});
        }catch(Exception e){
            Log.e("DbRol","Error al actualizar rol",e);
        }
        return result;
   }





}
