package com.ista.gestion_capacitaciones.model;

import java.util.List;

public class MecanismoEvaluacion {

    private Long mevId;
    private String mevDescripcion;
    private Boolean mevEstado;

    private DisenoCurricular mevDiseno;
    private List<DetalleMe> detallesME;

    public Long getMevId() {
        return mevId;
    }

    public void setMevId(Long mevId) {
        this.mevId = mevId;
    }

    public String getMevDescripcion() {
        return mevDescripcion;
    }

    public void setMevDescripcion(String mevDescripcion) {
        this.mevDescripcion = mevDescripcion;
    }

    public Boolean getMevEstado() {
        return mevEstado;
    }

    public void setMevEstado(Boolean mevEstado) {
        this.mevEstado = mevEstado;
    }

    public DisenoCurricular getMevDiseno() {
        return mevDiseno;
    }

    public void setMevDiseno(DisenoCurricular mevDiseno) {
        this.mevDiseno = mevDiseno;
    }

    public List<DetalleMe> getDetallesME() {
        return detallesME;
    }

    public void setDetallesME(List<DetalleMe> detallesME) {
        this.detallesME = detallesME;
    }
}
