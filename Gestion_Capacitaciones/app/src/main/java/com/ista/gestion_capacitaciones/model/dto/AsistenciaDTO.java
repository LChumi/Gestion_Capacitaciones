package com.ista.gestion_capacitaciones.model.dto;

import com.ista.gestion_capacitaciones.model.Asistencia;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class AsistenciaDTO {

    private Long asi_id;
    private int asi_numAsistencia;
    private Date asi_fecha;
    private Long par_id;

    public AsistenciaDTO() {
    }

    public AsistenciaDTO(Asistencia asistencia) {
        this.asi_id = asistencia.getAsiId();
        this.asi_numAsistencia = asistencia.getAsiNumfaltas();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        this.asi_fecha=asistencia.getAsiFecha();
        this.par_id = asistencia.getAsiParticipante().getParId();
    }

    public Long getAsi_id() {
        return asi_id;
    }

    public void setAsi_id(Long asi_id) {
        this.asi_id = asi_id;
    }

    public int getAsi_numAsistencia() {
        return asi_numAsistencia;
    }

    public void setAsi_numAsistencia(int asi_numAsistencia) {
        this.asi_numAsistencia = asi_numAsistencia;
    }

    public Date getAsi_fecha() {
        return asi_fecha;
    }

    public void setAsi_fecha(Date asi_fecha) {
        this.asi_fecha = asi_fecha;
    }

    public Long getPar_id() {
        return par_id;
    }

    public void setPar_id(Long par_id) {
        this.par_id = par_id;
    }
}

