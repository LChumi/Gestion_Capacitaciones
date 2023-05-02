package com.ista.gestion_capacitaciones.model;

public class RecursoDidactico {

    private Long rdiId;
    private String rdiMateconvencional;
    private String rdiMateaudiovisula;
    private Boolean rdiEstado;

    private DatosSilabo rdiSilabo;

    public Long getRdiId() {
        return rdiId;
    }

    public void setRdiId(Long rdiId) {
        this.rdiId = rdiId;
    }

    public String getRdiMateconvencional() {
        return rdiMateconvencional;
    }

    public void setRdiMateconvencional(String rdiMateconvencional) {
        this.rdiMateconvencional = rdiMateconvencional;
    }

    public String getRdiMateaudiovisula() {
        return rdiMateaudiovisula;
    }

    public void setRdiMateaudiovisula(String rdiMateaudiovisula) {
        this.rdiMateaudiovisula = rdiMateaudiovisula;
    }

    public Boolean getRdiEstado() {
        return rdiEstado;
    }

    public void setRdiEstado(Boolean rdiEstado) {
        this.rdiEstado = rdiEstado;
    }

    public DatosSilabo getRdiSilabo() {
        return rdiSilabo;
    }

    public void setRdiSilabo(DatosSilabo rdiSilabo) {
        this.rdiSilabo = rdiSilabo;
    }
}
