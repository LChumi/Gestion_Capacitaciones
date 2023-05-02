package com.ista.gestion_capacitaciones.model;

import java.util.List;

public class ProgramaCapacitacion {

    private Long pcaId;
    private String pcaNombre;
    private String pcaPeriodo;
    private String pcaProceso;
    private Boolean pcaEstado;

    private List<Curso> cursos;

    public Long getPcaId() {
        return pcaId;
    }

    public void setPcaId(Long pcaId) {
        this.pcaId = pcaId;
    }

    public String getPcaNombre() {
        return pcaNombre;
    }

    public void setPcaNombre(String pcaNombre) {
        this.pcaNombre = pcaNombre;
    }

    public String getPcaPeriodo() {
        return pcaPeriodo;
    }

    public void setPcaPeriodo(String pcaPeriodo) {
        this.pcaPeriodo = pcaPeriodo;
    }

    public String getPcaProceso() {
        return pcaProceso;
    }

    public void setPcaProceso(String pcaProceso) {
        this.pcaProceso = pcaProceso;
    }

    public Boolean getPcaEstado() {
        return pcaEstado;
    }

    public void setPcaEstado(Boolean pcaEstado) {
        this.pcaEstado = pcaEstado;
    }

    public List<Curso> getCursos() {
        return cursos;
    }

    public void setCursos(List<Curso> cursos) {
        this.cursos = cursos;
    }
}
