package com.ista.gestion_capacitaciones.model;

import java.util.Date;

public class RegistroFotografico {

    private Long rfoId;
    private Integer rfoNumero;
    private String rfoDescripcion;
    private Date rfoFecha;
    private Boolean rfoEstado;
    private String rfoFoto;

    private Curso rfoCurso;

    public Long getRfoId() {
        return rfoId;
    }

    public void setRfoId(Long rfoId) {
        this.rfoId = rfoId;
    }

    public Integer getRfoNumero() {
        return rfoNumero;
    }

    public void setRfoNumero(Integer rfoNumero) {
        this.rfoNumero = rfoNumero;
    }

    public String getRfoDescripcion() {
        return rfoDescripcion;
    }

    public void setRfoDescripcion(String rfoDescripcion) {
        this.rfoDescripcion = rfoDescripcion;
    }

    public Date getRfoFecha() {
        return rfoFecha;
    }

    public void setRfoFecha(Date rfoFecha) {
        this.rfoFecha = rfoFecha;
    }

    public Boolean getRfoEstado() {
        return rfoEstado;
    }

    public void setRfoEstado(Boolean rfoEstado) {
        this.rfoEstado = rfoEstado;
    }

    public String getRfoFoto() {
        return rfoFoto;
    }

    public void setRfoFoto(String rfoFoto) {
        this.rfoFoto = rfoFoto;
    }

    public Curso getRfoCurso() {
        return rfoCurso;
    }

    public void setRfoCurso(Curso rfoCurso) {
        this.rfoCurso = rfoCurso;
    }
}
