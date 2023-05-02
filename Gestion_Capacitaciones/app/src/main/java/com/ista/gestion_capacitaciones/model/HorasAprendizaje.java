package com.ista.gestion_capacitaciones.model;

public class HorasAprendizaje {

    private Long hapId;
    private Integer hapDocencia;
    private Integer hapPracticas;
    private Integer hapTrabajoAutonomo;
    private Boolean hapEstado;

    private DatosSilabo hapSilabo;

    public Long getHapId() {
        return hapId;
    }

    public void setHapId(Long hapId) {
        this.hapId = hapId;
    }

    public Integer getHapDocencia() {
        return hapDocencia;
    }

    public void setHapDocencia(Integer hapDocencia) {
        this.hapDocencia = hapDocencia;
    }

    public Integer getHapPracticas() {
        return hapPracticas;
    }

    public void setHapPracticas(Integer hapPracticas) {
        this.hapPracticas = hapPracticas;
    }

    public Integer getHapTrabajoAutonomo() {
        return hapTrabajoAutonomo;
    }

    public void setHapTrabajoAutonomo(Integer hapTrabajoAutonomo) {
        this.hapTrabajoAutonomo = hapTrabajoAutonomo;
    }

    public Boolean getHapEstado() {
        return hapEstado;
    }

    public void setHapEstado(Boolean hapEstado) {
        this.hapEstado = hapEstado;
    }

    public DatosSilabo getHapSilabo() {
        return hapSilabo;
    }

    public void setHapSilabo(DatosSilabo hapSilabo) {
        this.hapSilabo = hapSilabo;
    }
}