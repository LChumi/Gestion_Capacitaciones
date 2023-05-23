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

package com.ista.gestion_capacitaciones.model.dto;

import com.ista.gestion_capacitaciones.model.Asistencia;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class AsistenciaDTO {

    private Long asi_id;
    private int asi_numAsistencia;
    private Date asi_fecha;
    private Long par_id;

    public AsistenciaDTO() {
    }

    public AsistenciaDTO(Asistencia asistencia) {
        this.asi_id = asistencia.getAsiId();
        this.asi_numAsistencia = asistencia.getAsiNumfaltas();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        this.asi_fecha=asistencia.getAsiFecha();
        this.par_id = asistencia.getAsiParticipante().getParId();
    }

    public Long getAsi_id() {
        return asi_id;
    }

    public void setAsi_id(Long asi_id) {
        this.asi_id = asi_id;
    }

    public int getAsi_numAsistencia() {
        return asi_numAsistencia;
    }

    public void setAsi_numAsistencia(int asi_numAsistencia) {
        this.asi_numAsistencia = asi_numAsistencia;
    }

    public Date getAsi_fecha() {
        return asi_fecha;
    }

    public void setAsi_fecha(Date asi_fecha) {
        this.asi_fecha = asi_fecha;
    }

    public Long getPar_id() {
        return par_id;
    }

    public void setPar_id(Long par_id) {
        this.par_id = par_id;
    }
}

