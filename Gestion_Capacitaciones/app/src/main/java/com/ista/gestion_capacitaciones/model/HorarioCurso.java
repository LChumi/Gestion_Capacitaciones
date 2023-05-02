package com.ista.gestion_capacitaciones.model;

public class HorarioCurso {

    private Long hcuId;
    private String hcuNombre;
    private Boolean hcuEstado;

    private Horario horario;
    private Curso hcurso;

    public Long getHcuId() {
        return hcuId;
    }

    public void setHcuId(Long hcuId) {
        this.hcuId = hcuId;
    }

    public String getHcuNombre() {
        return hcuNombre;
    }

    public void setHcuNombre(String hcuNombre) {
        this.hcuNombre = hcuNombre;
    }

    public Boolean getHcuEstado() {
        return hcuEstado;
    }

    public void setHcuEstado(Boolean hcuEstado) {
        this.hcuEstado = hcuEstado;
    }

    public Horario getHorario() {
        return horario;
    }

    public void setHorario(Horario horario) {
        this.horario = horario;
    }

    public Curso getHcurso() {
        return hcurso;
    }

    public void setHcurso(Curso hcurso) {
        this.hcurso = hcurso;
    }
}
