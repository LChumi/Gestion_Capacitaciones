package com.ista.gestion_capacitaciones.model;

public class ContenidoCurso {

    private Long ccuId;
    private Integer ccuDia;
    private String ccuContenidos;
    private Integer ccuHorasclase;
    private String ccuActividaddocencia;
    private Integer ccuHoraspractica;
    private String ccuActividadpractica;
    private Integer ccuHorastrabajoauto;
    private String ccuActividadtrabajoauto;
    private String ccuObservaciones;
    private Boolean ccuEstado;
    private DatosSilabo ccuSilabo;

    public Long getCcuId() {
        return ccuId;
    }

    public void setCcuId(Long ccuId) {
        this.ccuId = ccuId;
    }

    public Integer getCcuDia() {
        return ccuDia;
    }

    public void setCcuDia(Integer ccuDia) {
        this.ccuDia = ccuDia;
    }

    public String getCcuContenidos() {
        return ccuContenidos;
    }

    public void setCcuContenidos(String ccuContenidos) {
        this.ccuContenidos = ccuContenidos;
    }

    public Integer getCcuHorasclase() {
        return ccuHorasclase;
    }

    public void setCcuHorasclase(Integer ccuHorasclase) {
        this.ccuHorasclase = ccuHorasclase;
    }

    public String getCcuActividaddocencia() {
        return ccuActividaddocencia;
    }

    public void setCcuActividaddocencia(String ccuActividaddocencia) {
        this.ccuActividaddocencia = ccuActividaddocencia;
    }

    public Integer getCcuHoraspractica() {
        return ccuHoraspractica;
    }

    public void setCcuHoraspractica(Integer ccuHoraspractica) {
        this.ccuHoraspractica = ccuHoraspractica;
    }

    public String getCcuActividadpractica() {
        return ccuActividadpractica;
    }

    public void setCcuActividadpractica(String ccuActividadpractica) {
        this.ccuActividadpractica = ccuActividadpractica;
    }

    public Integer getCcuHorastrabajoauto() {
        return ccuHorastrabajoauto;
    }

    public void setCcuHorastrabajoauto(Integer ccuHorastrabajoauto) {
        this.ccuHorastrabajoauto = ccuHorastrabajoauto;
    }

    public String getCcuActividadtrabajoauto() {
        return ccuActividadtrabajoauto;
    }

    public void setCcuActividadtrabajoauto(String ccuActividadtrabajoauto) {
        this.ccuActividadtrabajoauto = ccuActividadtrabajoauto;
    }

    public String getCcuObservaciones() {
        return ccuObservaciones;
    }

    public void setCcuObservaciones(String ccuObservaciones) {
        this.ccuObservaciones = ccuObservaciones;
    }

    public Boolean getCcuEstado() {
        return ccuEstado;
    }

    public void setCcuEstado(Boolean ccuEstado) {
        this.ccuEstado = ccuEstado;
    }

    public DatosSilabo getCcuSilabo() {
        return ccuSilabo;
    }

    public void setCcuSilabo(DatosSilabo ccuSilabo) {
        this.ccuSilabo = ccuSilabo;
    }
}
