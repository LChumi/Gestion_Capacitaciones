/*
 *
 *   Created Luis Chumi on 23/5/23 9:38
 *   Copyright Ⓒ 2023. All rights reserved Ⓒ 2023 http://freefuninfo.com/
 *   Last modified: 17/5/23 22:04
 *
 *   Licensed under the Apache License, Version 2.0 (the "License"); you may not use this file
 *   except in compliance with the License. You may obtain a copy of the License at
 *   http://www.apache.org/licenses/LICENS... Unless required by applicable law or agreed to in writing, software
 *    distributed under the License is distributed on an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND,
 *    either express or implied. See the License for the specific language governing permissions and
 *    limitations under the License.
 * /
 */

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

    public RolDTO(Long id_rol, String rol_nombre, String descripcion, Boolean enabled) {
        this.id_rol = id_rol;
        this.rol_nombre = rol_nombre;
        this.descripcion = descripcion;
        this.enabled = enabled;
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
