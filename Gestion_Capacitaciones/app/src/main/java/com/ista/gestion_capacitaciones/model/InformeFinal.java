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

public class InformeFinal {

    private Long ifiId;
    private String ifiObservaciones;
    @JsonDeserialize(using = CustomDateDeserializer.class)
    private Date ifiFecha;
    private Boolean ifiEstado;

    private Curso ifiCurso;

    public Long getIfiId() {
        return ifiId;
    }

    public void setIfiId(Long ifiId) {
        this.ifiId = ifiId;
    }

    public String getIfiObservaciones() {
        return ifiObservaciones;
    }

    public void setIfiObservaciones(String ifiObservaciones) {
        this.ifiObservaciones = ifiObservaciones;
    }

    public Date getIfiFecha() {
        return ifiFecha;
    }

    public void setIfiFecha(Date ifiFecha) {
        this.ifiFecha = ifiFecha;
    }

    public Boolean getIfiEstado() {
        return ifiEstado;
    }

    public void setIfiEstado(Boolean ifiEstado) {
        this.ifiEstado = ifiEstado;
    }

    public Curso getIfiCurso() {
        return ifiCurso;
    }

    public void setIfiCurso(Curso ifiCurso) {
        this.ifiCurso = ifiCurso;
    }
}
