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

import com.ista.gestion_capacitaciones.model.dto.ParticipanteDTO;

import java.util.ArrayList;
import java.util.List;

public class DbParticipantes extends SqlConexion{

    Context context;

    public DbParticipantes(@Nullable Context context) {
        super(context);
        this.context=context;
    }

    public long insertarParticipante(double notaParcial, double notaFinal, double notaPromedio, String observacion, boolean estado, int idPersona) {
        try (
                SQLiteDatabase db = getWritableDatabase();
        ) {
            ContentValues valores = new ContentValues();
            valores.put("par_notaParcial", notaParcial);
            valores.put("par_notaFinal", notaFinal);
            valores.put("par_notaPromedio", notaPromedio);
            valores.put("par_observacion", observacion);
            valores.put("par_estado", estado);
            valores.put("per_id", idPersona);

            long result = db.insert(TABLE_PARTICIPANTE, null, valores);
            return result;
        } catch (Exception e) {
            Log.e("DbParticipante", "Error al insertar participante: " + e.getMessage());
        }
        return -1;
    }

    public List<ParticipanteDTO> obtenerLista(){
        List<ParticipanteDTO> participantes=new ArrayList<>();
        try(
                SQLiteDatabase db=getReadableDatabase();
                Cursor cursor=db.rawQuery("SELECT * FROM "+ TABLE_PARTICIPANTE,null);
                ){
            if (cursor.moveToFirst()){
                do {
                    ParticipanteDTO participanteDTO=new ParticipanteDTO();
                    participanteDTO.setPar_id(cursor.getLong(0));
                    participanteDTO.setPar_notaParcial(cursor.getDouble(1));
                    participanteDTO.setPar_notaFinal(cursor.getDouble(2));
                    participanteDTO.setNotaPromedio(cursor.getDouble(3));
                    participanteDTO.setPar_observacion(cursor.getString(4));
                    participanteDTO.setPar_estado(cursor.getInt(5)==1);
                    participanteDTO.setPer_id(cursor.getLong(6));
                    participantes.add(participanteDTO);
                }while (cursor.moveToNext());
            }
        }catch (Exception e){
            Log.e("DbParticipantes","Error al obtener participantes"+e.getMessage());
        }
        return participantes;
    }

    public ParticipanteDTO obtenerParticipante(Long id){
        ParticipanteDTO participanteDTO=null;
        try(
                SQLiteDatabase db=getReadableDatabase();
                Cursor cursor=db.query(TABLE_PARTICIPANTE,null,"_rowid_=?",new String[]{String.valueOf(id)},null,null,null);
                ){
            if (cursor!=null && cursor.moveToFirst()){
                participanteDTO=new ParticipanteDTO();
                participanteDTO.setPar_id(cursor.getLong(0));
                participanteDTO.setPar_notaParcial(cursor.getDouble(1));
                participanteDTO.setPar_notaFinal(cursor.getDouble(2));
                participanteDTO.setNotaPromedio(cursor.getDouble(3));
                participanteDTO.setPar_observacion(cursor.getString(4));
                participanteDTO.setPar_estado(cursor.getInt(5)==1);
                participanteDTO.setPer_id(cursor.getLong(6));
            }
        }catch (Exception e){
            Log.e("DbParticipante","Error al obtener usuario",e);
        }
        return participanteDTO;
    }

    public int eliminarParticipante(Long id){
        int result=0;
        try(
                SQLiteDatabase db=getWritableDatabase();
                ){
            result=db.delete(TABLE_PARTICIPANTE,"_rowid_=?",new String[]{String.valueOf(id)});
        }catch (Exception e){
            Log.e("DbParticipante","Error al eliminar "+e.getMessage());
        }
        return result;
    }

    public int actualizar(Long id,double notaParcial,double notaFinal, double notaPromedio,String observacion,boolean estado,Long idPers){
        int resul=0;
        try(
                SQLiteDatabase db=getWritableDatabase();
                ){
            ContentValues values =new ContentValues();
            values.put("par_notaParcial",notaParcial);
            values.put("par_notaFinal",notaFinal);
            values.put("par_notaPromedio",notaPromedio);
            values.put("par_observacion",observacion);
            values.put("par_estado",estado);
            values.put("per_id",estado);

            resul=db.update(TABLE_PARTICIPANTE,values,"_row_id=?",new String[]{String.valueOf(id)});
        }catch (Exception e){
            Log.e("DbParticipante", "Error al actualizar Participante"+e.getMessage());
        }
        return resul;
    }


}
