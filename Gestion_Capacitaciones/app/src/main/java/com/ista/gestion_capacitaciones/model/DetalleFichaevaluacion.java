package com.ista.gestion_capacitaciones.model;

public class DetalleFichaevaluacion {

    private Long dfeId;
    private String dfePregunta;
    private String dfeCalificacion;
    private Boolean dfeEstado;

    private FichaEvaluacion fichaEvaluacion;

    public Long getDfeId() {
        return dfeId;
    }

    public void setDfeId(Long dfeId) {
        this.dfeId = dfeId;
    }

    public String getDfePregunta() {
        return dfePregunta;
    }

    public void setDfePregunta(String dfePregunta) {
        this.dfePregunta = dfePregunta;
    }

    public String getDfeCalificacion() {
        return dfeCalificacion;
    }

    public void setDfeCalificacion(String dfeCalificacion) {
        this.dfeCalificacion = dfeCalificacion;
    }

    public Boolean getDfeEstado() {
        return dfeEstado;
    }

    public void setDfeEstado(Boolean dfeEstado) {
        this.dfeEstado = dfeEstado;
    }

    public FichaEvaluacion getFichaEvaluacion() {
        return fichaEvaluacion;
    }

    public void setFichaEvaluacion(FichaEvaluacion fichaEvaluacion) {
        this.fichaEvaluacion = fichaEvaluacion;
    }
}
