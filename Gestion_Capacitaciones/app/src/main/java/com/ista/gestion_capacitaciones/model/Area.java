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

public class Area {

    private Long areId;
    private String areCodigo;
    private String areNombre;
    private Boolean areEstado;

    private List<Especialidad> especialidads;

    public Long getAreId() {
        return areId;
    }

    public void setAreId(Long areId) {
        this.areId = areId;
    }

    public String getAreCodigo() {
        return areCodigo;
    }

    public void setAreCodigo(String areCodigo) {
        this.areCodigo = areCodigo;
    }

    public String getAreNombre() {
        return areNombre;
    }

    public void setAreNombre(String areNombre) {
        this.areNombre = areNombre;
    }

    public Boolean getAreEstado() {
        return areEstado;
    }

    public void setAreEstado(Boolean areEstado) {
        this.areEstado = areEstado;
    }

    public List<Especialidad> getEspecialidads() {
        return especialidads;
    }

    public void setEspecialidads(List<Especialidad> especialidads) {
        this.especialidads = especialidads;
    }
}
