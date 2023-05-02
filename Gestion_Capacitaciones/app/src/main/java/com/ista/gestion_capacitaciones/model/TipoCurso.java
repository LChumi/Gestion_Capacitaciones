package com.ista.gestion_capacitaciones.model;

import java.util.List;

public class TipoCurso {

    private Long tcuId;
    private String tcuNombre;
    private Boolean tcuEstado;

    private List<Curso> cursos;

    public Long getTcuId() {
        return tcuId;
    }

    public void setTcuId(Long tcuId) {
        this.tcuId = tcuId;
    }

    public String getTcuNombre() {
        return tcuNombre;
    }

    public void setTcuNombre(String tcuNombre) {
        this.tcuNombre = tcuNombre;
    }

    public Boolean getTcuEstado() {
        return tcuEstado;
    }

    public void setTcuEstado(Boolean tcuEstado) {
        this.tcuEstado = tcuEstado;
    }

    public List<Curso> getCursos() {
        return cursos;
    }

    public void setCursos(List<Curso> cursos) {
        this.cursos = cursos;
    }
}
