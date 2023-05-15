package com.ista.gestion_capacitaciones.model;

import java.util.List;

public class DisenoCurricular {

    private Long dcuId;
    private String dcuIdentificador;
    private String dcuNiveles;
    private String dcuTemastransversales;
    private Boolean dcuEstado;

    private List<Curso> cursos;

    private List<EntornoAprendizaje> entornoAprendizajes;

    private List<MecanismoEvaluacion> mecanismoEvaluacions;

    public Long getDcuId() {
        return dcuId;
    }

    public void setDcuId(Long dcuId) {
        this.dcuId = dcuId;
    }

    public String getDcuIdentificador() {
        return dcuIdentificador;
    }

    public void setDcuIdentificador(String dcuIdentificador) {
        this.dcuIdentificador = dcuIdentificador;
    }

    public String getDcuNiveles() {
        return dcuNiveles;
    }

    public void setDcuNiveles(String dcuNiveles) {
        this.dcuNiveles = dcuNiveles;
    }

    public String getDcuTemastransversales() {
        return dcuTemastransversales;
    }

    public void setDcuTemastransversales(String dcuTemastransversales) {
        this.dcuTemastransversales = dcuTemastransversales;
    }

    public Boolean getDcuEstado() {
        return dcuEstado;
    }

    public void setDcuEstado(Boolean dcuEstado) {
        this.dcuEstado = dcuEstado;
    }

    public List<Curso> getCursos() {
        return cursos;
    }

    public void setCursos(List<Curso> cursos) {
        this.cursos = cursos;
    }

    public List<EntornoAprendizaje> getEntornoAprendizajes() {
        return entornoAprendizajes;
    }

    public void setEntornoAprendizajes(List<EntornoAprendizaje> entornoAprendizajes) {
        this.entornoAprendizajes = entornoAprendizajes;
    }

    public List<MecanismoEvaluacion> getMecanismoEvaluacions() {
        return mecanismoEvaluacions;
    }

    public void setMecanismoEvaluacions(List<MecanismoEvaluacion> mecanismoEvaluacions) {
        this.mecanismoEvaluacions = mecanismoEvaluacions;
    }
}
