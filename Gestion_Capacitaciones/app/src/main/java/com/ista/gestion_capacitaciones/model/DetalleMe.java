package com.ista.gestion_capacitaciones.model;

public class DetalleMe {

    private Long dmeId;
    private String dmeTecnica;
    private String dmeInstrumento;
    private Boolean dmeEstado;

    private MecanismoEvaluacion mecanismoEvaluacion;

    public Long getDmeId() {
        return dmeId;
    }

    public void setDmeId(Long dmeId) {
        this.dmeId = dmeId;
    }

    public String getDmeTecnica() {
        return dmeTecnica;
    }

    public void setDmeTecnica(String dmeTecnica) {
        this.dmeTecnica = dmeTecnica;
    }

    public String getDmeInstrumento() {
        return dmeInstrumento;
    }

    public void setDmeInstrumento(String dmeInstrumento) {
        this.dmeInstrumento = dmeInstrumento;
    }

    public Boolean getDmeEstado() {
        return dmeEstado;
    }

    public void setDmeEstado(Boolean dmeEstado) {
        this.dmeEstado = dmeEstado;
    }

    public MecanismoEvaluacion getMecanismoEvaluacion() {
        return mecanismoEvaluacion;
    }

    public void setMecanismoEvaluacion(MecanismoEvaluacion mecanismoEvaluacion) {
        this.mecanismoEvaluacion = mecanismoEvaluacion;
    }
}
