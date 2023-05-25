/*
 *
 *   Created Luis Chumi on 23/5/23 9:38
 *   Copyright Ⓒ 2023. All rights reserved Ⓒ 2023 http://freefuninfo.com/
 *   Last modified: 21/5/23 19:54
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

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Participante {

    @SerializedName("parId")
    private Long parId;
    @SerializedName("parNotaparcial")
    private Double parNotaparcial;
    @SerializedName("parNotafinal")
    private Double parNotafinal;
    @SerializedName("parPromedio")
    private Double parPromedio;
    @SerializedName("parObservacion")
    private String parObservacion;
    @SerializedName("parEstadoaprovacion")
    private String parEstadoaprovacion;
    @SerializedName("parEstado")
    private Boolean parEstado;
    @SerializedName("parPersona")
    private Persona parPersona;
    @SerializedName("parCurso")
    private Curso parCurso;
    @SerializedName("hcuId")
    private HorarioCurso parHorario;
    @Expose(serialize = false, deserialize = false)
    private List<EntregaCertificado> entregaCertificados;
    @SerializedName("asistencias")
    private transient List<Asistencia> asistencias;

    public Long getParId() {
        return parId;
    }

    public void setParId(Long parId) {
        this.parId = parId;
    }

    public Double getParNotaparcial() {
        return parNotaparcial;
    }

    public void setParNotaparcial(Double parNotaparcial) {
        this.parNotaparcial = parNotaparcial;
    }

    public Double getParNotafinal() {
        return parNotafinal;
    }

    public void setParNotafinal(Double parNotafinal) {
        this.parNotafinal = parNotafinal;
    }

    public Double getParPromedio() {
        return parPromedio;
    }

    public void setParPromedio(Double parPromedio) {
        this.parPromedio = parPromedio;
    }

    public String getParObservacion() {
        return parObservacion;
    }

    public void setParObservacion(String parObservacion) {
        this.parObservacion = parObservacion;
    }

    public String getParEstadoaprovacion() {
        return parEstadoaprovacion;
    }

    public void setParEstadoaprovacion(String parEstadoaprovacion) {
        this.parEstadoaprovacion = parEstadoaprovacion;
    }

    public Boolean getParEstado() {
        return parEstado;
    }

    public void setParEstado(Boolean parEstado) {
        this.parEstado = parEstado;
    }

    public Persona getParPersona() {
        return parPersona;
    }

    public void setParPersona(Persona parPersona) {
        this.parPersona = parPersona;
    }

    public Curso getParCurso() {
        return parCurso;
    }

    public void setParCurso(Curso parCurso) {
        this.parCurso = parCurso;
    }

    public HorarioCurso getParHorario() {
        return parHorario;
    }

    public void setParHorario(HorarioCurso parHorario) {
        this.parHorario = parHorario;
    }

    public List<EntregaCertificado> getEntregaCertificados() {
        return entregaCertificados;
    }

    public void setEntregaCertificados(List<EntregaCertificado> entregaCertificados) {
        this.entregaCertificados = entregaCertificados;
    }

    public List<Asistencia> getAsistencias() {
        return asistencias;
    }

    public void setAsistencias(List<Asistencia> asistencias) {
        this.asistencias = asistencias;
    }

    @Override
    public String toString() {
        return "Participante{" +
                "parId=" + parId +
                ", parNotaparcial=" + parNotaparcial +
                ", parNotafinal=" + parNotafinal +
                ", parPromedio=" + parPromedio +
                ", parObservacion='" + parObservacion + '\'' +
                ", parEstadoaprovacion='" + parEstadoaprovacion + '\'' +
                ", parEstado=" + parEstado +
                ", parCurso=" + parCurso +
                ", entregaCertificados=" + entregaCertificados +
                ", asistencias=" + asistencias +
                '}';
    }
}
