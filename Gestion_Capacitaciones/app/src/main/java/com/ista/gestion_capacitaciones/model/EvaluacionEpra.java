package com.ista.gestion_capacitaciones.model;

public class EvaluacionEpra {

    private Long eraId;

    private String eraTipoactividades;
    private Integer eraCantactvidades;
    private Integer eraPorcentcalificacion;
    private Integer eraTotal;
    private Boolean eraEstado;

    private DatosSilabo eraSilabo;

    public Long getEraId() {
        return eraId;
    }

    public void setEraId(Long eraId) {
        this.eraId = eraId;
    }

    public String getEraTipoactividades() {
        return eraTipoactividades;
    }

    public void setEraTipoactividades(String eraTipoactividades) {
        this.eraTipoactividades = eraTipoactividades;
    }

    public Integer getEraCantactvidades() {
        return eraCantactvidades;
    }

    public void setEraCantactvidades(Integer eraCantactvidades) {
        this.eraCantactvidades = eraCantactvidades;
    }

    public Integer getEraPorcentcalificacion() {
        return eraPorcentcalificacion;
    }

    public void setEraPorcentcalificacion(Integer eraPorcentcalificacion) {
        this.eraPorcentcalificacion = eraPorcentcalificacion;
    }

    public Integer getEraTotal() {
        return eraTotal;
    }

    public void setEraTotal(Integer eraTotal) {
        this.eraTotal = eraTotal;
    }

    public Boolean getEraEstado() {
        return eraEstado;
    }

    public void setEraEstado(Boolean eraEstado) {
        this.eraEstado = eraEstado;
    }

    public DatosSilabo getEraSilabo() {
        return eraSilabo;
    }

    public void setEraSilabo(DatosSilabo eraSilabo) {
        this.eraSilabo = eraSilabo;
    }
}
