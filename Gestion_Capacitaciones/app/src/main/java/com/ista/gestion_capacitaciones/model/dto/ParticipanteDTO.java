package com.ista.gestion_capacitaciones.model.dto;

import com.ista.gestion_capacitaciones.model.Participante;

public class ParticipanteDTO {

    private Long par_id;
    private double par_notaParcial;
    private double par_notaFinal;
    private double notaPromedio;
    private String par_observacion;
    private boolean par_estado;

    private Long per_id;

    public ParticipanteDTO() {
    }

    public ParticipanteDTO(Participante participante) {
        this.par_id = participante.getParId();
        this.par_notaParcial = participante.getParNotaparcial();
        this.par_notaFinal = participante.getParNotafinal();
        this.notaPromedio = participante.getParPromedio();
        this.par_observacion = participante.getParObservacion();
        this.par_estado = participante.getParEstado();

        this.per_id=participante.getParPersona().getId_persona();
    }

    public Long getPar_id() {
        return par_id;
    }

    public void setPar_id(Long par_id) {
        this.par_id = par_id;
    }

    public double getPar_notaParcial() {
        return par_notaParcial;
    }

    public void setPar_notaParcial(double par_notaParcial) {
        this.par_notaParcial = par_notaParcial;
    }

    public double getPar_notaFinal() {
        return par_notaFinal;
    }

    public void setPar_notaFinal(double par_notaFinal) {
        this.par_notaFinal = par_notaFinal;
    }

    public double getNotaPromedio() {
        return notaPromedio;
    }

    public void setNotaPromedio(double notaPromedio) {
        this.notaPromedio = notaPromedio;
    }

    public String getPar_observacion() {
        return par_observacion;
    }

    public void setPar_observacion(String par_observacion) {
        this.par_observacion = par_observacion;
    }

    public boolean isPar_estado() {
        return par_estado;
    }

    public void setPar_estado(boolean par_estado) {
        this.par_estado = par_estado;
    }

    public Long getPer_id() {
        return per_id;
    }

    public void setPer_id(Long per_id) {
        this.per_id = per_id;
    }
}
