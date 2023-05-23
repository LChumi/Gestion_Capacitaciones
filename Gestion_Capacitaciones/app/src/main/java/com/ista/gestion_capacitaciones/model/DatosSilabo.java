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

public class DatosSilabo {
    private Long dsiId;
    private String dsiIdentificador;
    private String dsiPrerrequisitos;
    private String dsiDescripcioncurso;
    private String dsiObjetivogeneralc;
    private String dsiBibliografia;
    private Boolean dsiEstado;

    private List<HorasAprendizaje> horasAprendizajes;

    private List<RecursoDidactico> recursoDidacticos;

    private List<EstrategiaMetodologica> estrategiaMetodologicas;

    private List<ContenidoCurso> contenidoCursos;

    private List<ResultadoAprendizaje> resultadoAprendizajes;

    private List<EvaluacionEpra> evaluacionEpras;

    private List<Curso> cursos;

    public Long getDsiId() {
        return dsiId;
    }

    public void setDsiId(Long dsiId) {
        this.dsiId = dsiId;
    }

    public String getDsiIdentificador() {
        return dsiIdentificador;
    }

    public void setDsiIdentificador(String dsiIdentificador) {
        this.dsiIdentificador = dsiIdentificador;
    }

    public String getDsiPrerrequisitos() {
        return dsiPrerrequisitos;
    }

    public void setDsiPrerrequisitos(String dsiPrerrequisitos) {
        this.dsiPrerrequisitos = dsiPrerrequisitos;
    }

    public String getDsiDescripcioncurso() {
        return dsiDescripcioncurso;
    }

    public void setDsiDescripcioncurso(String dsiDescripcioncurso) {
        this.dsiDescripcioncurso = dsiDescripcioncurso;
    }

    public String getDsiObjetivogeneralc() {
        return dsiObjetivogeneralc;
    }

    public void setDsiObjetivogeneralc(String dsiObjetivogeneralc) {
        this.dsiObjetivogeneralc = dsiObjetivogeneralc;
    }

    public String getDsiBibliografia() {
        return dsiBibliografia;
    }

    public void setDsiBibliografia(String dsiBibliografia) {
        this.dsiBibliografia = dsiBibliografia;
    }

    public Boolean getDsiEstado() {
        return dsiEstado;
    }

    public void setDsiEstado(Boolean dsiEstado) {
        this.dsiEstado = dsiEstado;
    }

    public List<HorasAprendizaje> getHorasAprendizajes() {
        return horasAprendizajes;
    }

    public void setHorasAprendizajes(List<HorasAprendizaje> horasAprendizajes) {
        this.horasAprendizajes = horasAprendizajes;
    }

    public List<RecursoDidactico> getRecursoDidacticos() {
        return recursoDidacticos;
    }

    public void setRecursoDidacticos(List<RecursoDidactico> recursoDidacticos) {
        this.recursoDidacticos = recursoDidacticos;
    }

    public List<EstrategiaMetodologica> getEstrategiaMetodologicas() {
        return estrategiaMetodologicas;
    }

    public void setEstrategiaMetodologicas(List<EstrategiaMetodologica> estrategiaMetodologicas) {
        this.estrategiaMetodologicas = estrategiaMetodologicas;
    }

    public List<ContenidoCurso> getContenidoCursos() {
        return contenidoCursos;
    }

    public void setContenidoCursos(List<ContenidoCurso> contenidoCursos) {
        this.contenidoCursos = contenidoCursos;
    }

    public List<ResultadoAprendizaje> getResultadoAprendizajes() {
        return resultadoAprendizajes;
    }

    public void setResultadoAprendizajes(List<ResultadoAprendizaje> resultadoAprendizajes) {
        this.resultadoAprendizajes = resultadoAprendizajes;
    }

    public List<EvaluacionEpra> getEvaluacionEpras() {
        return evaluacionEpras;
    }

    public void setEvaluacionEpras(List<EvaluacionEpra> evaluacionEpras) {
        this.evaluacionEpras = evaluacionEpras;
    }

    public List<Curso> getCursos() {
        return cursos;
    }

    public void setCursos(List<Curso> cursos) {
        this.cursos = cursos;
    }
}
