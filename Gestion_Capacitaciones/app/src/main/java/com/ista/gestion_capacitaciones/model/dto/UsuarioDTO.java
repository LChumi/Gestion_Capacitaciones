package com.ista.gestion_capacitaciones.model.dto;

import com.ista.gestion_capacitaciones.model.Usuario;

public class UsuarioDTO {

    private Long usu_id;
    private String usu_usuario;
    private String usu_password;

    private Long per_id;

    public UsuarioDTO() {
    }

    public UsuarioDTO(Usuario usuario) {
        this.usu_id = usuario.getId_usuario();
        this.usu_usuario = usuario.getUsername();
        this.usu_password = usuario.getPassword();
        this.per_id = usuario.getPersona().getId_persona();
    }

    public Long getUsu_id() {
        return usu_id;
    }

    public void setUsu_id(Long usu_id) {
        this.usu_id = usu_id;
    }

    public String getUsu_usuario() {
        return usu_usuario;
    }

    public void setUsu_usuario(String usu_usuario) {
        this.usu_usuario = usu_usuario;
    }

    public String getUsu_password() {
        return usu_password;
    }

    public void setUsu_password(String usu_password) {
        this.usu_password = usu_password;
    }

    public Long getPer_id() {
        return per_id;
    }

    public void setPer_id(Long per_id) {
        this.per_id = per_id;
    }
}
