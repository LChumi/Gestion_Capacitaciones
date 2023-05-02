package com.ista.gestion_capacitaciones.model;

import java.util.List;

public class Area {

    private Long areId;
    private String areCodigo;
    private String areNombre;
    private Boolean areEstado;

    private List<Especialidad> especialidads;

    public Long getAreId() {
        return areId;
    }

    public void setAreId(Long areId) {
        this.areId = areId;
    }

    public String getAreCodigo() {
        return areCodigo;
    }

    public void setAreCodigo(String areCodigo) {
        this.areCodigo = areCodigo;
    }

    public String getAreNombre() {
        return areNombre;
    }

    public void setAreNombre(String areNombre) {
        this.areNombre = areNombre;
    }

    public Boolean getAreEstado() {
        return areEstado;
    }

    public void setAreEstado(Boolean areEstado) {
        this.areEstado = areEstado;
    }

    public List<Especialidad> getEspecialidads() {
        return especialidads;
    }

    public void setEspecialidads(List<Especialidad> especialidads) {
        this.especialidads = especialidads;
    }
}
