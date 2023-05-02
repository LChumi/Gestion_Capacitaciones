package com.ista.gestion_capacitaciones.model;

public class Asistencia {

    private Long asiId;
    private String asiNumfaltas;
    private String asiFecha;
    private Boolean asiEstado;

    private Participante asiParticipante;

    public Long getAsiId() {
        return asiId;
    }

    public void setAsiId(Long asiId) {
        this.asiId = asiId;
    }

    public String getAsiNumfaltas() {
        return asiNumfaltas;
    }

    public void setAsiNumfaltas(String asiNumfaltas) {
        this.asiNumfaltas = asiNumfaltas;
    }

    public String getAsiFecha() {
        return asiFecha;
    }

    public void setAsiFecha(String asiFecha) {
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
