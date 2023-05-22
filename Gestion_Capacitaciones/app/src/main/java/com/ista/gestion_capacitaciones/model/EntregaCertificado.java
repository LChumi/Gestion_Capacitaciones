package com.ista.gestion_capacitaciones.model;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.ista.gestion_capacitaciones.utils.CustomDateDeserializer;

import java.util.Date;

public class EntregaCertificado {

    private Long eceId;
    private String eceCodigocertificado;
    @JsonDeserialize(using = CustomDateDeserializer.class)
    private Date eceFecharetiro;
    private Boolean eceFirma;
    private Boolean eceEstado;

    private Participante eceParticipante;

    public Long getEceId() {
        return eceId;
    }

    public void setEceId(Long eceId) {
        this.eceId = eceId;
    }

    public String getEceCodigocertificado() {
        return eceCodigocertificado;
    }

    public void setEceCodigocertificado(String eceCodigocertificado) {
        this.eceCodigocertificado = eceCodigocertificado;
    }

    public Date getEceFecharetiro() {
        return eceFecharetiro;
    }

    public void setEceFecharetiro(Date eceFecharetiro) {
        this.eceFecharetiro = eceFecharetiro;
    }

    public Boolean getEceFirma() {
        return eceFirma;
    }

    public void setEceFirma(Boolean eceFirma) {
        this.eceFirma = eceFirma;
    }

    public Boolean getEceEstado() {
        return eceEstado;
    }

    public void setEceEstado(Boolean eceEstado) {
        this.eceEstado = eceEstado;
    }

    public Participante getEceParticipante() {
        return eceParticipante;
    }

    public void setEceParticipante(Participante eceParticipante) {
        this.eceParticipante = eceParticipante;
    }
}
