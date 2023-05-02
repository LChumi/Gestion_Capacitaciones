package com.ista.gestion_capacitaciones.model;

import java.util.List;

public class Participante {

    private Long parId;
    private Double parNotaparcila;
    private Double parNotafinal;
    private Double parPromedio;
    private String parObservacion;
    private String parEstadoaprovacion;
    private Boolean parEstado;

    private Persona parPersona;
    private Curso parCurso;
    private List<EntregaCertificado> entregaCertificados;
    private List<Asistencia> asistencias;

    public Long getParId() {
        return parId;
    }

    public void setParId(Long parId) {
        this.parId = parId;
    }

    public Double getParNotaparcila() {
        return parNotaparcila;
    }

    public void setParNotaparcila(Double parNotaparcila) {
        this.parNotaparcila = parNotaparcila;
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
}
