package com.ista.gestion_capacitaciones.model;

public class EstrategiaMetodologica {

    private Long emeId;
    private String emeEstrategia;
    private String emeFinalidad;
    private Boolean emeEstado;

    private DatosSilabo emeSilabo;

    public Long getEmeId() {
        return emeId;
    }

    public void setEmeId(Long emeId) {
        this.emeId = emeId;
    }

    public String getEmeEstrategia() {
        return emeEstrategia;
    }

    public void setEmeEstrategia(String emeEstrategia) {
        this.emeEstrategia = emeEstrategia;
    }

    public String getEmeFinalidad() {
        return emeFinalidad;
    }

    public void setEmeFinalidad(String emeFinalidad) {
        this.emeFinalidad = emeFinalidad;
    }

    public Boolean getEmeEstado() {
        return emeEstado;
    }

    public void setEmeEstado(Boolean emeEstado) {
        this.emeEstado = emeEstado;
    }

    public DatosSilabo getEmeSilabo() {
        return emeSilabo;
    }

    public void setEmeSilabo(DatosSilabo emeSilabo) {
        this.emeSilabo = emeSilabo;
    }
}
