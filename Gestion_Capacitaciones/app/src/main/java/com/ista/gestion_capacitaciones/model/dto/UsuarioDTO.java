/*
 *
 *   Created Luis Chumi on 23/5/23 9:38
 *   Copyright Ⓒ 2023. All rights reserved Ⓒ 2023 http://freefuninfo.com/
 *   Last modified: 18/5/23 17:05
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

import com.ista.gestion_capacitaciones.model.Usuario;

public class UsuarioDTO {

    private Long usu_id;
    private String usu_usuario;
    private String usu_password;

    private Long per_id;
    private Long rol_id;

    public UsuarioDTO() {
    }

    public UsuarioDTO(Usuario usuario) {
        this.usu_id = usuario.getId_usuario();
        this.usu_usuario = usuario.getUsername();
        this.usu_password = usuario.getPassword();
        this.per_id = usuario.getPersona().getId_persona();
        this.rol_id=usuario.getRol().getId_rol();
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

    public Long getRol_id() {
        return rol_id;
    }

    public void setRol_id(Long rol_id) {
        this.rol_id = rol_id;
    }

    @Override
    public String toString() {
        return "UsuarioDTO{" +
                "usu_id=" + usu_id +
                ", usu_usuario='" + usu_usuario + '\'' +
                ", usu_password='" + usu_password + '\'' +
                ", per_id=" + per_id +
                ", rol_id=" + rol_id +
                '}';
    }
}
