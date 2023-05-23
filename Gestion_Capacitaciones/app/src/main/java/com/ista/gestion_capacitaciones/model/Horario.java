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

public class Horario {

    private Long horId;
    private String horInicio;
    private String horFin;
    private Boolean horEstado;
    private List<HorarioCurso> horarioCursos;

    public Long getHorId() {
        return horId;
    }

    public void setHorId(Long horId) {
        this.horId = horId;
    }

    public String getHorInicio() {
        return horInicio;
    }

    public void setHorInicio(String horInicio) {
        this.horInicio = horInicio;
    }

    public String getHorFin() {
        return horFin;
    }

    public void setHorFin(String horFin) {
        this.horFin = horFin;
    }

    public Boolean getHorEstado() {
        return horEstado;
    }

    public void setHorEstado(Boolean horEstado) {
        this.horEstado = horEstado;
    }

    public List<HorarioCurso> getHorarioCursos() {
        return horarioCursos;
    }

    public void setHorarioCursos(List<HorarioCurso> horarioCursos) {
        this.horarioCursos = horarioCursos;
    }
}
