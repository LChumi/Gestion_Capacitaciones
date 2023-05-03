package com.ista.gestion_capacitaciones.model.dto;

import com.ista.gestion_capacitaciones.model.Curso;

import java.util.Date;

public class CursoDTO {

    private Long cur_id;
    private Long cur_codigo;
    private String cur_nombre;
    private Date cur_fechaInicio;
    private Date cur_fechaFin;
    private int cur_numHora;
    private int cur_proceso;
    private boolean cur_estado;

    public CursoDTO() {
    }

    public CursoDTO(Curso curso) {
        this.cur_id = curso.getCurId();
        this.cur_codigo = Long.valueOf(curso.getCurCodigo());
        this.cur_nombre = curso.getCurNombre();
        this.cur_fechaInicio = curso.getCurFechainicio();
        this.cur_fechaFin = curso.getCurFechafin();
        this.cur_numHora = curso.getCurNumhoras() != null ? curso.getCurNumhoras() : 0;
        this.cur_proceso = Integer.parseInt(curso.getCurProceso());
        this.cur_estado = curso.getCurEstado();
    }

    public Long getCur_id() {
        return cur_id;
    }

    public void setCur_id(Long cur_id) {
        this.cur_id = cur_id;
    }

    public Long getCur_codigo() {
        return cur_codigo;
    }

    public void setCur_codigo(Long cur_codigo) {
        this.cur_codigo = cur_codigo;
    }

    public String getCur_nombre() {
        return cur_nombre;
    }

    public void setCur_nombre(String cur_nombre) {
        this.cur_nombre = cur_nombre;
    }

    public Date getCur_fechaInicio() {
        return cur_fechaInicio;
    }

    public void setCur_fechaInicio(Date cur_fechaInicio) {
        this.cur_fechaInicio = cur_fechaInicio;
    }

    public Date getCur_fechaFin() {
        return cur_fechaFin;
    }

    public void setCur_fechaFin(Date cur_fechaFin) {
        this.cur_fechaFin = cur_fechaFin;
    }

    public int getCur_numHora() {
        return cur_numHora;
    }

    public void setCur_numHora(int cur_numHora) {
        this.cur_numHora = cur_numHora;
    }

    public int getCur_proceso() {
        return cur_proceso;
    }

    public void setCur_proceso(int cur_proceso) {
        this.cur_proceso = cur_proceso;
    }

    public boolean isCur_estado() {
        return cur_estado;
    }

    public void setCur_estado(boolean cur_estado) {
        this.cur_estado = cur_estado;
    }
}
