package com.ista.gestion_capacitaciones.model;

import java.util.List;

public class Especialidad {

    private Long espId;
    private String espCodigo;
    private String espNombre;
    private Boolean espEstado;

    private Area area;

    private List<Curso> cursos;

    public Long getEspId() {
        return espId;
    }

    public void setEspId(Long espId) {
        this.espId = espId;
    }

    public String getEspCodigo() {
        return espCodigo;
    }

    public void setEspCodigo(String espCodigo) {
        this.espCodigo = espCodigo;
    }

    public String getEspNombre() {
        return espNombre;
    }

    public void setEspNombre(String espNombre) {
        this.espNombre = espNombre;
    }

    public Boolean getEspEstado() {
        return espEstado;
    }

    public void setEspEstado(Boolean espEstado) {
        this.espEstado = espEstado;
    }

    public Area getArea() {
        return area;
    }

    public void setArea(Area area) {
        this.area = area;
    }

    public List<Curso> getCursos() {
        return cursos;
    }

    public void setCursos(List<Curso> cursos) {
        this.cursos = cursos;
    }
}
