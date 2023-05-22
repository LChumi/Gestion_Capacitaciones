package com.ista.gestion_capacitaciones.model;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.ista.gestion_capacitaciones.utils.CustomDateDeserializer;

import java.util.Date;
import java.util.List;

public class NecesidadCurso {

    private Long ncuId;
    private String ncuIdentificador;
    @JsonDeserialize(using = CustomDateDeserializer.class)
    private Date ncuFechaprevisfin;
    private Integer ncuNumparticipantes;
    private String ncuResumenyproyecto;
    private String ncuPoblaciondirigida;
    private String ncuLugardicta;
    private Boolean ncuEstado;

    private Dia dia;
    private List<Curso> cursos;

    public Long getNcuId() {
        return ncuId;
    }

    public void setNcuId(Long ncuId) {
        this.ncuId = ncuId;
    }

    public String getNcuIdentificador() {
        return ncuIdentificador;
    }

    public void setNcuIdentificador(String ncuIdentificador) {
        this.ncuIdentificador = ncuIdentificador;
    }

    public Date getNcuFechaprevisfin() {
        return ncuFechaprevisfin;
    }

    public void setNcuFechaprevisfin(Date ncuFechaprevisfin) {
        this.ncuFechaprevisfin = ncuFechaprevisfin;
    }

    public Integer getNcuNumparticipantes() {
        return ncuNumparticipantes;
    }

    public void setNcuNumparticipantes(Integer ncuNumparticipantes) {
        this.ncuNumparticipantes = ncuNumparticipantes;
    }

    public String getNcuResumenyproyecto() {
        return ncuResumenyproyecto;
    }

    public void setNcuResumenyproyecto(String ncuResumenyproyecto) {
        this.ncuResumenyproyecto = ncuResumenyproyecto;
    }

    public String getNcuPoblaciondirigida() {
        return ncuPoblaciondirigida;
    }

    public void setNcuPoblaciondirigida(String ncuPoblaciondirigida) {
        this.ncuPoblaciondirigida = ncuPoblaciondirigida;
    }

    public String getNcuLugardicta() {
        return ncuLugardicta;
    }

    public void setNcuLugardicta(String ncuLugardicta) {
        this.ncuLugardicta = ncuLugardicta;
    }

    public Boolean getNcuEstado() {
        return ncuEstado;
    }

    public void setNcuEstado(Boolean ncuEstado) {
        this.ncuEstado = ncuEstado;
    }

    public Dia getDia() {
        return dia;
    }

    public void setDia(Dia dia) {
        this.dia = dia;
    }

    public List<Curso> getCursos() {
        return cursos;
    }

    public void setCursos(List<Curso> cursos) {
        this.cursos = cursos;
    }
}
