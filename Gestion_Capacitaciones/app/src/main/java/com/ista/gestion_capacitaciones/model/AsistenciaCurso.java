/*
 *
 *   Created Luis Chumi on 23/5/23 9:38
 *   Copyright Ⓒ 2023. All rights reserved Ⓒ 2023 http://freefuninfo.com/
 *   Last modified: 21/5/23 18:48
 *
 *   Licensed under the Apache License, Version 2.0 (the "License"); you may not use this file
 *   except in compliance with the License. You may obtain a copy of the License at
 *   http://www.apache.org/licenses/LICENS... Unless required by applicable law or agreed to in writing, software
 *    distributed under the License is distributed on an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND,
 *    either express or implied. See the License for the specific language governing permissions and
 *    limitations under the License.
 * /
 */

package com.ista.gestion_capacitaciones.model;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.ista.gestion_capacitaciones.utils.CustomDateDeserializer;

import java.util.Date;

public class AsistenciaCurso {

    private Long acuId;
    private String acuObservacion;
    @JsonDeserialize(using = CustomDateDeserializer.class)
    private Date acuFechaelaboracion;
    private Boolean acuEstado;

    private Curso acuCurso;

    public Long getAcuId() {
        return acuId;
    }

    public void setAcuId(Long acuId) {
        this.acuId = acuId;
    }

    public String getAcuObservacion() {
        return acuObservacion;
    }

    public void setAcuObservacion(String acuObservacion) {
        this.acuObservacion = acuObservacion;
    }

    public Date getAcuFechaelaboracion() {
        return acuFechaelaboracion;
    }

    public void setAcuFechaelaboracion(Date acuFechaelaboracion) {
        this.acuFechaelaboracion = acuFechaelaboracion;
    }

    public Boolean getAcuEstado() {
        return acuEstado;
    }

    public void setAcuEstado(Boolean acuEstado) {
        this.acuEstado = acuEstado;
    }

    public Curso getAcuCurso() {
        return acuCurso;
    }

    public void setAcuCurso(Curso acuCurso) {
        this.acuCurso = acuCurso;
    }
}
