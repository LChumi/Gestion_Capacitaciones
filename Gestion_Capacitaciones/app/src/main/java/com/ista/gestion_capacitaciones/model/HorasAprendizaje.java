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

public class HorasAprendizaje {

    private Long hapId;
    private Integer hapDocencia;
    private Integer hapPracticas;
    private Integer hapTrabajoAutonomo;
    private Boolean hapEstado;

    private DatosSilabo hapSilabo;

    public Long getHapId() {
        return hapId;
    }

    public void setHapId(Long hapId) {
        this.hapId = hapId;
    }

    public Integer getHapDocencia() {
        return hapDocencia;
    }

    public void setHapDocencia(Integer hapDocencia) {
        this.hapDocencia = hapDocencia;
    }

    public Integer getHapPracticas() {
        return hapPracticas;
    }

    public void setHapPracticas(Integer hapPracticas) {
        this.hapPracticas = hapPracticas;
    }

    public Integer getHapTrabajoAutonomo() {
        return hapTrabajoAutonomo;
    }

    public void setHapTrabajoAutonomo(Integer hapTrabajoAutonomo) {
        this.hapTrabajoAutonomo = hapTrabajoAutonomo;
    }

    public Boolean getHapEstado() {
        return hapEstado;
    }

    public void setHapEstado(Boolean hapEstado) {
        this.hapEstado = hapEstado;
    }

    public DatosSilabo getHapSilabo() {
        return hapSilabo;
    }

    public void setHapSilabo(DatosSilabo hapSilabo) {
        this.hapSilabo = hapSilabo;
    }
}