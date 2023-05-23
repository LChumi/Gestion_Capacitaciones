/*
 *
 *   Created Luis Chumi on 23/5/23 9:38
 *   Copyright Ⓒ 2023. All rights reserved Ⓒ 2023 http://freefuninfo.com/
 *   Last modified: 21/5/23 19:28
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
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import com.ista.gestion_capacitaciones.utils.CustomDateDeserializer;

import java.util.Date;

public class Asistencia {

    @SerializedName("asiId")
    private Long asiId;

    @SerializedName("asiNumfaltas")
    private int asiNumfaltas;

    @SerializedName("asiFecha")
    @JsonDeserialize(using = CustomDateDeserializer.class)
    private Date asiFecha;

    @SerializedName("asiEstado")
    private Boolean asiEstado;

    @SerializedName("asiParticipante")
    private transient Participante asiParticipante;

    public Long getAsiId() {
        return asiId;
    }

    public void setAsiId(Long asiId) {
        this.asiId = asiId;
    }

    public int getAsiNumfaltas() {
        return asiNumfaltas;
    }

    public void setAsiNumfaltas(int asiNumfaltas) {
        this.asiNumfaltas = asiNumfaltas;
    }

    public Date getAsiFecha() {
        return asiFecha;
    }

    public void setAsiFecha(Date asiFecha) {
        this.asiFecha = asiFecha;
    }

    public Boolean getAsiEstado() {
        return asiEstado;
    }

    public void setAsiEstado(Boolean asiEstado) {
        this.asiEstado = asiEstado;
    }

    public Participante getAsiParticipante() {
        return asiParticipante;
    }

    public void setAsiParticipante(Participante asiParticipante) {
        this.asiParticipante = asiParticipante;
    }

    @Override
    public String toString() {
        return "Asistencia{" +
                "asiId=" + asiId +
                ", asiNumfaltas=" + asiNumfaltas +
                ", asiFecha=" + asiFecha +
                ", asiEstado=" + asiEstado +
                '}';
    }
}
