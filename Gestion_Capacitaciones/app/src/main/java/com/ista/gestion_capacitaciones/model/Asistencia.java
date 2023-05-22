package com.ista.gestion_capacitaciones.model;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import com.ista.gestion_capacitaciones.utils.CustomDateDeserializer;

import java.util.Date;

public class Asistencia {

    @SerializedName("asiId")
    private Long asiId;

    @SerializedName("asiNumfaltas")
    private int asiNumfaltas;

    @SerializedName("asiFecha")
    @JsonDeserialize(using = CustomDateDeserializer.class)
    private Date asiFecha;

    @SerializedName("asiEstado")
    private Boolean asiEstado;

    @SerializedName("asiParticipante")
    private transient Participante asiParticipante;

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

    @Override
    public String toString() {
        return "Asistencia{" +
                "asiId=" + asiId +
                ", asiNumfaltas=" + asiNumfaltas +
                ", asiFecha=" + asiFecha +
                ", asiEstado=" + asiEstado +
                '}';
    }
}
