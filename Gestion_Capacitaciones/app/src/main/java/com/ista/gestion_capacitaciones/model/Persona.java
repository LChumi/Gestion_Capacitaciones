/*
 *
 *   Created Luis Chumi on 23/5/23 9:38
 *   Copyright Ⓒ 2023. All rights reserved Ⓒ 2023 http://freefuninfo.com/
 *   Last modified: 21/5/23 18:48
 *
 *   Licensed under the Apache License, Version 2.0 (the "License"); you may not use this file
 *   except in compliance with the License. You may obtain a copy of the License at
 *   http://www.apache.org/licenses/LICENS... Unless required by applicable law or agreed to in writing, software
 *    distributed under the License is distributed on an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND,
 *    either express or implied. See the License for the specific language governing permissions and
 *    limitations under the License.
 * /
 */

package com.ista.gestion_capacitaciones.model;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.ista.gestion_capacitaciones.utils.CustomDateDeserializer;

import java.util.Date;
import java.util.List;

public class Persona {

    private Long id_persona;
    private String cedula;
    private String nombre;
    private String apellido;
    @JsonDeserialize(using = CustomDateDeserializer.class)
    private Date fecha_nacimiento;
    private String email;
    private String direccion;
    private String sexo;
    private String etnia;
    private String telefono;
    private String celular;
    private String nivelintruccion;
    private String hojavida;

    private boolean enabled = true;

    private Usuario usuario;
    private List<FichaInscripcion> fichaIncripcions;
    private List<Participante> participantes;
    private List<Curso> cursos;

    public Long getId_persona() {
        return id_persona;
    }

    public void setId_persona(Long id_persona) {
        this.id_persona = id_persona;
    }

    public String getCedula() {
        return cedula;
    }

    public void setCedula(String cedula) {
        this.cedula = cedula;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public Date getFecha_nacimiento() {
        return fecha_nacimiento;
    }

    public void setFecha_nacimiento(Date fecha_nacimiento) {
        this.fecha_nacimiento = fecha_nacimiento;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public String getEtnia() {
        return etnia;
    }

    public void setEtnia(String etnia) {
        this.etnia = etnia;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getCelular() {
        return celular;
    }

    public void setCelular(String celular) {
        this.celular = celular;
    }

    public String getNivelintruccion() {
        return nivelintruccion;
    }

    public void setNivelintruccion(String nivelintruccion) {
        this.nivelintruccion = nivelintruccion;
    }

    public String getHojavida() {
        return hojavida;
    }

    public void setHojavida(String hojavida) {
        this.hojavida = hojavida;
    }

    public boolean isEnabled() {
        return enabled;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public List<FichaInscripcion> getFichaIncripcions() {
        return fichaIncripcions;
    }

    public void setFichaIncripcions(List<FichaInscripcion> fichaIncripcions) {
        this.fichaIncripcions = fichaIncripcions;
    }

    public List<Participante> getParticipantes() {
        return participantes;
    }

    public void setParticipantes(List<Participante> participantes) {
        this.participantes = participantes;
    }

    public List<Curso> getCursos() {
        return cursos;
    }

    public void setCursos(List<Curso> cursos) {
        this.cursos = cursos;
    }

    @Override
    public String toString() {
        return "Persona{" +
                "id_persona=" + id_persona +
                ", cedula='" + cedula + '\'' +
                ", nombre='" + nombre + '\'' +
                ", apellido='" + apellido + '\'' +
                ", fecha_nacimiento=" + fecha_nacimiento +
                ", email='" + email + '\'' +
                ", direccion='" + direccion + '\'' +
                ", sexo='" + sexo + '\'' +
                ", etnia='" + etnia + '\'' +
                ", telefono='" + telefono + '\'' +
                ", celular='" + celular + '\'' +
                ", nivelintruccion='" + nivelintruccion + '\'' +
                ", hojavida='" + hojavida + '\'' +
                ", enabled=" + enabled +
                ", usuario=" + usuario +
                ", fichaIncripcions=" + fichaIncripcions +
                ", participantes=" + participantes +
                ", cursos=" + cursos +
                '}';
    }
}
