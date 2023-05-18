package com.ista.gestion_capacitaciones.model;

import java.util.Date;

public class Asistencia {

    private Long asiId;
    private int asiNumfaltas;
    private Date asiFecha;
    private Boolean asiEstado;

    private Participante asiParticipante;

    public Long getAsiId() {
        return asiId;
    }

    public void setAsiId(Long asiId) {
        this.asiId = asiId;
    }

    public int getAsiNumfaltas() {
        return asiNumfaltas;
    }

    public void setAsiNumfaltas(int asiNumfaltas) {
        this.asiNumfaltas = asiNumfaltas;
    }

    public Date getAsiFecha() {
        return asiFecha;
    }

    public void setAsiFecha(Date asiFecha) {
        this.asiFecha = asiFecha;
    }

    public Boolean getAsiEstado() {
        return asiEstado;
    }

    public void setAsiEstado(Boolean asiEstado) {
        this.asiEstado = asiEstado;
    }

    public Participante getAsiParticipante() {
        return asiParticipante;
    }

    public void setAsiParticipante(Participante asiParticipante) {
        this.asiParticipante = asiParticipante;
    }
}
