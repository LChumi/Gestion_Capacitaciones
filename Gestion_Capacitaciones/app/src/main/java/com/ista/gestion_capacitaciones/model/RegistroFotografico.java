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

public class RegistroFotografico {

    private Long rfoId;
    private Integer rfoNumero;
    private String rfoDescripcion;
    @JsonDeserialize(using = CustomDateDeserializer.class)
    private Date rfoFecha;
    private Boolean rfoEstado;
    private String rfoFoto;

    private Curso rfoCurso;

    public Long getRfoId() {
        return rfoId;
    }

    public void setRfoId(Long rfoId) {
        this.rfoId = rfoId;
    }

    public Integer getRfoNumero() {
        return rfoNumero;
    }

    public void setRfoNumero(Integer rfoNumero) {
        this.rfoNumero = rfoNumero;
    }

    public String getRfoDescripcion() {
        return rfoDescripcion;
    }

    public void setRfoDescripcion(String rfoDescripcion) {
        this.rfoDescripcion = rfoDescripcion;
    }

    public Date getRfoFecha() {
        return rfoFecha;
    }

    public void setRfoFecha(Date rfoFecha) {
        this.rfoFecha = rfoFecha;
    }

    public Boolean getRfoEstado() {
        return rfoEstado;
    }

    public void setRfoEstado(Boolean rfoEstado) {
        this.rfoEstado = rfoEstado;
    }

    public String getRfoFoto() {
        return rfoFoto;
    }

    public void setRfoFoto(String rfoFoto) {
        this.rfoFoto = rfoFoto;
    }

    public Curso getRfoCurso() {
        return rfoCurso;
    }

    public void setRfoCurso(Curso rfoCurso) {
        this.rfoCurso = rfoCurso;
    }
}
