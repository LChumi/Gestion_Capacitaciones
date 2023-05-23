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

public class EvaluacionEpra {

    private Long eraId;

    private String eraTipoactividades;
    private Integer eraCantactvidades;
    private Integer eraPorcentcalificacion;
    private Integer eraTotal;
    private Boolean eraEstado;

    private DatosSilabo eraSilabo;

    public Long getEraId() {
        return eraId;
    }

    public void setEraId(Long eraId) {
        this.eraId = eraId;
    }

    public String getEraTipoactividades() {
        return eraTipoactividades;
    }

    public void setEraTipoactividades(String eraTipoactividades) {
        this.eraTipoactividades = eraTipoactividades;
    }

    public Integer getEraCantactvidades() {
        return eraCantactvidades;
    }

    public void setEraCantactvidades(Integer eraCantactvidades) {
        this.eraCantactvidades = eraCantactvidades;
    }

    public Integer getEraPorcentcalificacion() {
        return eraPorcentcalificacion;
    }

    public void setEraPorcentcalificacion(Integer eraPorcentcalificacion) {
        this.eraPorcentcalificacion = eraPorcentcalificacion;
    }

    public Integer getEraTotal() {
        return eraTotal;
    }

    public void setEraTotal(Integer eraTotal) {
        this.eraTotal = eraTotal;
    }

    public Boolean getEraEstado() {
        return eraEstado;
    }

    public void setEraEstado(Boolean eraEstado) {
        this.eraEstado = eraEstado;
    }

    public DatosSilabo getEraSilabo() {
        return eraSilabo;
    }

    public void setEraSilabo(DatosSilabo eraSilabo) {
        this.eraSilabo = eraSilabo;
    }
}
