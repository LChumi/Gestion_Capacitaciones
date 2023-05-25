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

public class HorarioCurso {

    private Long hcuId;
    private String hcuNombre;
    private Boolean hcuEstado;

    private Horario horario;
    private Curso hcurso;
    private List<FichaInscripcion> fichaInscripcions;
    private List<Participante> participantes;

    public Long getHcuId() {
        return hcuId;
    }

    public void setHcuId(Long hcuId) {
        this.hcuId = hcuId;
    }

    public String getHcuNombre() {
        return hcuNombre;
    }

    public void setHcuNombre(String hcuNombre) {
        this.hcuNombre = hcuNombre;
    }

    public Boolean getHcuEstado() {
        return hcuEstado;
    }

    public void setHcuEstado(Boolean hcuEstado) {
        this.hcuEstado = hcuEstado;
    }

    public Horario getHorario() {
        return horario;
    }

    public void setHorario(Horario horario) {
        this.horario = horario;
    }

    public Curso getHcurso() {
        return hcurso;
    }

    public void setHcurso(Curso hcurso) {
        this.hcurso = hcurso;
    }

    public List<FichaInscripcion> getFichaInscripcions() {
        return fichaInscripcions;
    }

    public void setFichaInscripcions(List<FichaInscripcion> fichaInscripcions) {
        this.fichaInscripcions = fichaInscripcions;
    }

    public List<Participante> getParticipantes() {
        return participantes;
    }

    public void setParticipantes(List<Participante> participantes) {
        this.participantes = participantes;
    }
}
