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

public class DetalleMe {

    private Long dmeId;
    private String dmeTecnica;
    private String dmeInstrumento;
    private Boolean dmeEstado;

    private MecanismoEvaluacion mecanismoEvaluacion;

    public Long getDmeId() {
        return dmeId;
    }

    public void setDmeId(Long dmeId) {
        this.dmeId = dmeId;
    }

    public String getDmeTecnica() {
        return dmeTecnica;
    }

    public void setDmeTecnica(String dmeTecnica) {
        this.dmeTecnica = dmeTecnica;
    }

    public String getDmeInstrumento() {
        return dmeInstrumento;
    }

    public void setDmeInstrumento(String dmeInstrumento) {
        this.dmeInstrumento = dmeInstrumento;
    }

    public Boolean getDmeEstado() {
        return dmeEstado;
    }

    public void setDmeEstado(Boolean dmeEstado) {
        this.dmeEstado = dmeEstado;
    }

    public MecanismoEvaluacion getMecanismoEvaluacion() {
        return mecanismoEvaluacion;
    }

    public void setMecanismoEvaluacion(MecanismoEvaluacion mecanismoEvaluacion) {
        this.mecanismoEvaluacion = mecanismoEvaluacion;
    }
}
