/*
 *
 *   Created Luis Chumi on 23/5/23 9:38
 *   Copyright Ⓒ 2023. All rights reserved Ⓒ 2023 http://freefuninfo.com/
 *   Last modified: 16/5/23 22:00
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

public class FichaInscripcion {

    private Long finId;
    private Integer finAprobacion;
    private String finInstituciontraest;
    private String finDireccioninst;
    private String finCorreoinst;
    private String finTelefonoinst;
    private String finActividadinst;
    private Boolean finAuspiciadoinst;
    private String finNombreauspicia;
    private String finComoentero;
    private String finOtroscursosdesea;
    private Boolean finEstado;

    private Persona finPersona;

    private Curso finCurso;
    private HorarioCurso finHorario;

    public Long getFinId() {
        return finId;
    }

    public void setFinId(Long finId) {
        this.finId = finId;
    }

    public Integer getFinAprobacion() {
        return finAprobacion;
    }

    public void setFinAprobacion(Integer finAprobacion) {
        this.finAprobacion = finAprobacion;
    }

    public String getFinInstituciontraest() {
        return finInstituciontraest;
    }

    public void setFinInstituciontraest(String finInstituciontraest) {
        this.finInstituciontraest = finInstituciontraest;
    }

    public String getFinDireccioninst() {
        return finDireccioninst;
    }

    public void setFinDireccioninst(String finDireccioninst) {
        this.finDireccioninst = finDireccioninst;
    }

    public String getFinCorreoinst() {
        return finCorreoinst;
    }

    public void setFinCorreoinst(String finCorreoinst) {
        this.finCorreoinst = finCorreoinst;
    }

    public String getFinTelefonoinst() {
        return finTelefonoinst;
    }

    public void setFinTelefonoinst(String finTelefonoinst) {
        this.finTelefonoinst = finTelefonoinst;
    }

    public String getFinActividadinst() {
        return finActividadinst;
    }

    public void setFinActividadinst(String finActividadinst) {
        this.finActividadinst = finActividadinst;
    }

    public Boolean getFinAuspiciadoinst() {
        return finAuspiciadoinst;
    }

    public void setFinAuspiciadoinst(Boolean finAuspiciadoinst) {
        this.finAuspiciadoinst = finAuspiciadoinst;
    }

    public String getFinNombreauspicia() {
        return finNombreauspicia;
    }

    public void setFinNombreauspicia(String finNombreauspicia) {
        this.finNombreauspicia = finNombreauspicia;
    }

    public String getFinComoentero() {
        return finComoentero;
    }

    public void setFinComoentero(String finComoentero) {
        this.finComoentero = finComoentero;
    }

    public String getFinOtroscursosdesea() {
        return finOtroscursosdesea;
    }

    public void setFinOtroscursosdesea(String finOtroscursosdesea) {
        this.finOtroscursosdesea = finOtroscursosdesea;
    }

    public Boolean getFinEstado() {
        return finEstado;
    }

    public void setFinEstado(Boolean finEstado) {
        this.finEstado = finEstado;
    }

    public Persona getFinPersona() {
        return finPersona;
    }

    public void setFinPersona(Persona finPersona) {
        this.finPersona = finPersona;
    }

    public Curso getFinCurso() {
        return finCurso;
    }

    public void setFinCurso(Curso finCurso) {
        this.finCurso = finCurso;
    }

    public HorarioCurso getFinHorario() {
        return finHorario;
    }

    public void setFinHorario(HorarioCurso finHorario) {
        this.finHorario = finHorario;
    }
}
