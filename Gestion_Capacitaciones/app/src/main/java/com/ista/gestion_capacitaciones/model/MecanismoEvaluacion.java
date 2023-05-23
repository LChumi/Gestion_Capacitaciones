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

public class MecanismoEvaluacion {

    private Long mevId;
    private String mevDescripcion;
    private Boolean mevEstado;

    private DisenoCurricular mevDiseno;
    private List<DetalleMe> detallesME;

    public Long getMevId() {
        return mevId;
    }

    public void setMevId(Long mevId) {
        this.mevId = mevId;
    }

    public String getMevDescripcion() {
        return mevDescripcion;
    }

    public void setMevDescripcion(String mevDescripcion) {
        this.mevDescripcion = mevDescripcion;
    }

    public Boolean getMevEstado() {
        return mevEstado;
    }

    public void setMevEstado(Boolean mevEstado) {
        this.mevEstado = mevEstado;
    }

    public DisenoCurricular getMevDiseno() {
        return mevDiseno;
    }

    public void setMevDiseno(DisenoCurricular mevDiseno) {
        this.mevDiseno = mevDiseno;
    }

    public List<DetalleMe> getDetallesME() {
        return detallesME;
    }

    public void setDetallesME(List<DetalleMe> detallesME) {
        this.detallesME = detallesME;
    }
}
