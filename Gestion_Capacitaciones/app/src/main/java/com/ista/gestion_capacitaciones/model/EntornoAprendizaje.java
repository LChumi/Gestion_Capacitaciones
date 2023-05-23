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

public class EntornoAprendizaje {

    private Long eapId;
    private String eapInstalaciones;
    private String eapRecursos;
    private String eapFaseteorica;
    private String eapFasepractica;
    private Boolean eapEstado;

    private DisenoCurricular eapDiseno;

    public Long getEapId() {
        return eapId;
    }

    public void setEapId(Long eapId) {
        this.eapId = eapId;
    }

    public String getEapInstalaciones() {
        return eapInstalaciones;
    }

    public void setEapInstalaciones(String eapInstalaciones) {
        this.eapInstalaciones = eapInstalaciones;
    }

    public String getEapRecursos() {
        return eapRecursos;
    }

    public void setEapRecursos(String eapRecursos) {
        this.eapRecursos = eapRecursos;
    }

    public String getEapFaseteorica() {
        return eapFaseteorica;
    }

    public void setEapFaseteorica(String eapFaseteorica) {
        this.eapFaseteorica = eapFaseteorica;
    }

    public String getEapFasepractica() {
        return eapFasepractica;
    }

    public void setEapFasepractica(String eapFasepractica) {
        this.eapFasepractica = eapFasepractica;
    }

    public Boolean getEapEstado() {
        return eapEstado;
    }

    public void setEapEstado(Boolean eapEstado) {
        this.eapEstado = eapEstado;
    }

    public DisenoCurricular getEapDiseno() {
        return eapDiseno;
    }

    public void setEapDiseno(DisenoCurricular eapDiseno) {
        this.eapDiseno = eapDiseno;
    }
}
