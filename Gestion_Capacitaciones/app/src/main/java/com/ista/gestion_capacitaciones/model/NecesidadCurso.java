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

public class NecesidadCurso {

    private Long ncuId;
    private String ncuIdentificador;
    @JsonDeserialize(using = CustomDateDeserializer.class)
    private Date ncuFechaprevisfin;
    private Integer ncuNumparticipantes;
    private String ncuResumenyproyecto;
    private String ncuPoblaciondirigida;
    private String ncuLugardicta;
    private Boolean ncuEstado;

    private Dia dia;
    private List<Curso> cursos;

    public Long getNcuId() {
        return ncuId;
    }

    public void setNcuId(Long ncuId) {
        this.ncuId = ncuId;
    }

    public String getNcuIdentificador() {
        return ncuIdentificador;
    }

    public void setNcuIdentificador(String ncuIdentificador) {
        this.ncuIdentificador = ncuIdentificador;
    }

    public Date getNcuFechaprevisfin() {
        return ncuFechaprevisfin;
    }

    public void setNcuFechaprevisfin(Date ncuFechaprevisfin) {
        this.ncuFechaprevisfin = ncuFechaprevisfin;
    }

    public Integer getNcuNumparticipantes() {
        return ncuNumparticipantes;
    }

    public void setNcuNumparticipantes(Integer ncuNumparticipantes) {
        this.ncuNumparticipantes = ncuNumparticipantes;
    }

    public String getNcuResumenyproyecto() {
        return ncuResumenyproyecto;
    }

    public void setNcuResumenyproyecto(String ncuResumenyproyecto) {
        this.ncuResumenyproyecto = ncuResumenyproyecto;
    }

    public String getNcuPoblaciondirigida() {
        return ncuPoblaciondirigida;
    }

    public void setNcuPoblaciondirigida(String ncuPoblaciondirigida) {
        this.ncuPoblaciondirigida = ncuPoblaciondirigida;
    }

    public String getNcuLugardicta() {
        return ncuLugardicta;
    }

    public void setNcuLugardicta(String ncuLugardicta) {
        this.ncuLugardicta = ncuLugardicta;
    }

    public Boolean getNcuEstado() {
        return ncuEstado;
    }

    public void setNcuEstado(Boolean ncuEstado) {
        this.ncuEstado = ncuEstado;
    }

    public Dia getDia() {
        return dia;
    }

    public void setDia(Dia dia) {
        this.dia = dia;
    }

    public List<Curso> getCursos() {
        return cursos;
    }

    public void setCursos(List<Curso> cursos) {
        this.cursos = cursos;
    }
}
