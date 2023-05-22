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
