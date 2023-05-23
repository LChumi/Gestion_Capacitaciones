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

public class RecursoDidactico {

    private Long rdiId;
    private String rdiMateconvencional;
    private String rdiMateaudiovisula;
    private Boolean rdiEstado;

    private DatosSilabo rdiSilabo;

    public Long getRdiId() {
        return rdiId;
    }

    public void setRdiId(Long rdiId) {
        this.rdiId = rdiId;
    }

    public String getRdiMateconvencional() {
        return rdiMateconvencional;
    }

    public void setRdiMateconvencional(String rdiMateconvencional) {
        this.rdiMateconvencional = rdiMateconvencional;
    }

    public String getRdiMateaudiovisula() {
        return rdiMateaudiovisula;
    }

    public void setRdiMateaudiovisula(String rdiMateaudiovisula) {
        this.rdiMateaudiovisula = rdiMateaudiovisula;
    }

    public Boolean getRdiEstado() {
        return rdiEstado;
    }

    public void setRdiEstado(Boolean rdiEstado) {
        this.rdiEstado = rdiEstado;
    }

    public DatosSilabo getRdiSilabo() {
        return rdiSilabo;
    }

    public void setRdiSilabo(DatosSilabo rdiSilabo) {
        this.rdiSilabo = rdiSilabo;
    }
}
