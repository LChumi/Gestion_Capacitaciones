package com.ista.gestion_capacitaciones.model;

import java.util.List;

public class Dia {

    private Long diaId;
    private String diaNombre;
    private Boolean diaEstado;

    private List<NecesidadCurso> necesidadCursos;

    public Long getDiaId() {
        return diaId;
    }

    public void setDiaId(Long diaId) {
        this.diaId = diaId;
    }

    public String getDiaNombre() {
        return diaNombre;
    }

    public void setDiaNombre(String diaNombre) {
        this.diaNombre = diaNombre;
    }

    public Boolean getDiaEstado() {
        return diaEstado;
    }

    public void setDiaEstado(Boolean diaEstado) {
        this.diaEstado = diaEstado;
    }

    public List<NecesidadCurso> getNecesidadCursos() {
        return necesidadCursos;
    }

    public void setNecesidadCursos(List<NecesidadCurso> necesidadCursos) {
        this.necesidadCursos = necesidadCursos;
    }
}
