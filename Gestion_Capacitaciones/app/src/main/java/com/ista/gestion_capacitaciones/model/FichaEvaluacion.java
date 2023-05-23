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

public class FichaEvaluacion {

    private Long fevId;
    private String fevNombre;
    private Boolean fevEstado;

    private Curso fevCurso;

    private List<DetalleFichaevaluacion> detalleFichaevaluacions;

    public Long getFevId() {
        return fevId;
    }

    public void setFevId(Long fevId) {
        this.fevId = fevId;
    }

    public String getFevNombre() {
        return fevNombre;
    }

    public void setFevNombre(String fevNombre) {
        this.fevNombre = fevNombre;
    }

    public Boolean getFevEstado() {
        return fevEstado;
    }

    public void setFevEstado(Boolean fevEstado) {
        this.fevEstado = fevEstado;
    }

    public Curso getFevCurso() {
        return fevCurso;
    }

    public void setFevCurso(Curso fevCurso) {
        this.fevCurso = fevCurso;
    }

    public List<DetalleFichaevaluacion> getDetalleFichaevaluacions() {
        return detalleFichaevaluacions;
    }

    public void setDetalleFichaevaluacions(List<DetalleFichaevaluacion> detalleFichaevaluacions) {
        this.detalleFichaevaluacions = detalleFichaevaluacions;
    }
}
