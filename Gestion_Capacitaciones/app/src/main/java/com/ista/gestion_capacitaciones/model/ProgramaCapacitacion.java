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
import java.util.List;

public class ProgramaCapacitacion {

    private Long pcaId;
    private String pcaNombre;
    @JsonDeserialize(using = CustomDateDeserializer.class)
    private Date pcaFechainicio;
    @JsonDeserialize(using = CustomDateDeserializer.class)
    private Date pcaFechafin;
    private String pcaProceso;
    private Boolean pcaEstado;
    private List<Curso> cursos;

    public Long getPcaId() {
        return pcaId;
    }

    public void setPcaId(Long pcaId) {
        this.pcaId = pcaId;
    }

    public String getPcaNombre() {
        return pcaNombre;
    }

    public void setPcaNombre(String pcaNombre) {
        this.pcaNombre = pcaNombre;
    }

    public Date getPcaFechainicio() {
        return pcaFechainicio;
    }

    public void setPcaFechainicio(Date pcaFechainicio) {
        this.pcaFechainicio = pcaFechainicio;
    }

    public Date getPcaFechafin() {
        return pcaFechafin;
    }

    public void setPcaFechafin(Date pcaFechafin) {
        this.pcaFechafin = pcaFechafin;
    }

    public String getPcaProceso() {
        return pcaProceso;
    }

    public void setPcaProceso(String pcaProceso) {
        this.pcaProceso = pcaProceso;
    }

    public Boolean getPcaEstado() {
        return pcaEstado;
    }

    public void setPcaEstado(Boolean pcaEstado) {
        this.pcaEstado = pcaEstado;
    }

    public List<Curso> getCursos() {
        return cursos;
    }

    public void setCursos(List<Curso> cursos) {
        this.cursos = cursos;
    }
}
