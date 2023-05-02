package com.ista.gestion_capacitaciones.model;

import java.util.List;

public class Horario {

    private Long horId;
    private String horInicio;
    private String horFin;
    private Boolean horEstado;
    private List<HorarioCurso> horarioCursos;

    public Long getHorId() {
        return horId;
    }

    public void setHorId(Long horId) {
        this.horId = horId;
    }

    public String getHorInicio() {
        return horInicio;
    }

    public void setHorInicio(String horInicio) {
        this.horInicio = horInicio;
    }

    public String getHorFin() {
        return horFin;
    }

    public void setHorFin(String horFin) {
        this.horFin = horFin;
    }

    public Boolean getHorEstado() {
        return horEstado;
    }

    public void setHorEstado(Boolean horEstado) {
        this.horEstado = horEstado;
    }

    public List<HorarioCurso> getHorarioCursos() {
        return horarioCursos;
    }

    public void setHorarioCursos(List<HorarioCurso> horarioCursos) {
        this.horarioCursos = horarioCursos;
    }
}
