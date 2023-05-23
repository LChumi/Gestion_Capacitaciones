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

public class DisenoCurricular {

    private Long dcuId;
    private String dcuIdentificador;
    private String dcuNiveles;
    private String dcuTemastransversales;
    private Boolean dcuEstado;

    private List<Curso> cursos;

    private List<EntornoAprendizaje> entornoAprendizajes;

    private List<MecanismoEvaluacion> mecanismoEvaluacions;

    public Long getDcuId() {
        return dcuId;
    }

    public void setDcuId(Long dcuId) {
        this.dcuId = dcuId;
    }

    public String getDcuIdentificador() {
        return dcuIdentificador;
    }

    public void setDcuIdentificador(String dcuIdentificador) {
        this.dcuIdentificador = dcuIdentificador;
    }

    public String getDcuNiveles() {
        return dcuNiveles;
    }

    public void setDcuNiveles(String dcuNiveles) {
        this.dcuNiveles = dcuNiveles;
    }

    public String getDcuTemastransversales() {
        return dcuTemastransversales;
    }

    public void setDcuTemastransversales(String dcuTemastransversales) {
        this.dcuTemastransversales = dcuTemastransversales;
    }

    public Boolean getDcuEstado() {
        return dcuEstado;
    }

    public void setDcuEstado(Boolean dcuEstado) {
        this.dcuEstado = dcuEstado;
    }

    public List<Curso> getCursos() {
        return cursos;
    }

    public void setCursos(List<Curso> cursos) {
        this.cursos = cursos;
    }

    public List<EntornoAprendizaje> getEntornoAprendizajes() {
        return entornoAprendizajes;
    }

    public void setEntornoAprendizajes(List<EntornoAprendizaje> entornoAprendizajes) {
        this.entornoAprendizajes = entornoAprendizajes;
    }

    public List<MecanismoEvaluacion> getMecanismoEvaluacions() {
        return mecanismoEvaluacions;
    }

    public void setMecanismoEvaluacions(List<MecanismoEvaluacion> mecanismoEvaluacions) {
        this.mecanismoEvaluacions = mecanismoEvaluacions;
    }
}
