package com.ista.gestion_capacitaciones.model.dto;

import com.ista.gestion_capacitaciones.model.Rol;

public class RolDTO {

    private Long id_rol;
    private String rol_nombre;
    private String descripcion;
    private Boolean enabled;

    public RolDTO() {
    }

    public RolDTO(Rol rol) {
        this.id_rol=rol.getId_rol();
        this.rol_nombre=rol.getRolNombre();
        this.descripcion=rol.getDescripcion();
        this.enabled=rol.isEnabled();
    }

    public Long getId_rol() {
        return id_rol;
    }

    public void setId_rol(Long id_rol) {
        this.id_rol = id_rol;
    }

    public String getRol_nombre() {
        return rol_nombre;
    }

    public void setRol_nombre(String rol_nombre) {
        this.rol_nombre = rol_nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Boolean getEnabled() {
        return enabled;
    }

    public void setEnabled(Boolean enabled) {
        this.enabled = enabled;
    }
}
