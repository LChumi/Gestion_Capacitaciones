package com.ista.gestion_capacitaciones.model;

import java.util.Date;

public class AsistenciaCurso {

    private Long acuId;
    private String acuObservacion;
    private Date acuFechaelaboracion;
    private Boolean acuEstado;

    private Curso acuCurso;

    public Long getAcuId() {
        return acuId;
    }

    public void setAcuId(Long acuId) {
        this.acuId = acuId;
    }

    public String getAcuObservacion() {
        return acuObservacion;
    }

    public void setAcuObservacion(String acuObservacion) {
        this.acuObservacion = acuObservacion;
    }

    public Date getAcuFechaelaboracion() {
        return acuFechaelaboracion;
    }

    public void setAcuFechaelaboracion(Date acuFechaelaboracion) {
        this.acuFechaelaboracion = acuFechaelaboracion;
    }

    public Boolean getAcuEstado() {
        return acuEstado;
    }

    public void setAcuEstado(Boolean acuEstado) {
        this.acuEstado = acuEstado;
    }

    public Curso getAcuCurso() {
        return acuCurso;
    }

    public void setAcuCurso(Curso acuCurso) {
        this.acuCurso = acuCurso;
    }
}
