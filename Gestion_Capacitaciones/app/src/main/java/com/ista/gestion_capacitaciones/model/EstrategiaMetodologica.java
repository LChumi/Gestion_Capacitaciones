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

public class EstrategiaMetodologica {

    private Long emeId;
    private String emeEstrategia;
    private String emeFinalidad;
    private Boolean emeEstado;

    private DatosSilabo emeSilabo;

    public Long getEmeId() {
        return emeId;
    }

    public void setEmeId(Long emeId) {
        this.emeId = emeId;
    }

    public String getEmeEstrategia() {
        return emeEstrategia;
    }

    public void setEmeEstrategia(String emeEstrategia) {
        this.emeEstrategia = emeEstrategia;
    }

    public String getEmeFinalidad() {
        return emeFinalidad;
    }

    public void setEmeFinalidad(String emeFinalidad) {
        this.emeFinalidad = emeFinalidad;
    }

    public Boolean getEmeEstado() {
        return emeEstado;
    }

    public void setEmeEstado(Boolean emeEstado) {
        this.emeEstado = emeEstado;
    }

    public DatosSilabo getEmeSilabo() {
        return emeSilabo;
    }

    public void setEmeSilabo(DatosSilabo emeSilabo) {
        this.emeSilabo = emeSilabo;
    }
}
