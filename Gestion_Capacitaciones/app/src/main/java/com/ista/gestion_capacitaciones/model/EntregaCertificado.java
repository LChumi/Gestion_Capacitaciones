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

public class EntregaCertificado {

    private Long eceId;
    private String eceCodigocertificado;
    @JsonDeserialize(using = CustomDateDeserializer.class)
    private Date eceFecharetiro;
    private Boolean eceFirma;
    private Boolean eceEstado;

    private Participante eceParticipante;

    public Long getEceId() {
        return eceId;
    }

    public void setEceId(Long eceId) {
        this.eceId = eceId;
    }

    public String getEceCodigocertificado() {
        return eceCodigocertificado;
    }

    public void setEceCodigocertificado(String eceCodigocertificado) {
        this.eceCodigocertificado = eceCodigocertificado;
    }

    public Date getEceFecharetiro() {
        return eceFecharetiro;
    }

    public void setEceFecharetiro(Date eceFecharetiro) {
        this.eceFecharetiro = eceFecharetiro;
    }

    public Boolean getEceFirma() {
        return eceFirma;
    }

    public void setEceFirma(Boolean eceFirma) {
        this.eceFirma = eceFirma;
    }

    public Boolean getEceEstado() {
        return eceEstado;
    }

    public void setEceEstado(Boolean eceEstado) {
        this.eceEstado = eceEstado;
    }

    public Participante getEceParticipante() {
        return eceParticipante;
    }

    public void setEceParticipante(Participante eceParticipante) {
        this.eceParticipante = eceParticipante;
    }
}
