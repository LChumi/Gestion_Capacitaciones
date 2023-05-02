package com.ista.gestion_capacitaciones.model;

import java.util.List;

public class FichaEvaluacion {

    private Long fevId;
    private String fevNombre;
    private Boolean fevEstado;

    private Curso fevCurso;

    private List<DetalleFichaevaluacion> detalleFichaevaluacions;

    public Long getFevId() {
        return fevId;
    }

    public void setFevId(Long fevId) {
        this.fevId = fevId;
    }

    public String getFevNombre() {
        return fevNombre;
    }

    public void setFevNombre(String fevNombre) {
        this.fevNombre = fevNombre;
    }

    public Boolean getFevEstado() {
        return fevEstado;
    }

    public void setFevEstado(Boolean fevEstado) {
        this.fevEstado = fevEstado;
    }

    public Curso getFevCurso() {
        return fevCurso;
    }

    public void setFevCurso(Curso fevCurso) {
        this.fevCurso = fevCurso;
    }

    public List<DetalleFichaevaluacion> getDetalleFichaevaluacions() {
        return detalleFichaevaluacions;
    }

    public void setDetalleFichaevaluacions(List<DetalleFichaevaluacion> detalleFichaevaluacions) {
        this.detalleFichaevaluacions = detalleFichaevaluacions;
    }
}
