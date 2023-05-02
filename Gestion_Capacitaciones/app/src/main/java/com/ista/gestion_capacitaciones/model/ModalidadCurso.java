package com.ista.gestion_capacitaciones.model;

import java.util.List;

public class ModalidadCurso {

    private Long mcuId;
    private String mcuNombre;
    private Boolean mcuEstado;

    private List<Curso> cursos;

    public Long getMcuId() {
        return mcuId;
    }

    public void setMcuId(Long mcuId) {
        this.mcuId = mcuId;
    }

    public String getMcuNombre() {
        return mcuNombre;
    }

    public void setMcuNombre(String mcuNombre) {
        this.mcuNombre = mcuNombre;
    }

    public Boolean getMcuEstado() {
        return mcuEstado;
    }

    public void setMcuEstado(Boolean mcuEstado) {
        this.mcuEstado = mcuEstado;
    }

    public List<Curso> getCursos() {
        return cursos;
    }

    public void setCursos(List<Curso> cursos) {
        this.cursos = cursos;
    }
}
