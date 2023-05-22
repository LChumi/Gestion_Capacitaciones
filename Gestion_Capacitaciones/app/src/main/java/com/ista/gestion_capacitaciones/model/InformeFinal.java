package com.ista.gestion_capacitaciones.model;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.ista.gestion_capacitaciones.utils.CustomDateDeserializer;

import java.util.Date;

public class InformeFinal {

    private Long ifiId;
    private String ifiObservaciones;
    @JsonDeserialize(using = CustomDateDeserializer.class)
    private Date ifiFecha;
    private Boolean ifiEstado;

    private Curso ifiCurso;

    public Long getIfiId() {
        return ifiId;
    }

    public void setIfiId(Long ifiId) {
        this.ifiId = ifiId;
    }

    public String getIfiObservaciones() {
        return ifiObservaciones;
    }

    public void setIfiObservaciones(String ifiObservaciones) {
        this.ifiObservaciones = ifiObservaciones;
    }

    public Date getIfiFecha() {
        return ifiFecha;
    }

    public void setIfiFecha(Date ifiFecha) {
        this.ifiFecha = ifiFecha;
    }

    public Boolean getIfiEstado() {
        return ifiEstado;
    }

    public void setIfiEstado(Boolean ifiEstado) {
        this.ifiEstado = ifiEstado;
    }

    public Curso getIfiCurso() {
        return ifiCurso;
    }

    public void setIfiCurso(Curso ifiCurso) {
        this.ifiCurso = ifiCurso;
    }
}
