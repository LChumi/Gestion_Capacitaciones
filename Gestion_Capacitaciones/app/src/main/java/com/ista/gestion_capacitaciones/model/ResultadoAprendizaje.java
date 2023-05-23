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

public class ResultadoAprendizaje {

    private Long rapId;
    private String rapUnidadcompe;
    private String rapElementoscompe;
    private String rapResultadosaprenactiv;
    private String rapFormaevidenciar;
    private Boolean rapEstado;

    private DatosSilabo rapSilabo;

    public Long getRapId() {
        return rapId;
    }

    public void setRapId(Long rapId) {
        this.rapId = rapId;
    }

    public String getRapUnidadcompe() {
        return rapUnidadcompe;
    }

    public void setRapUnidadcompe(String rapUnidadcompe) {
        this.rapUnidadcompe = rapUnidadcompe;
    }

    public String getRapElementoscompe() {
        return rapElementoscompe;
    }

    public void setRapElementoscompe(String rapElementoscompe) {
        this.rapElementoscompe = rapElementoscompe;
    }

    public String getRapResultadosaprenactiv() {
        return rapResultadosaprenactiv;
    }

    public void setRapResultadosaprenactiv(String rapResultadosaprenactiv) {
        this.rapResultadosaprenactiv = rapResultadosaprenactiv;
    }

    public String getRapFormaevidenciar() {
        return rapFormaevidenciar;
    }

    public void setRapFormaevidenciar(String rapFormaevidenciar) {
        this.rapFormaevidenciar = rapFormaevidenciar;
    }

    public Boolean getRapEstado() {
        return rapEstado;
    }

    public void setRapEstado(Boolean rapEstado) {
        this.rapEstado = rapEstado;
    }

    public DatosSilabo getRapSilabo() {
        return rapSilabo;
    }

    public void setRapSilabo(DatosSilabo rapSilabo) {
        this.rapSilabo = rapSilabo;
    }
}
