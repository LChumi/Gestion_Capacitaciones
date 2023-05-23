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

public class DetalleFichaevaluacion {

    private Long dfeId;
    private String dfePregunta;
    private String dfeCalificacion;
    private Boolean dfeEstado;

    private FichaEvaluacion fichaEvaluacion;

    public Long getDfeId() {
        return dfeId;
    }

    public void setDfeId(Long dfeId) {
        this.dfeId = dfeId;
    }

    public String getDfePregunta() {
        return dfePregunta;
    }

    public void setDfePregunta(String dfePregunta) {
        this.dfePregunta = dfePregunta;
    }

    public String getDfeCalificacion() {
        return dfeCalificacion;
    }

    public void setDfeCalificacion(String dfeCalificacion) {
        this.dfeCalificacion = dfeCalificacion;
    }

    public Boolean getDfeEstado() {
        return dfeEstado;
    }

    public void setDfeEstado(Boolean dfeEstado) {
        this.dfeEstado = dfeEstado;
    }

    public FichaEvaluacion getFichaEvaluacion() {
        return fichaEvaluacion;
    }

    public void setFichaEvaluacion(FichaEvaluacion fichaEvaluacion) {
        this.fichaEvaluacion = fichaEvaluacion;
    }
}
