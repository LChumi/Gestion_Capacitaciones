package com.ista.gestion_capacitaciones.model.dto;

import com.ista.gestion_capacitaciones.model.Persona;

import java.util.Date;

public class PersonaDTO {

    private Long per_id;
    private String per_cedula;
    private String per_nombres;
    private String per_apellidos;
    private Date per_fechaNacimiento;
    private String per_correo;
    private boolean per_estado;

    public PersonaDTO() {
    }

    public PersonaDTO(Persona persona) {
        this.per_id = persona.getId_persona();
        this.per_cedula = persona.getCedula();
        this.per_nombres = persona.getNombre();
        this.per_apellidos = persona.getApellido();
        this.per_fechaNacimiento = persona.getFecha_nacimiento();
        this.per_correo = persona.getEmail();
        this.per_estado = persona.isEnabled();
    }

    public Long getPer_id() {
        return per_id;
    }

    public void setPer_id(Long per_id) {
        this.per_id = per_id;
    }

    public String getPer_cedula() {
        return per_cedula;
    }

    public void setPer_cedula(String per_cedula) {
        this.per_cedula = per_cedula;
    }

    public String getPer_nombres() {
        return per_nombres;
    }

    public void setPer_nombres(String per_nombres) {
        this.per_nombres = per_nombres;
    }

    public String getPer_apellidos() {
        return per_apellidos;
    }

    public void setPer_apellidos(String per_apellidos) {
        this.per_apellidos = per_apellidos;
    }

    public Date getPer_fechaNacimiento() {
        return per_fechaNacimiento;
    }

    public void setPer_fechaNacimiento(Date per_fechaNacimiento) {
        this.per_fechaNacimiento = per_fechaNacimiento;
    }

    public String getPer_correo() {
        return per_correo;
    }

    public void setPer_correo(String per_correo) {
        this.per_correo = per_correo;
    }

    public boolean isPer_estado() {
        return per_estado;
    }

    public void setPer_estado(boolean per_estado) {
        this.per_estado = per_estado;
    }
}
