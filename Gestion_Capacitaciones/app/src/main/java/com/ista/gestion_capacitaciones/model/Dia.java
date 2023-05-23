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

package com.ista.gestion_capacitaciones.model;

import java.util.List;

public class Dia {

    private Long diaId;
    private String diaNombre;
    private Boolean diaEstado;

    private List<NecesidadCurso> necesidadCursos;

    public Long getDiaId() {
        return diaId;
    }

    public void setDiaId(Long diaId) {
        this.diaId = diaId;
    }

    public String getDiaNombre() {
        return diaNombre;
    }

    public void setDiaNombre(String diaNombre) {
        this.diaNombre = diaNombre;
    }

    public Boolean getDiaEstado() {
        return diaEstado;
    }

    public void setDiaEstado(Boolean diaEstado) {
        this.diaEstado = diaEstado;
    }

    public List<NecesidadCurso> getNecesidadCursos() {
        return necesidadCursos;
    }

    public void setNecesidadCursos(List<NecesidadCurso> necesidadCursos) {
        this.necesidadCursos = necesidadCursos;
    }
}
